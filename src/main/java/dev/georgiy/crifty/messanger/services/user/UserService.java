package dev.georgiy.crifty.messanger.services.user;

import dev.georgiy.crifty.messanger.services.user.beans.RegistrationResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserService {
    @RequestMapping(value = "/registration")
    public RegistrationResponse getNextGeneration() {
        //todo generate uuid and token
        //todo create a new user
        //todo return registration response
        return new RegistrationResponse();
    }
}
