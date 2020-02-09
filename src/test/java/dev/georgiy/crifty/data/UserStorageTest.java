package dev.georgiy.crifty.data;

import dev.georgiy.crifty.messanger.data.UserStorage;
import dev.georgiy.crifty.messanger.data.beans.User;
import dev.georgiy.crifty.messanger.data.inmemory.UserStorageImpl;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

public class UserStorageTest {
    @Test
    public void createUserTest(){
        UserStorage userStorage = new UserStorageImpl();
        User user = new User();
        String id = user.getId();
        userStorage.addUser(user);
        Assert.isTrue( userStorage.isRegistered(id), "The user must be found");
    }

    @Test
    public void deleteUser(){
        UserStorage userStorage = new UserStorageImpl();
        User user = new User();
        String id = user.getId();
        userStorage.addUser(user);
        userStorage.deleteUser(id);
        Assert.isTrue( userStorage.isRegistered(id), "The user must be deleted");
    }

    @Test
    public void verifyUser(){
        UserStorage userStorage = new UserStorageImpl();
        User user = new User();
        String id = user.getId();
        String token = userStorage.addUser(user);
        userStorage.isRegistered(id, token);
    }
}
