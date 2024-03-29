package by.herman.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserViewCardServlet extends HttpServlet {

    private String firstName = "firstName";
    private String lastName = "firstName";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Card card = JDBC.findCardFromDB(firstName, lastName);
        req.setAttribute("card", card);
        req.getRequestDispatcher("WEB-INF/JSP/user.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

         firstName = req.getParameter("firstName");
         lastName = req.getParameter("lastName");

        resp.sendRedirect("/lab8/userViewCard");
    }

}
