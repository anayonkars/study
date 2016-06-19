package code.demoutils.Mail;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 * Created by anayonkar on 19/6/16.
 */
public class CommonsEMailDemo {
    public static String HOSTNAME = "smtp.googlemail.com";
    public static int SMTP_PORT = 465;
    public static String GMAIL_SUFFIX = "@gmail.com";
    public static void main(String[] args) throws EmailException {
        if(args == null || args.length != 3) {
            StringBuilder sb = new StringBuilder("\nPlease provide below:");
            sb.append("\n1. Your email address (gmail)");
            sb.append("\n2. Your email password");
            sb.append("\n3. Target email address");
            throw new IllegalArgumentException(sb.toString());
        }
        System.out.println(args[0]);
        System.out.println(args[1]);
        System.out.println(args[2]);
        String sourceEMail = args[0];
        CommonsEMailDemo ced = new CommonsEMailDemo();
        ced.sendEmail(args[0], args[1], args[2]);
        System.out.println("Done!");
    }

    private void sendEmail(String sourceEmail, String password, String target) throws EmailException {
        Email email = new SimpleEmail();
        email.setHostName(HOSTNAME);
        email.setSmtpPort(SMTP_PORT);
        email.setAuthenticator(new DefaultAuthenticator(sourceEmail, password));
        email.setSSLOnConnect(true);
        email.setFrom(sourceEmail);
        email.setSubject("TestMail");
        email.setMsg("This is a test mail ... :-)");
        email.addTo(target);
        email.send();
    }
}
