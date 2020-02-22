package dev.georgiy.crifty.messanger.data.inmemory;

import dev.georgiy.crifty.messanger.data.MessageStorage;
import dev.georgiy.crifty.messanger.data.UserStorage;
import dev.georgiy.crifty.messanger.data.beans.User;
import dev.georgiy.crifty.messanger.services.message.beans.Message;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MessageStorageImpl implements MessageStorage {

    @Autowired
    UserStorage userStorage;


    @Override
    public void addMessage(Message message, User sender, User receiver) {

    }

    @Override
    public List<Message> getMessages(String lastId, User sender, User receiver) {
        return null;
    }

    @Override
    public List<Message> getMessages(User sender, User receiver) {
        return null;
    }

    @Override
    public List<Message> getMessages(User receiver) {
        return null;
    }
}
