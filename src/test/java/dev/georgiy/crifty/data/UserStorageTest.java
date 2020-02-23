package dev.georgiy.crifty.data;

import dev.georgiy.crifty.messanger.data.UserStorage;
import dev.georgiy.crifty.messanger.data.beans.User;
import dev.georgiy.crifty.messanger.data.inmemory.UserStorageImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class UserStorageTest {
    @Test
    public void createUserTest(){
        UserStorage userStorage = new UserStorageImpl();
        User user = new User();
        String id = user.getId();
        userStorage.addUser(user);
        Assertions.assertTrue( userStorage.isRegistered(id), "The user must be found");
    }

    @Test
    public void deleteUser(){
        UserStorage userStorage = new UserStorageImpl();
        User user = new User();
        String id = user.getId();
        userStorage.addUser(user);
        userStorage.deleteUser(id);
        Assertions.assertTrue( userStorage.isRegistered(id), "The user must be deleted");
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
