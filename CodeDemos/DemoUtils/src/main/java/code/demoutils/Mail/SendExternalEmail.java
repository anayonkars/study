package code.demoutils.Mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by anayonkar on 17/1/16.
 */
public class SendExternalEmail {
    private String link="";

    private SendExternalEmail() {
    }

    private final String sender_email = "e@mail.com";
    private String mail_text = "";



    private String receiver;
    private String subject;
    private String message;

    private String sender;
    private String password;

    public static void main(String[] args) {
        SendExternalEmail see = new SendExternalEmail();
        see.setReceiver();
        see.sendEmail();
    }
    private String sendEmail()
    {
        Properties props = new Properties();
        props.put("mail.smtp.user", sender_email);
        String host_name = "smtp.mail.com";
        props.put("mail.smtp.host", host_name);
        String port_port = "587";
        props.put("mail.smtp.port", port_port);
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.socketFactory.port", port_port);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");

        @SuppressWarnings("UnusedAssignment") SecurityManager security = System.getSecurityManager();

        String status = "fail";
        try
        {
			/*
			if(sender!=null && !"".equals(sender.trim()))
				sender_email=sender;
			if(password!=null && !"".equals(password.trim()))
				sender_password=password;
			*/

            String mail_to = receiver;
            String mail_subject = subject;

            mail_text+="Hello "+receiver;
            mail_text+="<br/><br/>"+link;
            mail_text+="<br/>"+message;
            mail_text+="<br/><br/>This a auto-genered message from e-Banking Solution";

            mail_text+="<br/> ";
            mail_text+="<br/><br/>Regards,";
            mail_text+="<br/><br/> eBanking! Mail Services";

            Authenticator auth = new SMTPAuthenticator();
            Session mailSession = Session.getDefaultInstance(props, auth);

            MimeMessage msg = new MimeMessage(mailSession);
            msg.setSubject(mail_subject);
            msg.setFrom(new InternetAddress(sender_email));
            msg.addRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(mail_to));

            msg.setContent(mail_text, "text/html");
            Transport.send(msg);

            status ="success";
        }
        catch (Exception mex)
        {
            mex.printStackTrace();
            status ="fail";
        }

        return status;
    }



    public String getReceiver() {
        return receiver;
    }

    private void setReceiver() {
        this.receiver = "e@mail.com";
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }



    private class SMTPAuthenticator extends javax.mail.Authenticator
    {
        public PasswordAuthentication getPasswordAuthentication()
        {
            String sender_password = "mypassword";
            return new PasswordAuthentication(sender_email, sender_password);
        }
    }

}
