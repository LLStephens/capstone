package com.techelevator.capstone;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;


public class MailSender extends Thread {
	private static final String SENDER_EMAIL_ID = "neutralspacehealthcare@gmail.com";
	private static final String SENDER_PASSWORD = "doctorNUmber1";
	private static final String EMAIL_SMTP_SERVER = "smtp.gmail.com";
	private static final String EMAIL_SERVER_PORT = "465";
	
	private String receiverEmailID = null;
	private String emailSubject = "Appointment confirmation from Neutralspace Personal Healthcare";
	private String emailBody = null;

	public MailSender(String receiverEmailID, String emailSubject, String emailBody) {
		this.receiverEmailID = receiverEmailID;
		this.emailSubject = emailSubject;
		this.emailBody = emailBody;
	}
	
	@Override
	public void run() {
		Properties props = new Properties();
		props.put("mail.smtp.user", SENDER_EMAIL_ID);
		props.put("mail.smtp.host", EMAIL_SMTP_SERVER);
		props.put("mail.smtp.port", EMAIL_SERVER_PORT);
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.socketFactory.port", EMAIL_SERVER_PORT);
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "false");

		try {
			Authenticator auth = new SMTPAuthenticator();
			Session session = Session.getInstance(props, auth);
			MimeMessage msg = new MimeMessage(session);
			msg.setText(emailBody);
			msg.setSubject(emailSubject);
			msg.setFrom(new InternetAddress(SENDER_EMAIL_ID));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(receiverEmailID));
			Transport.send(msg);
			System.out.println("Message sent successfully:)");
		} catch (Exception mex) {
			mex.printStackTrace();
		}
	}

	public class SMTPAuthenticator extends javax.mail.Authenticator {
		public PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(SENDER_EMAIL_ID, SENDER_PASSWORD);
		}
	}


}