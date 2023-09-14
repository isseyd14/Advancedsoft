package uts.bank.Controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import uts.bank.model.Card;
import uts.bank.model.DAO.CardDAO;

@WebServlet("/CardServlet")
public class CardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CardDAO cardDAO;

    public CardServlet() {
        this.cardDAO = new CardDAO();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
        }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            HttpSession session = request.getSession();
            List<Card> listCard = cardDAO.findAllCards();
            session.setAttribute("listCard", listCard);
            if(listCard !=null){
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("card.jsp");
            dispatcher.forward(request, response);
      }
    }



}



