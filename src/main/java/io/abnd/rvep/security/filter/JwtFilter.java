package io.abnd.rvep.security.filter;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class JwtFilter extends GenericFilterBean {

    private static final Logger logger = LoggerFactory.getLogger(JwtFilter.class);

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        // get http servlet request
        HttpServletRequest req = (HttpServletRequest)request;

        // get idToken
        String idToken = req.getHeader("idtoken");

        // validate jwt
        try {
            logger.info("attempting rvep jwt validation with idToken: ");
            logger.info(idToken);
            Jwts.parser().setSigningKey("secretkey")
                    .parseClaimsJws(idToken);
        } catch (SignatureException e) {
            // claims may have been tampered with throw error
            throw new ServletException("Invalid token.");
        }

        // validation success, continue processing
        chain.doFilter(req, response);
    }
}
