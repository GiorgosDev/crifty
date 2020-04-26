package dev.georgiy.crifty.messanger.data.inmemory;

import dev.georgiy.crifty.messanger.data.MessageStorage;
import dev.georgiy.crifty.messanger.data.UserStorage;
import dev.georgiy.crifty.messanger.data.beans.User;
import dev.georgiy.crifty.messanger.services.message.beans.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

@Controller
public class MessageStorageImpl implements MessageStorage {

    @Autowired
    private UserStorage userStorage;


    @Override
    public void addMessage(Message message, String sender, String receiver) {
        UserBucket receiverBucket = userStorage.getBucket(new User(receiver));
        Map<User, MessageBucket> buckets = receiverBucket.getBuckets();
        buckets.putIfAbsent(new User(sender), new MessageBucket());
        MessageBucket bucket = buckets.get(new User(sender));
        bucket.addMessage(message);
    }

    @Override
    public List<Message> getMessages(String lastId, String sender, String receiver) {
        return null;
    }

    @Override
    public List<Message> getMessages(String sender, String receiver) {
        UserBucket userBucket = userStorage.getBucket(new User(receiver));
        MessageBucket messageBucket = userBucket.getBuckets().getOrDefault(new User(sender), new MessageBucket());
        return messageBucket.getBuckets();
    }

    @Override
    public Map<User, MessageBucket> getMessages(String receiver) {
        return userStorage.getBucket(new User(receiver)).getBuckets();
    }

    public UserStorage getUserStorage() {
        return userStorage;
    }

    public void setUserStorage(UserStorage userStorage) {
        this.userStorage = userStorage;
    }
}
