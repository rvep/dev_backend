package io.abnd.rvep.config.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.yml")
public class CorsProperties {

    @Value("${cors.host}")
    private String host;
    @Value("${cors.port}")
    private String port;

    public String getHost() { return this.host; }
    public String getPort() { return this.port; }

}
