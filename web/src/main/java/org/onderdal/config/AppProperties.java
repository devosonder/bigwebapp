package org.onderdal.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by onder.dal on 29.10.2015.
 * package: org.onderdal.config
 * @author onder.dal
 */
@ConfigurationProperties(prefix = "app")
@Component
public class AppProperties {
    private String url;

    private String defaultEmailSender;

    private String geoIp2CityDatabaseFile;

    private String applicationName;

    /**
     * Gets url.
     * @author onder.dal *
     * @return the url
     */
    public String getUrl() {
        return this.url;
    }

    /**
     * Sets url.
     * @author onder.dal *
     * @param url the url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Gets default email sender.
     * @author onder.dal *
     * @return the default email sender
     */
    public String getDefaultEmailSender() {
        return this.defaultEmailSender;
    }

    /**
     * Sets default email sender.
     * @author onder.dal *
     * @param defaultEmailSender the default email sender
     */
    public void setDefaultEmailSender(String defaultEmailSender) {
        this.defaultEmailSender = defaultEmailSender;
    }

    /**
     * Gets geo ip 2 city database file.
     * @author onder.dal *
     * @return the geo ip 2 city database file
     */
    public String getGeoIp2CityDatabaseFile() {
        return this.geoIp2CityDatabaseFile;
    }

    /**
     * Sets geo ip 2 city database file.
     * @author onder.dal *
     * @param geoIp2CityDatabaseFile the geo ip 2 city database file
     */
    public void setGeoIp2CityDatabaseFile(String geoIp2CityDatabaseFile) {
        this.geoIp2CityDatabaseFile = geoIp2CityDatabaseFile;
    }

    /**
     * Gets application name.
     * @author onder.dal *
     * @return the application name
     */
    public String getApplicationName() {
        return this.applicationName;
    }

    /**
     * Sets application name.
     * @author onder.dal *
     * @param applicationName the application name
     */
    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }
}
