package dev.georgiy.crifty.messanger.services.user.beans;

import dev.georgiy.crifty.messanger.api.GenericResponse;

public class RegistrationResponse extends GenericResponse {
    private String uuid;
    public RegistrationResponse(String uuid) {
        this.uuid = uuid;
    }
}
