package dev.georgiy.crifty.messanger.data.inmemory;

import dev.georgiy.crifty.messanger.data.beans.User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserBucket {
    private Map<User, MessageBucket> buckets = new ConcurrentHashMap<>();

}
