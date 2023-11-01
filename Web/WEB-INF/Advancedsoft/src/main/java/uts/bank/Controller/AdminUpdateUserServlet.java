package uts.bank.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uts.bank.model.DAO.AdminDAO;
import uts.bank.model.User;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/AdminUpdateUserServlet")
public class AdminUpdateUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String fName = request.getParameter("fName");
        String lName = request.getParameter("lName");
        String address = request.getParameter("address");
        String dob = request.getParameter("dob");
        String phone = request.getParameter("phone");
        String newPassword = request.getParameter("newPassword");
        String confirmPassword = request.getParameter("Password");

        AdminDAO adminDAO = new AdminDAO();

        User user = null;
        try {
            user = adminDAO.findUser(email);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (!newPassword.isEmpty() && !confirmPassword.isEmpty()) {
            if (newPassword.equals(confirmPassword)) {
                user.setPassword(confirmPassword);
                adminDAO.updateUser(user.getEmail(), confirmPassword, fName, lName, address, dob, phone);
            } else {
                System.out.println("Password don't match");
            }
        } else {
            adminDAO.updateUser(user.getEmail(), user.getPassword(), fName, lName, address, dob, phone);
        }

        user.setFname(fName);
        user.setLname(lName);
        user.setAddress(address);
        user.setDob(dob);
        user.setPhone(phone);

        request.getSession().setAttribute("user", user);

        request.getRequestDispatcher("admin-ViewAccount.jsp").forward(request, response);
    }
}
