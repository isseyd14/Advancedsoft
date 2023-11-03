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
        // Initialize a UserDAO for database operations
        UserDAO userDAO = new UserDAO();

        // Get the recipient email address from the request
        String to = request.getParameter("email");

        // Generate a 4-digit random code for password reset
        Random random = new Random();
        int randomNumber = 1000 + random.nextInt(9000);
        String randomNumberString = Integer.toString(randomNumber);

        // Compose the email subject and message
        String subject = "Change password";
        String messageText = "Hi there, This is the 4-digit code required to reset your password. " +
                "It will only be valid for 30 minutes: " + randomNumberString;

        // Configure email properties for sending
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com"); // Trust Gmail's SSL certificate

        // Create a session for sending the email
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("s33434856@gmail.com", "nkwjrznyaycpbunq");
            }
        });

        try {
            // Create and send the email message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("s33434856@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(messageText);
            Transport.send(message);

            // Set the recipient's email for password reset in the session
            request.getSession().setAttribute("emailReset", to);

            // Forward the request to the changepass2.jsp page
            RequestDispatcher rd = request.getRequestDispatcher("changepass2.jsp");
            rd.forward(request, response);

            // Store the random code in the database
            userDAO.passcode(to, randomNumberString);

            // Respond to the client indicating a successful email send
            response.getWriter().println("Email sent successfully!");
        } catch (MessagingException e) {
            // Handle email sending exceptions
            throw new ServletException(e);
        } catch (SQLException e) {
            // Handle database-related exceptions
            throw new RuntimeException(e);
        }
    }
}
