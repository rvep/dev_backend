package io.abnd.rvep.config.auth;

import io.abnd.rvep.security.filter.FirebaseJwtFilter;
import io.abnd.rvep.security.service.impl.FirebaseAuthVerifier;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FirebaseJwtFilterRegistration {

    private FirebaseAuthVerifier firebaseAuthVerifier;

    public FirebaseJwtFilterRegistration(FirebaseAuthVerifier firebaseAuthVerifier) {
        this.firebaseAuthVerifier = firebaseAuthVerifier;
    }

    @Bean
    public FilterRegistrationBean firebaseJwtFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new FirebaseJwtFilter(this.firebaseAuthVerifier));
        filterRegistrationBean.addUrlPatterns("/api/registration/*");
        filterRegistrationBean.setOrder(1);

        return filterRegistrationBean;
    }

}
