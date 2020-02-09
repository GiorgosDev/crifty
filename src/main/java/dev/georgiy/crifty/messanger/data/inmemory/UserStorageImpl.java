package dev.georgiy.crifty.messanger.data.inmemory;

import dev.georgiy.crifty.messanger.data.UserStorage;
import dev.georgiy.crifty.messanger.data.beans.User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserStorageImpl implements UserStorage {
    private Map<User, UserBucket> buckets = new ConcurrentHashMap<>();

    @Override
    public String addUser(User user) {
        UserBucket bucket = new UserBucket();
        buckets.put(user, bucket);
        String token = bucket.createToken();
        return token;
    }

    @Override
    public boolean isRegistered(String id) {
        User user = new User(id);
        return buckets.containsKey(user);
    }


    @Override
    public void deleteUser(String userId) {
        buckets.put(new User(userId), new UserBucket());
    }

    @Override
    public boolean isRegistered(String userId, String token) {
        UserBucket bucket = buckets.get(new User(userId));
        return bucket!=null && bucket.isValidToken(token);
    }
}
