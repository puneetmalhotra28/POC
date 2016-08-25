package com.schoeninteriors.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class SmtpMailSender {

	@Autowired
	private MailSender mailSender;

	public void sendEmail(String toAddress, String subject, String msgBody) {
		SimpleMailMessage simpleMailSender = new SimpleMailMessage();
		//simpleMailSender.setFrom(fromAddress);
		simpleMailSender.setTo(toAddress);
		simpleMailSender.setSubject(subject);
		simpleMailSender.setText(msgBody);
		mailSender.send(simpleMailSender);
	}
}