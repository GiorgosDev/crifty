package dev.georgiy.crifty.messanger.services.message.beans;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Message {
    private String id;
    private String from;
    private String to;
    private String content;
    private LocalDateTime timestamp;

    public Message( String from, String to, String content, LocalDateTime timestamp) {
        this.id = UUID.randomUUID().toString();
        this.from = from;
        this.to = to;
        this.content = content;
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message)) return false;
        Message message = (Message) o;
        return Objects.equals(getId(), message.getId()) &&
                Objects.equals(getFrom(), message.getFrom()) &&
                Objects.equals(getTo(), message.getTo()) &&
                Objects.equals(getTimestamp(), message.getTimestamp());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFrom(), getTo(), getTimestamp());
    }
}
