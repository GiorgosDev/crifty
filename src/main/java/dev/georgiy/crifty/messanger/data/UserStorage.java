package dev.georgiy.crifty.messanger.data;

import dev.georgiy.crifty.messanger.data.beans.User;
import dev.georgiy.crifty.messanger.data.inmemory.UserBucket;

public interface UserStorage {
    String addUser(User user);
    boolean isRegistered(String userId);
    void deleteUser(String userId);
    boolean isRegistered(String userId, String token);
    UserBucket getBucket(User user);
}
