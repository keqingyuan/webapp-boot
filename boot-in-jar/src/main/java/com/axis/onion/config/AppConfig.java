package com.axis.onion.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Qingyuan on 2019-06-06.
 */
//@PropertySource(value={"classpath:application.properties"})
@Component
public class AppConfig {

    @Value("${server.port}")
    private String port;
    @Value("${htpasswd2UpdateCommand}")
    private String htpasswd2UpdateCommand;
    @Value("${htpasswd2UpdateCommandForTest}")
    private String htpasswd2UpdateCommandForTest;
    @Value("${ipWhiteList}")
    private String ipWhiteList;

    public String getHtpasswd2UpdateCommand() {
        return htpasswd2UpdateCommand;
    }

    public String getHtpasswd2UpdateCommandForTest() {
        return htpasswd2UpdateCommandForTest;
    }

    public String getIpWhiteList() {
        return ipWhiteList;
    }
    public String getPort() {
        return port;
    }
}
