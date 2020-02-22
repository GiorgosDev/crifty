package dev.georgiy.crifty.messanger.data;

import dev.georgiy.crifty.messanger.data.beans.User;
import dev.georgiy.crifty.messanger.services.message.beans.Message;

import java.util.List;

public interface MessageStorage {
    void addMessage(Message message, User sender,  User receiver);
    List<Message> getMessages(String lastId, User sender, User receiver);
    List<Message> getMessages(User sender, User receiver);
    List<Message> getMessages(User receiver);
}
