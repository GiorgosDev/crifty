package dev.georgiy.crifty.data;

import dev.georgiy.crifty.messanger.data.MessageStorage;
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
        MessageStorage storage = new MessageStorageImpl();
        storage.addMessage(new Message("aaa", "bbb","message1", LocalDateTime.now()), new User("aaa"), new User("bbb"));
        Assertions.assertEquals(1, storage.getMessages(new User("bbb")).size());
    }

    @Test
    public void getMessagesTest() {
        MessageStorage storage = new MessageStorageImpl();
        storage.addMessage(new Message("aaa", "bbb","message1", LocalDateTime.now()), new User("aaa"), new User("bbb"));
        storage.getMessages(new User("bbb"));
    }
}
