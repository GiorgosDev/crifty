package dev.georgiy.crifty.messanger.data.inmemory;

import dev.georgiy.crifty.messanger.data.beans.User;
import dev.georgiy.crifty.messanger.services.message.beans.Message;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MessageBucket {

    private List<Message> buckets = Collections.synchronizedList(new ArrayList<>());

    public void addMessage(Message message){
        buckets.add(message);
    }

    public List<Message> getBuckets() {
        return buckets;
    }

}
