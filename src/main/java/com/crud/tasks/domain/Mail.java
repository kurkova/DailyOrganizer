package com.crud.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Mail {
    private Type type;
    private String mailTo;
    private String toCC;
    private String subject;
    private String message;


    public enum Type{
        TRELLO_CARD_EMAIL,
        DAILY_INFORMATION_EMAIL
    }
}
