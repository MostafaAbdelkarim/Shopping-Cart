package io.mostafaeldahshan.simon_and_kucher.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Slf4j
public class JavaMailConfig {

    @Value("${myEmailAddress}")
    private String myAccountEmail;

    @Value("${myEmailPassword}")
    private String password;

    public void sendMail(String recipient) throws Exception {
        System.out.println("Preparing mail to send");
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "557");;
        Session session = Session.getInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(myAccountEmail, password);
                }
            });
            Message message = prepareMessage(session, myAccountEmail, recipient);
            Transport.send(message);
            System.out.println("Message sent successfully");
        }
        private Message prepareMessage(Session session, String myAccountEmail, String recipient) {
            try {
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(myAccountEmail));
                message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
                message.setSubject("Order Confirmation");
                message.setText("Your order has been confirmed and will be shipped right away, \n Simon&Kucher Shopping Cart");
                return message;
            }
            catch (Exception ex) {
                    log.error("Error in sending mail: {}", ex.getMessage());
                }
                return null;
            }
}
