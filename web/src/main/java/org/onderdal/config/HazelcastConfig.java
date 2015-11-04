package org.onderdal.config;

import com.hazelcast.config.*;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * Created by onder.dal on 04.11.2015.
 */
@Configuration
public class HazelcastConfig {
    @Value("${hazelcast.members}")
    private String hazelcastMembers;
    /**
     * Hazelcast instance.
     * @author onder.dal *
     * @return the hazelcast instance
     */
    @Bean
    @Autowired
    public HazelcastInstance hazelcastInstance() {
        final Config config = new Config();
        GroupConfig groupConfig = new GroupConfig();
//        groupConfig.setName("dev");
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
        String[] hazelcastMembersArr = hazelcastMembers.replace(" ","").split(",");
        if (hazelcastMembersArr.length != 1 || !hazelcastMembersArr[0].toString().isEmpty()) {
            tcpIpConfig.setMembers(Arrays.asList(hazelcastMembersArr));

        }


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
