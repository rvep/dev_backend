package io.abnd.rvep.security.service.intf;

public interface JwtGenerator {
    String generateIdToken(String username);
}
