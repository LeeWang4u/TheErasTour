package com.example.theerastour.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;
import javax.mail.internet.MimeMessage;


import org.springframework.stereotype.Service;

@Service
public interface MailerService {

    public void send(String from, String to, String subject, String body );

    public String bodyReply(String hash);
}