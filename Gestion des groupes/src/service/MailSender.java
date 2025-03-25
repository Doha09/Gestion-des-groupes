/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
/**
 *
 * @author ouahm
 */
public class MailSender {
 
    public static boolean envoyerCode(String destinataire, String code) {
       final String expediteur = "aymansaf200@gmail.com"; // à remplacer
        final String motDePasse = "gpybzoqqewelyvuk";      // mot de passe d'application

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
            new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(expediteur, motDePasse);
                }
            });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(expediteur));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinataire));
            message.setSubject("Code de réinitialisation");
            message.setText("Voici votre code de réinitialisation : " + code);

            Transport.send(message);
            System.out.println("✅ Email envoyé avec succès !");
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }
}

