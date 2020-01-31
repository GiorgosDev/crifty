package dev.georgiy.crifty.messanger.data;

import dev.georgiy.crifty.messanger.data.beans.User;

public interface UserStorage {
    void addUser(User user);
    void deleteUser(String userId);
}
