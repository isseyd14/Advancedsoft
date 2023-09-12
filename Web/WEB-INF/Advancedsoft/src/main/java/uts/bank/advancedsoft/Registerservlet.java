package uts.bank.advancedsoft;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.sql.*;
import java.io.IOException;

@WebServlet("/RegisterServlet")
public class Registerservlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String fname = request.getParameter("Firstname");
        String lname = request.getParameter("Lastname");
        String address = request.getParameter("address");
        double bal = Double.parseDouble(request.getParameter("startingBalance"));
        Date dob = Date.valueOf(request.getParameter("dob"));
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/?user=root?autoReconnect=true&useSSL=false", "root", "root");
            String sql = "SELECT * FROM bank.account WHERE Email=?";
            ps = con.prepareStatement(sql);
            ps.setString(1,email);
            rs = ps.executeQuery();
            if(rs.next()) {
                request.setAttribute("errorMessage","This email already has an account linked to it");
                RequestDispatcher rd = request.getRequestDispatcher("Register.jsp");
                rd.forward(request, response);
            }
            else{
                String sql1 = "INSERT INTO bank.account (Email, Pass, Type, fname, lname, Address, Balance,DOB) VALUES(?,?,?,?,?,?,?,? )";
                ps = con.prepareStatement(sql1);
                ps.setString(1, email);
                ps.setString(2, password);
                ps.setString(3, "customer");
                ps.setString(4, fname);
                ps.setString(5, lname);
                ps.setString(6, address);
                ps.setDouble(7,bal);
                ps.setDate(8,dob);
                ps.executeUpdate();
                request.setAttribute("errorMessage","Account succesfully created");
                //response.sendRedirect("login.jsp");
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.forward(request, response);
            }
            response.sendRedirect("login.jsp");
            //int rowsUpdated = ps.executeUpdate();
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
