package uts.bank.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uts.bank.model.DAO.UserDAO;
import uts.bank.model.User;

import java.sql.*;
import java.io.IOException;

@WebServlet("/ChangePassword2")
public class forgotpassword extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the passcode and new password from the request
        String oldpass = request.getParameter("code");
        String newpass = request.getParameter("pass");

        // Initialize a UserDAO for database operations
        UserDAO testuserDao = new UserDAO();

        // Retrieve the email for password reset from the session
        String email = (String) request.getSession().getAttribute("emailReset");

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Validator validator = new Validator();

        try {
            // Check if the provided passcode is valid for the given email
            if (testuserDao.passvalid(oldpass, email)) {
                // Establish a database connection
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://advancedsoftwareserver.mysql.database.azure.com:3306/bank?useSSL=false",
                        "advancedsoftware", "Welcome1!");

                // Prepare and execute an SQL statement to update the password
                String sql = "UPDATE bank.user SET Pass=? WHERE Email=?";
                ps = con.prepareStatement(sql);
                ps.setString(1, newpass);
                ps.setString(2, email);
                ps.executeUpdate();

                // Set a success message and forward to the login page
                request.setAttribute("errorMessage", "Password successfully changed");
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.forward(request, response);
            } else {
                // Set an error message and forward to the password reset page
                request.setAttribute("errorMessage", "Passcode incorrect");
                RequestDispatcher rd = request.getRequestDispatcher("changepass2.jsp");
                rd.forward(request, response);
            }

        } catch (Exception e) {
            // Handle exceptions, such as database and general errors
            System.out.println("Login Error - " + e.getMessage());
        } finally {
            // Close statement and connection
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
