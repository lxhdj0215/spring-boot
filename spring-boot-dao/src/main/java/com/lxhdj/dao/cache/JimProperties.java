package com.lxhdj.dao.cache;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Accessors(chain = true)
@Data
@ConfigurationProperties(prefix = "mti.base.jim")
public class JimProperties {

    private String serviceEndpoint;
    private String jimUrl;
    private int entryTimeout = 864000;

}
