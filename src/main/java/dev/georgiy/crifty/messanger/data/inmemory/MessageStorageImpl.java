package dev.georgiy.crifty.messanger.data.inmemory;

import dev.georgiy.crifty.messanger.data.MessageStorage;
import dev.georgiy.crifty.messanger.data.UserStorage;
import dev.georgiy.crifty.messanger.data.beans.User;
import dev.georgiy.crifty.messanger.services.message.beans.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    public List<Message> getMessages(String sender, String receiver, String lastId) {
        UserBucket userBucket = userStorage.getBucket(new User(receiver));
        MessageBucket messageBucket = userBucket.getBuckets().getOrDefault(new User(sender), new MessageBucket());
        List<Message> messages = messageBucket.getBuckets();
        List<Message> res = new ArrayList<>();
        int lastIndex = 0;
        for(int i = messages.size()-1; i>=0; i--){
            if(messages.get(i).getId().equals(lastId)){
                lastIndex = i;
                break;
            }
        }
        if(lastIndex<messages.size()-1) res = messages.subList(lastIndex+1,messages.size());
        return res;
    }

    @Override
    public List<Message> getMessages(String sender, String receiver, int lastLimit) {
        UserBucket userBucket = userStorage.getBucket(new User(receiver));
        MessageBucket messageBucket = userBucket.getBuckets().getOrDefault(new User(sender), new MessageBucket());
        List<Message> messages = messageBucket.getBuckets();
        List<Message> res = new ArrayList<>();
        return lastLimit >= messages.size() ? messages : messages.subList(messages.size() - lastLimit,messages.size());
    }

    @Override
    public List<Message> getMessages(String sender, String receiver, LocalDateTime from) {
        UserBucket userBucket = userStorage.getBucket(new User(receiver));
        MessageBucket messageBucket = userBucket.getBuckets().getOrDefault(new User(sender), new MessageBucket());
        return messageBucket.getBuckets().parallelStream().filter(m -> m.getTimestamp().isAfter(from)).collect(Collectors.toList());
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
