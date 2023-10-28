package uts.bank.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import uts.bank.model.DAO.UserDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Random;


@WebServlet("/sendEmailServlet")
public class SendEmailServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserDAO testuserDao = new UserDAO();

        String to = request.getParameter("email");
        request.setAttribute ("email","email");
        String subject = "Change password";
        Random random = new Random();
        int randomNumber = 1000 + random.nextInt(9000);
        String randomNumberString = Integer.toString(randomNumber);

        String messageText = "Hi there, This is the 4 digit code required to reset your password, it will only be valid for 30minutes" + randomNumberString;


        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com"); // Trust Gmail's SSL certificate


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
            request.getSession().setAttribute("emailReset",to);
            RequestDispatcher rd = request.getRequestDispatcher("changepass2.jsp");
            rd.forward(request, response);
            testuserDao.passcode(to,randomNumberString);

            response.getWriter().println("Email sent successfully!");
        } catch (MessagingException e) {
            throw new ServletException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
