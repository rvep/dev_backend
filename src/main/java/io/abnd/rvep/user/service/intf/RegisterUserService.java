package io.abnd.rvep.user.service.intf;

public interface RegisterUserService {

    boolean isUserRegistered(String email);

    boolean registerUser(String email, String provider);

}
