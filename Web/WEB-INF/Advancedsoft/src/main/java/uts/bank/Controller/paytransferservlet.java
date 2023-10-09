package uts.bank.advancedsoft;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.*;


@WebServlet("/paytransferServlet")
public class paytransferservlet extends HttpServlet {
    private void setSessionAttrs(HttpSession session, String email ) {
        session.setAttribute("email", email);
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
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/?user=root?autoReconnect=true&useSSL=false", "root", "root");
            System.out.println("Login Connected");

            String sql = "select * from bank.account where Email=? and PASS=?";

            ps = con.prepareStatement(sql);

            ps.setString(1, email);
            ps.setString(2, password);

            String emailDB = "";
            String passwordDB = "";
            String typeDB = "";
            //String nameDB = "";
            //int userIdDB = 0;

            rs = ps.executeQuery();


            while(rs.next()) {
                emailDB = rs.getString("email");
                passwordDB = rs.getString("Pass");
                typeDB = rs.getString("Type");
                //nameDB = rs.getString("name");
                //userIdDB = rs.getInt("userID");

                System.out.println("emailDB: " + emailDB);
                System.out.println("passwordDB: " + passwordDB);
                //System.out.println("nameDB: " + nameDB);
                //System.out.println("userID: " + userIdDB);
            }

            if(email.equals(emailDB) && password.equals(passwordDB) && typeDB.equals("customer")){
                System.out.println("in If");

                HttpSession session = request.getSession();
                setSessionAttrs(session, email);
                //createUserLog(session, con, email);

                response.sendRedirect("home.jsp");
            } else if(email.equals(emailDB) && password.equals(passwordDB) && typeDB.equals("staff")) {

                HttpSession session = request.getSession();
                setSessionAttrs(session, email);
                //createUserLog(session, con, email);

                response.sendRedirect("staff-home.jsp");
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


