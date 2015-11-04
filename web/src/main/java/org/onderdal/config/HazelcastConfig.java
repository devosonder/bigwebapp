package org.onderdal.config;

import com.hazelcast.config.*;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.web.SessionListener;
import com.hazelcast.web.WebFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

import javax.servlet.DispatcherType;
import javax.servlet.http.HttpSessionListener;
import java.util.Arrays;

/**
 * Created by onder.dal on 04.11.2015.
 */
@Configuration
public class HazelcastConfig {

    @Value("${hazelcast.members}")
    private String hazelcastMembers;

    @Bean
    public FilterRegistrationBean hazelcastWmFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebFilter());
        filterRegistrationBean.setAsyncSupported(true);
        filterRegistrationBean.addInitParameter("map-name", "bigwebapp-sessions");
        filterRegistrationBean.addInitParameter("map-sticky-session", "false");
        filterRegistrationBean.addInitParameter("debug", "true");
        filterRegistrationBean.addInitParameter("use-client", "false");
        filterRegistrationBean.addInitParameter("instance-name", "bigwebapp");
        filterRegistrationBean.addInitParameter("instance-deferred-write", "true");
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setDispatcherTypes(DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE);
        filterRegistrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return filterRegistrationBean;
    }

    @Bean
    public HttpSessionListener hazelcastSessionListener(){
        return new SessionListener();
    }

    @Bean
    @Autowired
    public HazelcastInstance hazelcastInstance() {
        final Config config = new Config();
        GroupConfig groupConfig = new GroupConfig();
        groupConfig.setName("bigwebdev");
        groupConfig.setPassword("p@ssword");
        config.setGroupConfig(groupConfig);

        final NetworkConfig networkConfig = new NetworkConfig();
        networkConfig.setPortAutoIncrement(true);
        networkConfig.setPortCount(100);
        networkConfig.setPort(5701);
        config.setNetworkConfig(networkConfig);

        final JoinConfig joinConfig = new JoinConfig();
        networkConfig.setJoin(joinConfig);

        final MulticastConfig multicastConfig = new MulticastConfig();
        multicastConfig.setEnabled(false);
        joinConfig.setMulticastConfig(multicastConfig);

        final TcpIpConfig tcpIpConfig = new TcpIpConfig();
        tcpIpConfig.setEnabled(true);
        String[] hazelcastMembersArr = hazelcastMembers.split(",");
        tcpIpConfig.setMembers(Arrays.asList(hazelcastMembersArr));


        joinConfig.setTcpIpConfig(tcpIpConfig);

        final AwsConfig awsConfig = new AwsConfig();
        awsConfig.setEnabled(false);
        joinConfig.setAwsConfig(awsConfig);

        final SSLConfig sslConfig = new SSLConfig();
        sslConfig.setEnabled(false);
        networkConfig.setSSLConfig(sslConfig);

        final MapConfig mapConfig = new MapConfig();
        mapConfig.setName("default");
        mapConfig.setInMemoryFormat(InMemoryFormat.BINARY);
        mapConfig.setBackupCount(1);
        mapConfig.setReadBackupData(false);
        mapConfig.setAsyncBackupCount(0);
        mapConfig.setTimeToLiveSeconds(0);
        mapConfig.setMaxIdleSeconds(0);
        mapConfig.setEvictionPolicy(EvictionPolicy.NONE);
        MaxSizeConfig maxSizeConfig = new MaxSizeConfig(0, MaxSizeConfig.MaxSizePolicy.PER_NODE);
        mapConfig.setMaxSizeConfig(maxSizeConfig);
        mapConfig.setEvictionPercentage(25);
        mapConfig.setMergePolicy("com.hazelcast.map.merge.PassThroughMergePolicy");

        /*final MapStoreConfig mapStoreConfig = new MapStoreConfig();
        mapStoreConfig.setEnabled(false);
        mapStoreConfig.setWriteDelaySeconds(60);
        mapStoreConfig.setInitialLoadMode(MapStoreConfig.InitialLoadMode.LAZY);
        mapStoreConfig.setImplementation(userMapStore);
        mapConfig.setMapStoreConfig(mapStoreConfig);*/
        config.addMapConfig(mapConfig);


        return Hazelcast.newHazelcastInstance(config);
    }
}
