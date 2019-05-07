package bf.sonabel.utils;



import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Mail {



    public static void envoyerEmail(String destinataire, String objet, String corps) {

        final String username = "testsonabelmindtech@gmail.com";
        final String password = "testsonabelmindtech.0";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("from@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(destinataire)
            );
            message.setSubject(objet);
            message.setText(corps);

            Transport.send(message);

            System.out.println("Envoyé");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    }

