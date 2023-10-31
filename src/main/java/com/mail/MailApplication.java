package com.mail;

import com.mail.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class MailApplication {
	@Autowired
	private EmailService emailService;

	public static void main(String[] args) {
		SpringApplication.run(MailApplication.class, args);
	}
/*	@EventListener(ApplicationReadyEvent.class)
   public void TriggerMail(){
     this.emailService.sendEmail("subject","message","vishalpandey10022000@gmail.com");
   }*/
}
