package dev.georgiy.crifty.messanger.data;

import dev.georgiy.crifty.messanger.data.beans.User;
import dev.georgiy.crifty.messanger.services.message.beans.Message;

public interface MessageStorage {
    void addMessage(Message message, User receiver);
    void getMessages(String lastId, User sender, User receiver);
}
