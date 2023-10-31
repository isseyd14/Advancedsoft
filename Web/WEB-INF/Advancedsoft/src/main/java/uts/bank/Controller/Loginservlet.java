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
    private void setSessionAttrs(HttpSession session,  User acc ) {
        session.setAttribute("email", acc.getEmail());
        session.setAttribute("User", acc);
        //session.setAttribute("name", nameDB);
    }

   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("Password");
        if (email == null || email.isEmpty() || password == null || password.isEmpty()) {
            request.setAttribute("errorMessage", "Please enter a valid email or password.");
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
            return;
        }
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
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
            //double bal = 0;
            String dob = "";
            //int userIdDB = 0;

            rs = ps.executeQuery();


            while(rs.next()) {
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
                //System.out.println("nameDB: " + nameDB);
                //System.out.println("userID: " + userIdDB);
            }
            String sql1 = "select * from bank.user where Email=?";
            ps = con.prepareStatement(sql1);
            ps.setString(1, email);
            rs = ps.executeQuery();
            while(rs.next()) {
                nameDB = rs.getString(("Fname"));
            }
            //request.setAttribute("Fname", nameDB);

            if(email.equals(emailDB) && password.equals(passwordDB) && typeDB.equals("customer")){
                System.out.println("in If");
                //    public User(String email, String password, String type, String fname, String lname, String dob, String phone, String address) {
                User acco = new User(emailDB,passwordDB,typeDB,nameDB,LnameDB,dob,Phone,Address);
                HttpSession session = request.getSession();
                setSessionAttrs(session, acco);
                session.setAttribute("email", acco.getEmail());
                //createUserLog(session, con, email);
                response.sendRedirect("viewbalanceservlet");
            } else if(email.equals(emailDB) && password.equals(passwordDB) && typeDB.equals("staff")) {
                User acco = new User(emailDB,passwordDB,typeDB,nameDB,LnameDB,dob,Phone,Address);

                HttpSession session = request.getSession();
                setSessionAttrs(session, acco);
                //createUserLog(session, con, email);

                response.sendRedirect("admin.jsp");
            } else{
                System.out.println("in else");
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
