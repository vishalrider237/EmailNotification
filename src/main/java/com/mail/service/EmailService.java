package com.mail.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;
    public  void sendEmail(String subject, String message , String to) throws MessagingException {
   //  SimpleMailMessage message1=new SimpleMailMessage();
        MimeMessage message1 = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message1, true, "UTF-8");
     helper.setFrom("imop2wIssuer@gmail.com");
     helper.setTo(to);
     helper.setText(message,true);
    helper.setSubject(subject);
    mailSender.send(message1);
        System.out.println("Mail Send...");
    }

}
