package uts.bank.Controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/trans/*")
public class TransServlet extends BaseServlet{
    public void add(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        System.out.println("trans/add");
    }
    public void selectAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        System.out.println("trans/selectAll");
    }
    
}
