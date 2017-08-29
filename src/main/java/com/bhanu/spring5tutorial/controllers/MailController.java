package com.bhanu.spring5tutorial.controllers;

import javax.mail.MessagingException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bhanu.spring5tutorial.mail.MailSender;
import com.bhanu.spring5tutorial.mail.SmtpMailSender;

@RestController
public class MailController {

	private MailSender mailSender;

	public MailController(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	@RequestMapping("/mail")
	public String mail(@RequestParam("email") String email) throws MessagingException {

		mailSender.send(email, "Test Subject", "Body of test mail");

		if (mailSender instanceof SmtpMailSender) {
			return "Smtp mail sent to " + email;
		} else {
			return "Mock mail sent to " + email;
		}
	}
}
