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
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
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
        //todo simplify api to get last n messages
        //todo simplify api to get messages after message id
        storage.addMessage(new Message("aaa", id,"message1", LocalDateTime.now()), "aaa", id);
        List<Message> messages = storage.getMessages( "aaa",id);
        Assertions.assertEquals(1, messages.size());
    }

    @Test
    public void getMessagesFromDateTest() {

        storage.addMessage(new Message("aaa", id,"message0", LocalDateTime.now()), "aaa", id);
        storage.addMessage(new Message("aaa", id,"message1", LocalDateTime.now().minus(1, ChronoUnit.DAYS)), "aaa", id);
        storage.addMessage(new Message("aaa", id,"message2", LocalDateTime.now().minus(2, ChronoUnit.DAYS)), "aaa", id);
        storage.addMessage(new Message("aaa", id,"message3", LocalDateTime.now().minus(3, ChronoUnit.DAYS)), "aaa", id);
        List<Message> messages = storage.getMessages( "aaa",id,LocalDateTime.now().minus(3, ChronoUnit.HOURS));
        Assertions.assertEquals(1, messages.size());
        messages = storage.getMessages( "aaa",id,LocalDateTime.now().minus(1, ChronoUnit.DAYS).minus(3, ChronoUnit.HOURS));
        Assertions.assertEquals(2, messages.size());
        messages = storage.getMessages( "aaa",id,LocalDateTime.now().minus(2, ChronoUnit.DAYS).minus(3, ChronoUnit.HOURS));
        Assertions.assertEquals(3, messages.size());
    }

    @Test
    public void getMessagesFromIdTest() {

        Message message0 = new Message("aaa", id,"message0", LocalDateTime.now());
        Message message1 = new Message("aaa", id,"message1", LocalDateTime.now().minus(1, ChronoUnit.DAYS));
        Message message2 =new Message("aaa", id,"message2", LocalDateTime.now().minus(2, ChronoUnit.DAYS));
        Message message3 =new Message("aaa", id,"message3", LocalDateTime.now().minus(3, ChronoUnit.DAYS));
        storage.addMessage(message3,"aaa", id );
        storage.addMessage(message2,"aaa", id );
        storage.addMessage(message1,"aaa", id );
        storage.addMessage(message0,"aaa", id );
        List<Message> messages = storage.getMessages( "aaa",id,message1.getId());
        Assertions.assertEquals(1, messages.size());
        messages = storage.getMessages( "aaa",id,message2.getId());
        Assertions.assertEquals(2, messages.size());
        messages = storage.getMessages( "aaa",id,message3.getId());
        Assertions.assertEquals(3, messages.size());
    }

    @Test
    public void getMessagesLastLinitTest() {

        Message message0 = new Message("aaa", id,"message0", LocalDateTime.now());
        Message message1 = new Message("aaa", id,"message1", LocalDateTime.now().minus(1, ChronoUnit.DAYS));
        Message message2 =new Message("aaa", id,"message2", LocalDateTime.now().minus(2, ChronoUnit.DAYS));
        Message message3 =new Message("aaa", id,"message3", LocalDateTime.now().minus(3, ChronoUnit.DAYS));
        storage.addMessage(message3,"aaa", id );
        storage.addMessage(message2,"aaa", id );
        storage.addMessage(message1,"aaa", id );
        storage.addMessage(message0,"aaa", id );
        List<Message> messages = storage.getMessages( "aaa",id,1);
        Assertions.assertEquals(1, messages.size());
        Assertions.assertEquals(message0, messages.get(0));
        messages = storage.getMessages( "aaa",id,2);
        Assertions.assertEquals(2, messages.size());
        Assertions.assertEquals(message1, messages.get(0));
        Assertions.assertEquals(message0, messages.get(1));
        messages = storage.getMessages( "aaa",id,5);
        Assertions.assertEquals(4, messages.size());
        Assertions.assertEquals(message3, messages.get(0));
        Assertions.assertEquals(message0, messages.get(3));



    }
}
