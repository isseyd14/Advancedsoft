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
import java.sql.*;;

import java.sql.*;
import java.io.IOException;

@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form parameters
        String firstName = request.getParameter("fname");
        String lastName = request.getParameter("lname");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        user user = (user) request.getSession().getAttribute("User");
        user.setFname(firstName);
        user.setLname(lastName);
        user.setPhone(phone);
        user.setAddress(address);
        request.getSession().setAttribute("User", user);
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://advancedsoftwareserver.mysql.database.azure.com:3306/bank?useSSL=false",
                    "advancedsoftware", "Welcome1!");
            String sql = "UPDATE bank.user SET fname=?, lname=?, phone=?, address=? WHERE Email=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, phone);
            ps.setString(4, address);
            ps.setString(5, user.getEmail());
            int rowsAffected = ps.executeUpdate();
            request.setAttribute("errorMessage","Account succesfully Edited");
            RequestDispatcher rd = request.getRequestDispatcher("account.jsp");
            rd.forward(request, response);
        }

        catch(Exception e){
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

        // Redirect back to the account details page or another appropriate page
    }

