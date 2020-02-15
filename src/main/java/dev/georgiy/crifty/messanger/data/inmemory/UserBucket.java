package dev.georgiy.crifty.messanger.data.inmemory;

import dev.georgiy.crifty.messanger.data.beans.User;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class UserBucket {
    //from user, messages
    private Map<User, MessageBucket> buckets = new ConcurrentHashMap<>();
    private Set<String> tokens = ConcurrentHashMap.newKeySet();

    public String createToken(){
        String token = UUID.randomUUID().toString();
        tokens.add(token);
        return token;
    }

    public boolean isValidToken(String token){
        return tokens.contains(token);
    }
}
