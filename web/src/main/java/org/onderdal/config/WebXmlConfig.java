package org.onderdal.config;

import com.hazelcast.web.SessionListener;
import com.hazelcast.web.WebFilter;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.DispatcherType;
import javax.servlet.http.HttpSessionListener;
import java.util.Locale;

/**
 * Created by onder.dal on 04.11.2015.
 *
 * @author onder.dal
 */
@Configuration
public class WebXmlConfig {
    /**
     * Hazelcast wm filter.
     *
     * @return the filter registration bean
     * @author onder.dal *
     */
    @Bean
    public FilterRegistrationBean hazelcastWmFilter() {
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

    /**
     * Hazelcast session listener.
     *
     * @return the http session listener
     * @author onder.dal *
     */
    @Bean
    public HttpSessionListener hazelcastSessionListener() {
        return new SessionListener();
    }

    /**
     * Locale resolver.
     *
     * @return the locale resolver
     * @author onder.dal *
     */
    @Bean
    public LocaleResolver localeResolver() {
        AppLocaleResolver resolver = new AppLocaleResolver();
        resolver.setDefaultLocale(Locale.ENGLISH);
        return resolver;
    }
}
