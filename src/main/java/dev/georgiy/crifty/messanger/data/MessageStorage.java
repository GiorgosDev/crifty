package dev.georgiy.crifty.messanger.data;

import dev.georgiy.crifty.messanger.data.beans.User;
import dev.georgiy.crifty.messanger.data.inmemory.MessageBucket;
import dev.georgiy.crifty.messanger.services.message.beans.Message;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface MessageStorage {
    void addMessage(Message message, String sender,  String receiver);
    List<Message> getMessages(String senderId, String receiverId, String lastId);
    List<Message> getMessages(String senderId, String receiverId, int lastLimit);
    List<Message> getMessages(String sender, String receiver, LocalDateTime from);
    List<Message> getMessages(String senderId, String receiverId);
    Map<User, MessageBucket> getMessages(String receiverId);
}
