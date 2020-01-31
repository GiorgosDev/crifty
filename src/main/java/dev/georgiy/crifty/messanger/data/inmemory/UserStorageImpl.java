package dev.georgiy.crifty.messanger.data.inmemory;

import dev.georgiy.crifty.messanger.data.UserStorage;
import dev.georgiy.crifty.messanger.data.beans.User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserStorageImpl implements UserStorage {
    private Map<User, UserBucket> buckets = new ConcurrentHashMap<>();

    @Override
    public void addUser(User user) {
        buckets.put(user, new UserBucket());
    }

    @Override
    public void deleteUser(String userId) {
        buckets.put(new User(userId), new UserBucket());
    }
}
