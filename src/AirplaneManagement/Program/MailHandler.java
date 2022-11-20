package AirplaneManagement.Program;

import com.sun.javafx.scene.control.behavior.TwoLevelFocusBehavior;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class MailHandler extends Handler{
    private static final String username = "vasyl.merynher.kn.2021@lpnu.ua";
    //region password
    private static final String password = "*";

    //endregion
    private String recipient;

    public MailHandler(String recipient){
        this.recipient = recipient;
    }

    @Override
    public void publish(LogRecord record) {
        if (record.getLevel() == Level.SEVERE || record.getLevel() == Level.WARNING)
            sendMail(record.getMessage(),record.getLevel());
    }

    @Override
    public void flush() {}

    @Override
    public void close() throws SecurityException {

    }

    private void sendMail(String logMessage, Level level) {
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable","true");
        prop.put("mail.smtp.ssl.protocols", "TLSv1.2");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");

        Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("vasyl.merynher.kn.2021@lpnu.ua"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(recipient)
            );
            message.setSubject(level.toString());
            message.setText(logMessage);
            Transport.send(message);
        } catch (MessagingException e) {
            Logger.getGlobal().warning("Failed to send email.");
        }
    }
}
