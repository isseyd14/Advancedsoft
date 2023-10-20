package uts.bank.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Properties;

@WebServlet("/sendEmailServlet")
public class SendEmailServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String to = request.getParameter("email");
        String subject = "Change password";
        String messageText = "asdsad";

        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("s33434856@gmail.com", "nkwjrznyaycpbunq");
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("s33434856@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(messageText);

            Transport.send(message);
            request.setAttribute("errorMessage","Password succesfully Changed");
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);

            response.getWriter().println("Email sent successfully!");
        } catch (MessagingException e) {
            throw new ServletException(e);
        }
    }
}

