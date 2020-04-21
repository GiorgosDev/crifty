package dev.georgiy.crifty.data;

import dev.georgiy.crifty.messanger.data.MessageStorage;
import dev.georgiy.crifty.messanger.data.UserStorage;
import dev.georgiy.crifty.messanger.data.beans.User;
import dev.georgiy.crifty.messanger.data.inmemory.MessageStorageImpl;
import dev.georgiy.crifty.messanger.data.inmemory.UserStorageImpl;
import dev.georgiy.crifty.messanger.services.message.beans.Message;
import dev.georgiy.crifty.messanger.services.user.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class MessageStorageTest {
    @Test
    public void addMessageTest() {
        MessageStorageImpl storage = new MessageStorageImpl();
        UserStorage userStorage = new UserStorageImpl();
        User user = new User();
        String id = user.getId();
        userStorage.addUser(user);
        storage.setUserStorage(userStorage);
        storage.addMessage(new Message("aaa", id,"message1", LocalDateTime.now()), new User("aaa"), new User(id));
        Assertions.assertEquals(1, storage.getMessages(new User(id)).size());
    }

    @Test
    public void getMessagesTest() {
        MessageStorageImpl storage = new MessageStorageImpl();
        storage.setUserStorage(new UserStorageImpl());
        storage.addMessage(new Message("aaa", "bbb","message1", LocalDateTime.now()), new User("aaa"), new User("bbb"));
        storage.getMessages(new User("bbb"));
    }
}
