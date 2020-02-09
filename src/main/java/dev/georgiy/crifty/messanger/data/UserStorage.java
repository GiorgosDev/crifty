package dev.georgiy.crifty.messanger.data;

import dev.georgiy.crifty.messanger.data.beans.User;

public interface UserStorage {
    void addUser(User user);
    boolean isRegistered(String userId);
    void deleteUser(String userId);
    boolean isRegistered(String userId, String token);
}
