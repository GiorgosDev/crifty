package dev.georgiy.crifty.messanger.services.message.beans;

import java.time.LocalDateTime;
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
}
