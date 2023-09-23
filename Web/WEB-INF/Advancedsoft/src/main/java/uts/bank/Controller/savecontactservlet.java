package uts.bank.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.*;


@WebServlet("/savecontactservlet")
public class savecontactservlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String bsb = request.getParameter("bsb");
        String accountNumber = request.getParameter("accountNumber");
        String accountName = request.getParameter("accountName");
        if (bsb == null || bsb.isEmpty() || accountNumber == null || accountNumber.isEmpty() || accountName == null || accountName.isEmpty()) {
            request.setAttribute("errorMessage", "Please ensure all details are correct.");
            RequestDispatcher rd = request.getRequestDispatcher("Save-Contact.jsp");
            rd.forward(request, response);
            return;
        }
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/?user=root?autoReconnect=true&useSSL=false", "root", "root");
            System.out.println("Login Connected");

            String sql = "INSERT INTO ISDUSER.CUSTOMER (BSB, AccountNumber, AccountName) VALUES (?, ?, ?)";

            ps = con.prepareStatement(sql);


            ps.setString(1, bsb);
            ps.setString(2, accountNumber);
            ps.setString(3, accountName);

            String emailDB = "";
            String passwordDB = "";
            String typeDB = "";
            //String nameDB = "";
            //int userIdDB = 0;

            rs = ps.executeQuery();

            response.sendRedirect("Pay-Transfer.jsp");


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


