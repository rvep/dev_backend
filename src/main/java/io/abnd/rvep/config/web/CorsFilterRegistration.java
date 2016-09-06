package io.abnd.rvep.config.web;

import io.abnd.rvep.config.properties.CorsProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsFilterRegistration {

    @Autowired
    private CorsProperties corsProperties;

    @Bean
    public FilterRegistrationBean corsFilter() {
        // setup origin url
        String origin = corsProperties.getHost() + ":" +
                        corsProperties.getPort();

        // setup cors config
        CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.setAllowCredentials(true);
        corsConfig.addAllowedOrigin(origin);
        corsConfig.addAllowedHeader("*");
        corsConfig.addAllowedMethod("*");

        // setup source
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/api/**", corsConfig);
        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        bean.setOrder(0);

        return bean;
    }

}
