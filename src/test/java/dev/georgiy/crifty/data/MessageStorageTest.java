package dev.georgiy.crifty.data;

import dev.georgiy.crifty.messanger.data.UserStorage;
import dev.georgiy.crifty.messanger.data.beans.User;
import dev.georgiy.crifty.messanger.data.inmemory.MessageStorageImpl;
import dev.georgiy.crifty.messanger.data.inmemory.UserStorageImpl;
import dev.georgiy.crifty.messanger.services.message.beans.Message;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

public class MessageStorageTest {
    MessageStorageImpl storage;
    UserStorage userStorage;
    User user;
    String id;

    @BeforeEach
    public void init(){
        storage = new MessageStorageImpl();
        userStorage = new UserStorageImpl();
        user = new User();
        id = user.getId();
        userStorage.addUser(user);
        storage.setUserStorage(userStorage);
    }


    @Test
    public void addMessageTest() {
        storage.addMessage(new Message("aaa", id,"message1", LocalDateTime.now()), "aaa",id);
        Assertions.assertEquals(1, storage.getMessages(id).size());
    }

    @Test
    public void getMessagesTest() {
        //todo simplify api to get last messages since time
        //todo simplify api to get last n messages
        //todo simplify api to get messages after message id
        storage.addMessage(new Message("aaa", id,"message1", LocalDateTime.now()), "aaa", id);
        List<Message> messages = storage.getMessages( "aaa",id);
        Assertions.assertEquals(1, messages.size());
    }
}
