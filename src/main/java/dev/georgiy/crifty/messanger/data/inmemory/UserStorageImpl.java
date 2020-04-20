package dev.georgiy.crifty.messanger.data.inmemory;

import dev.georgiy.crifty.messanger.data.MessageStorage;
import dev.georgiy.crifty.messanger.data.UserStorage;
import dev.georgiy.crifty.messanger.data.beans.User;
import dev.georgiy.crifty.messanger.services.message.beans.Message;
import org.springframework.stereotype.Controller;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Controller
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

    @Override
    public UserBucket getBucket(User user) {
        return buckets.get(user);
    }

}
