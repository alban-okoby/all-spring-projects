package com.digitalsouag.redditapi.service;

import com.digitalsouag.redditapi.entity.NotificationEmail;
import com.digitalsouag.redditapi.exception.SpringRedditException;
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

  void sendMail(NotificationEmail notificationEmail) {
      MimeMessagePreparator mmp = mimeMessage -> {
          MimeMessageHelper mmh = new MimeMessageHelper(mimeMessage);
          mmh.setFrom("springredditcloneapp@gmail.com");
          mmh.setTo(notificationEmail.getRecipient());
          mmh.setSubject(notificationEmail.getSubject());
          mmh.setText(mailContentBuilder.build(notificationEmail.getBody()));
      };
      try {
          mailSender.send(mmp);
          log.info("Your activation mail is send successfully ✅");
      } catch (MailException e) {
          throw new SpringRedditException("Could not send this activation mail : " + notificationEmail.getRecipient());
      }
  }
}
