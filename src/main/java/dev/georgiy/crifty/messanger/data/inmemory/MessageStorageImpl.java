package dev.georgiy.crifty.messanger.data.inmemory;

import dev.georgiy.crifty.messanger.data.MessageStorage;
import dev.georgiy.crifty.messanger.data.UserStorage;
import dev.georgiy.crifty.messanger.data.beans.User;
import dev.georgiy.crifty.messanger.services.message.beans.Message;
import org.springframework.beans.factory.annotation.Autowired;

public class MessageStorageImpl implements MessageStorage {

    @Autowired
    UserStorage userStorage;

    @Override
    public void addMessage(Message message, User receiver) {

    }

    @Override
    public void getMessages(String lastId, User sender, User receiver) {

    }
}
