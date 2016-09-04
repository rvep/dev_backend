package io.abnd.rvep.config.auth;

import io.abnd.rvep.security.filter.JwtFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtFilterRegistration {

    @Bean
    public FilterRegistrationBean jwtFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new JwtFilter());
        filterRegistrationBean.addUrlPatterns("/api/app/*");

        return filterRegistrationBean;
    }

}
