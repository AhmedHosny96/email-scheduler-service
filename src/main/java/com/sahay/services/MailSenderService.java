package com.sahay.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Date;


@Slf4j
@Service
@RequiredArgsConstructor
public class MailSenderService {

    private final JavaMailSender mailSender;

    public void sendMail(String[] toEmail, String body, String subject, ByteArrayInputStream attachment)  {

        MimeMessage message = mailSender.createMimeMessage();

        MimeBodyPart textBodyPart = new MimeBodyPart();

        try {
            textBodyPart.setText(body);

            // csv bodypart
            DataSource dataSource = new ByteArrayDataSource(attachment, "application/csv");
            MimeBodyPart csvBodyPart = new MimeBodyPart();
            csvBodyPart.setDataHandler(new DataHandler(dataSource));
            csvBodyPart.setFileName(new Date() + "-via-sahay.csv");

            // construct mime multi part
            MimeMultipart mimeMultipart = new MimeMultipart();
            mimeMultipart.addBodyPart(csvBodyPart);
            mimeMultipart.addBodyPart(textBodyPart);

            InternetAddress recipient = new InternetAddress(toEmail.toString());

            message.setText(body);
            message.setSubject(subject);
            message.setContent(mimeMultipart);
            message.setRecipient(Message.RecipientType.TO, recipient);

            mailSender.send(message);
        } catch (MessagingException | IOException e) {
            log.error("sendMail () error occurred while constructing email body" , e.getMessage());
            e.printStackTrace();
        }

    }
}
