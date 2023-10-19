package uts.bank.Controller;

import java.util.Random;

import com.google.protobuf.Message;
import com.mysql.cj.Session;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Properties;
import javax.annotation.Resource;
import javax.sql.DataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;

@WebServlet("/forgotpassServlet")
public class ForgottenPass extends HttpServlet {
    @Resource(name = "java:comp/env/jdbc/MyDataSource")
    private Session mailSession;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String from = "s33434856@gmail.com";
        String to = " ";
        try{
            Message message = new MimeMessage(mailSession);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject("Hello, this is a test email");
            message.setText("This is the content of the email.");

            Transport.send(message);

            response.getWriter().write("Email sent successfully.");
        } catch (MessagingException e) {
            e.printStackTrace();
            response.getWriter().write("Email sending failed.");
        }
        }


   /* protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Random random = new Random();
        int randomNumber = 1000 + random.nextInt(9000);
        String from = "s33434856@gmail.com";
        String to = " ";
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.auth", "true");
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("your.email@example.com", "your_password");
            }
        });
        try
        {
            SmtpClient SmtpServer = new SmtpClient("smtp.gmail.com", 587);
            SmtpServer.DeliveryMethod = SmtpDeliveryMethod.Network;
            MailMessage email = new MailMessage();
            // START
            email.From = new MailAddress(SendMailFrom);
            email.To.Add(SendMailTo);
            email.Subject = SendMailSubject;
            email.Body = SendMailBody;
            //END
            SmtpServer.Timeout = 5000;
            SmtpServer.EnableSsl = true;
            SmtpServer.UseDefaultCredentials = false;
            SmtpServer.Credentials = new NetworkCredential("s33434856@gmail.com", "nkwjrznyaycpbunq");
            SmtpServer.Send(email);

            Console.WriteLine("\t\t mail Successfully Sent");
            Console.ReadKey();
        }
        catch (Exception ex)
        {
            Console.WriteLine(ex.ToString());
            Console.ReadKey();
        }
    }



    }*/

}
