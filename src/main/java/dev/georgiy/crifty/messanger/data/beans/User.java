package dev.georgiy.crifty.messanger.data.beans;

import java.util.Objects;
import java.util.UUID;

public class User {
    private String id;
    public User() {
        this.id = UUID.randomUUID().toString();
    }

    public User(String userId) {
        this.id = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
