package uts.bank.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uts.bank.model.User;

import java.sql.*;
import java.io.IOException;

@WebServlet("/ChangePassword")
public class ChangePasswordservlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String oldpass = request.getParameter("Chnpass");
        String newpass = request.getParameter("pass");
        User user = (User) request.getSession().getAttribute("User");
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Validator validator = new Validator();
        try {
            if (user.getPassword().equals(oldpass) ) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://advancedsoftwareserver.mysql.database.azure.com:3306/bank?useSSL=false",
                    "advancedsoftware", "Welcome1!");
            String sql = "UPDATE bank.user SET Pass=? WHERE Email=?";
            ps = con.prepareStatement(sql);
            ps.setString(1,newpass);
            ps.setString(2, user.getEmail());
            int rowsAffected = ps.executeUpdate();
            user.setPassword(newpass);
            request.getSession().setAttribute("User", user);
            request.setAttribute("errorMessage","Password succesfully Changed");
            RequestDispatcher rd = request.getRequestDispatcher("account.jsp");
            rd.forward(request, response);
            }
            else{
                request.setAttribute("errorMessage","Old password didnt match the current password inputted");
                RequestDispatcher rd = request.getRequestDispatcher("ChangePassword.jsp");
                rd.forward(request, response);
            }



        }  catch(Exception e){
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
