package com.crud.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;


@Getter
@AllArgsConstructor
public class Mail {
    private String mailTo;
    private String subject;
    private String message;
    private String toCC;

    public Mail(String mailTo, String subject, String message) {
        this.mailTo = mailTo;
        this.subject = subject;
        this.message = message;
    }
}
