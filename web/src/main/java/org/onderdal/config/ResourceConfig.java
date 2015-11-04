package org.onderdal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

/**
 * Created by onder.dal on 04.11.2015.
 */
@Configuration
public class ResourceConfig {
    @Bean
    public ReloadableResourceBundleMessageSource resourceBundle() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:lang/messages");
        messageSource.setCacheSeconds(2700); //reload messages every 10 seconds
        return messageSource;
    }
}
