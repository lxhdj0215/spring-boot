package com.lxhdj.dao.cache;

import com.jd.jim.cli.ReloadableJimClientFactoryBean;
import com.jd.jim.cli.config.client.ConfigClient;
import com.jd.jim.cli.config.client.ConfigLongPollingClientFactoryBean;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(JimProperties.class)
@AllArgsConstructor
public class JimConfig {

    private JimProperties jimProperties;

    @Bean
    public ConfigLongPollingClientFactoryBean configClient() {
        ConfigLongPollingClientFactoryBean configClient = new ConfigLongPollingClientFactoryBean();
        String serviceEndpoint = jimProperties.getServiceEndpoint();
        configClient.setServiceEndpoint(serviceEndpoint);
        return configClient;
    }


    @Bean
    public ReloadableJimClientFactoryBean jimClient(ConfigClient client) throws Exception {
        ReloadableJimClientFactoryBean jimClient = new ReloadableJimClientFactoryBean();
        jimClient.setConfigClient(client);
        jimClient.setJimUrl(jimProperties.getJimUrl());
        return jimClient;
    }


}
