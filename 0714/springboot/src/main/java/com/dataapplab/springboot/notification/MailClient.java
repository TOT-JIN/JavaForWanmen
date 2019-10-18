package com.dataapplab.springboot.notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
public class MailClient {
 
	@Autowired
	private MailContentBuilder mailContentBuilder;
	
    private JavaMailSender mailSender;
 
    @Autowired
    public MailClient(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
 
    public void prepareAndSend(String recipient, String message) {
        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom("1283061@qq.com");
            messageHelper.setTo(recipient);
            messageHelper.setSubject("Sample mail subject");
            String content = mailContentBuilder.build(message);            
            messageHelper.setText(content, true);
        };
        try {
            mailSender.send(messagePreparator);
        } catch (MailException e) {
        	System.out.print(e);
        }
    }
 
}