package com.bhanu.spring5tutorial.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class SmtpMailSender implements MailSender {
	
	private static Log log = LogFactory.getLog(SmtpMailSender.class);
	private JavaMailSender javaMailSender;

	public SmtpMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	@Override
	public void send(String to, String subject, String body) throws MessagingException {
		/*log.info("Sending smtp mail to " + to);
		log.info("with subject " + subject);
		log.info("and body " + body);*/
		
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		
		helper.setTo(to);
		helper.setSubject(subject);
		helper.setText(body, true);
		
		javaMailSender.send(message);
	}

}
