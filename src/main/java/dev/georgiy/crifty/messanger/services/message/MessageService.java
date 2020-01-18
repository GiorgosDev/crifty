package dev.georgiy.crifty.messanger.services.message;

import dev.georgiy.crifty.messanger.services.message.beans.GetMessagesResponse;
import dev.georgiy.crifty.messanger.services.message.beans.SendMessageResponse;
import dev.georgiy.crifty.messanger.services.user.beans.RegistrationResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageService {
    @RequestMapping(value = "/message/send")
    public SendMessageResponse sendMessage() {
        //todo lookup uuid by token
        //todo search for receiver
        //todo add message to storage
        return new SendMessageResponse();
    }
    @RequestMapping(value = "/message")
    public GetMessagesResponse getMessage() {
        //todo lookup uuid by token
        return new GetMessagesResponse();
    }
}

