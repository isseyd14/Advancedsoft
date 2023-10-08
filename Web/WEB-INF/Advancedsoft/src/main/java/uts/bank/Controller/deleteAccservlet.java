package uts.bank.Controller;

import uts.bank.model.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.*;

@WebServlet("/DeleteAccServlet")
public class deleteAccservlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        user acc = (user) session.getAttribute("user");
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:mysql://advancedsoftwareserver.mysql.database.azure.com:3306/bank?useSSL=false",
                    "advancedsoftware", "Welcome1!");
            System.out.println("Login Connected");;

            String sql = "DELETE FROM bank.user WHERE Email = ?";
            ps.setString(1, acc.getEmail());
            request.setAttribute("errorMessage", "Account Succesfully deleted");
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");

        }catch(Exception e){
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
