// package uts.bank.Controller;

// import jakarta.servlet.RequestDispatcher;
// import jakarta.servlet.ServletException;
// import jakarta.servlet.annotation.WebServlet;
// import jakarta.servlet.http.HttpServlet;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;
// import jakarta.servlet.http.HttpSession;

// import java.io.IOException;
// import java.sql.*;
// import model.User


// /@WebServlet("/AdminServlet")
// public class AdminServlet extends HttpServlet {

//     @Override
//     protected void doGet(HttpServletRequest request, HttpServletResponse response)
//             throws ServletException, IOException {


//         try {
//             user = manager.fetchUser();
//             request.setAttribute("userId", userId);
//             request.setAttribute("name", name);
//             request.setAttribute("dob", dob);
//             request.setAttribute("email", email);

//             account = manager.fetchAccount();
//             request.setAttribute("accountName", accountName);
//             request.setAttribute("account_no", accountNumber);
//             request.setAttribute("bsb", bsb);
//             request.setAttribute("balance", balance);

//             request.getRequestDispatcher("admin.jsp").forward(request, response);

//         } catch (SQLException ex) {
//             Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);
//         }
//     }

//     @Override
//     protected void doPost(HttpServletRequest request, HttpServletResponse response)
//             throws ServletException, IOException {
//         String action = request.getParameter("action");

//         if ("add_btn".equals(action)) {
//             response.sendRedirect(request.getContextPath() + "/addAccountServlet");
//         }
//         if ("del_btn".equals(action)) {

//         }

//         response.sendRedirect(request.getContextPath() + "");
//         return;
//     }
// } 