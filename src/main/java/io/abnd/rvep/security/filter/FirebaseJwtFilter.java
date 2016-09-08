package io.abnd.rvep.security.filter;

import io.abnd.rvep.security.service.impl.FirebaseAuthVerifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class FirebaseJwtFilter extends GenericFilterBean {

    private static final Logger logger = LoggerFactory.getLogger(FirebaseJwtFilter.class);
    private FirebaseAuthVerifier firebaseAuthVerifier;

    public FirebaseJwtFilter(FirebaseAuthVerifier firebaseAuthVerifier) {
        this.firebaseAuthVerifier = firebaseAuthVerifier;
    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {
        // get http servlet request
        HttpServletRequest req = (HttpServletRequest) request;

        // get idToken
        String idToken = req.getHeader("idtoken");

        try {
            this.firebaseAuthVerifier.verify(idToken);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new ServletException(e);
        }

        // all good, continue with chain
        chain.doFilter(req, response);
    }

}
