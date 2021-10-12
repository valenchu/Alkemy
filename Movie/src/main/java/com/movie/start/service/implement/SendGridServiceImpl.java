package com.movie.start.service.implement;

import java.io.IOException;

import javax.swing.text.html.HTML;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.movie.start.error.MesaggeError;
import com.movie.start.service.SendGridService;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

@Service
public class SendGridServiceImpl implements SendGridService {
	@Autowired
	private Environment env;

	@Override
	public void senEmail(String email, String html) {
		String apiKey = env.getProperty("API_KEY");
		String meEmail = env.getProperty("MAIL_FROM");
		Email from = new Email(meEmail);

		String subject = "WELCOME " + email;
		Email to = new Email(email);
		Content content = new Content("text/html", html);
		Mail mail = new Mail(from, subject, to, content);

		SendGrid sg = new SendGrid(apiKey);
		Request request = new Request();
		try {
			request.setMethod(Method.POST);
			request.setEndpoint("mail/send");
			request.setBody(mail.build());
			Response response = sg.api(request);
			System.out.println(response.getStatusCode());
			System.out.println(response.getBody());
			System.out.println(response.getHeaders());
		} catch (IOException ex) {
			throw new MesaggeError(ex.getMessage());
		}

	}
}
