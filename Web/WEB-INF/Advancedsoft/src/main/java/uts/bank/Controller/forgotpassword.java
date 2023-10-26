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
        String oldpass = request.getParameter("code");
        UserDAO testuserDao = new UserDAO();
        String newpass = request.getParameter("pass");
        String email = (String) request.getSession().getAttribute("email");
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Validator validator = new Validator();
            try {
                if (testuserDao.passvalid(oldpass, email)) {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://advancedsoftwareserver.mysql.database.azure.com:3306/bank?useSSL=false",
                            "advancedsoftware", "Welcome1!");
                    String sql = "UPDATE bank.user SET Pass=? WHERE Email=?";
                    ps = con.prepareStatement(sql);
                    ps.setString(1, newpass);
                    ps.setString(2, email);
                    ps.executeUpdate();
                    request.setAttribute("errorMessage", "Password succesfully Changed");
                    RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                    rd.forward(request, response);
                } else {
                    request.setAttribute("errorMessage", "Passcode incorrect");
                    RequestDispatcher rd = request.getRequestDispatcher("changepass2.jsp");
                    rd.forward(request, response);
                }


            } catch (Exception e) {
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

