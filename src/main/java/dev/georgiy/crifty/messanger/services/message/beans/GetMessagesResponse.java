package dev.georgiy.crifty.messanger.services.message.beans;

import dev.georgiy.crifty.messanger.api.GenericResponse;

import java.util.List;

public class GetMessagesResponse extends GenericResponse {
    private List<Message> messages;
}
