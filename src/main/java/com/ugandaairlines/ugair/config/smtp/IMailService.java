package com.ugandaairlines.ugair.config.smtp;


import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

public interface IMailService {
    void sendMail(String to, String from, String subject, String message);
    void sendMailUsingTemplate(String to, String from, String subject, String message)
            throws MessagingException, UnsupportedEncodingException;
}
