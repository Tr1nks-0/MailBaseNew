package com.tr1nksgroup.model.components;

import com.tr1nksgroup.model.components.properties.MailTextProperties;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
public class MyMailSender {
    @Resource
    private JavaMailSender sender;
    @Resource
    private MailTextProperties mailTextProperties;

    public void sendEmail(String username, String[] filenames, byte[][] files) {
        try {
            MimeMessage message = sender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message,true);
            helper.setTo(mailTextProperties.getRecipient());
            String text = mailTextProperties.getText();
            helper.setText(text.replace(mailTextProperties.getSendUserPattern(), username));
            for (int i = 0; i < filenames.length; i++) {
//                ByteArrayInputStream stream = new ByteArrayInputStream(files[i]);
                helper.addAttachment(filenames[i], new ByteArrayResource(files[i]));
            }
            helper.setSubject(mailTextProperties.getTitle());
            sender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
