package uts.bank.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
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
        Date dob = Date.valueOf(request.getParameter("dob"));
        String phone = request.getParameter("Phone");
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://advancedsoftwareserver.mysql.database.azure.com:3306/bank?useSSL=false",
                    "advancedsoftware", "Welcome1!");
            String sql = "SELECT * FROM bank.user WHERE Email=?";
            ps = con.prepareStatement(sql);
            ps.setString(1,email);
            rs = ps.executeQuery();
            if(rs.next()) {
                request.setAttribute("errorMessage","This email already has an account linked to it");
                RequestDispatcher rd = request.getRequestDispatcher("Register.jsp");
                rd.forward(request, response);
            }
            else{
                String sql1 = "INSERT INTO bank.user (Email, Pass, Type, fname, lname, Address, DOB,Phone) VALUES(?,?,?,?,?,?,?,? )";
                ps = con.prepareStatement(sql1);
                ps.setString(1, email);
                ps.setString(2, password);
                ps.setString(3, "customer");
                ps.setString(4, fname);
                ps.setString(5, lname);
                ps.setString(6, address);
                ps.setDate(7,dob);
                ps.setString(8,phone);
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
