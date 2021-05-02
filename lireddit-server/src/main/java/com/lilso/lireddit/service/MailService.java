package com.lilso.lireddit.service;

import com.lilso.lireddit.exceptions.SpringRedditException;
import com.lilso.lireddit.model.NotificationEmail;
import lombok.AllArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class MailService {
    private final JavaMailSender mailSender;
    private final MailContentBuilder mailContentBuilder;

    public void sendMail(NotificationEmail notificationEmail) {
        MimeMessagePreparator messagePreparator = mimeMessage ->  {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom("lireddit@email.com");
            messageHelper.setTo(notificationEmail.getRecipient());
            messageHelper.setSubject(notificationEmail.getSubject());
            messageHelper.setText(mailContentBuilder.build(notificationEmail.getBody()));
        };

        try {
            mailSender.send(messagePreparator);
            log.info("Activation email sent!!");
        } catch(MailException ex) {
            log.error("Exception occurred when sending mail ", ex);
            throw new SpringRedditException("Exception occurred when sending mail to " + notificationEmail.getRecipient(), ex);
        }
    }
}
