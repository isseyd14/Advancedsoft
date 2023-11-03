package uts.bank.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import uts.bank.model.*;
import java.io.IOException;
import java.sql.*;

@WebServlet("/LoginServlet")
public class Loginservlet extends HttpServlet {
    // Method to set session attributes
    private void setSessionAttrs(HttpSession session,  User acc ) {
        session.setAttribute("email", acc.getEmail());
        session.setAttribute("User", acc);
    }

   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get user input from the login form
        String email = request.getParameter("email");
        String password = request.getParameter("Password");

        // Check if email and password are provided
        if (email == null || email.isEmpty() || password == null || password.isEmpty()) {
            // If not, set an error message and forward the request back to the login page
            request.setAttribute("errorMessage", "Please enter a valid email or password.");
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
            return;
        }

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // Establish a database connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://advancedsoftwareserver.mysql.database.azure.com:3306/bank?useSSL=false",
                    "advancedsoftware", "Welcome1!");
            System.out.println("Login Connected");;

            String sql = "select * from bank.user where Email=? and PASS=?";

            ps = con.prepareStatement(sql);

            ps.setString(1, email);
            ps.setString(2, password);

            String emailDB = "";
            String passwordDB = "";
            String typeDB = "";
            String nameDB = "";
            String LnameDB = "";
            String Address = "";
            String Phone = "";
            String dob = "";

            rs = ps.executeQuery();

            while(rs.next()) {
                // Retrieve user information from the database
                emailDB = rs.getString("email");
                passwordDB = rs.getString("Pass");
                typeDB = rs.getString("Type");
                nameDB = rs.getString("Fname");
                LnameDB = rs.getString("Lname");
                Address = rs.getString("Address");
                dob = rs.getDate("dob").toString();
                Phone = rs.getString("Phone");

                System.out.println("emailDB: " + emailDB);
                System.out.println("passwordDB: " + passwordDB);
            }

            String sql1 = "select * from bank.user where Email=?";
            ps = con.prepareStatement(sql1);
            ps.setString(1, email);
            rs = ps.executeQuery();
            while(rs.next()) {
                nameDB = rs.getString(("Fname"));
            }

            if(email.equals(emailDB) && password.equals(passwordDB) && typeDB.equals("customer")){
                // If user is a customer, create a User object and set it in the session
                User acco = new User(emailDB,passwordDB,typeDB,nameDB,LnameDB,dob,Phone,Address);
                HttpSession session = request.getSession();
                setSessionAttrs(session, acco);
                session.setAttribute("email", acco.getEmail());
                response.sendRedirect("viewbalanceservlet");
            } else if(email.equals(emailDB) && password.equals(passwordDB) && typeDB.equals("staff")) {
                // If user is a staff member, create a User object and set it in the session
                User acco = new User(emailDB,passwordDB,typeDB,nameDB,LnameDB,dob,Phone,Address);
                HttpSession session = request.getSession();
                setSessionAttrs(session, acco);
                response.sendRedirect("admin.jsp");
            } else {
                // If email and password do not match any user, set an error message
                request.setAttribute("errorMessage", "Username or password incorrect. Try again.");
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.forward(request, response);
            }
        } catch(Exception e){
            System.out.println(" Login Error - " + e.getMessage());
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
