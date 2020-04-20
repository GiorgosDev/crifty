package dev.georgiy.crifty.messanger.services.user;

import dev.georgiy.crifty.messanger.data.UserStorage;
import dev.georgiy.crifty.messanger.data.beans.User;
import dev.georgiy.crifty.messanger.services.user.beans.RegistrationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserService {
    @Autowired
    protected UserStorage storage;

    @RequestMapping(value = "/registration")
    public RegistrationResponse getNextGeneration() {
        User user = new User();
        storage.addUser(user);
        return new RegistrationResponse(user.getId());
    }
}
