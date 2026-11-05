package org.example.controller;

import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import org.example.model.business.User;
import org.example.model.data.UserDB;

@WebServlet("/emailList")
public class EmailListServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
        String url = "/index.html";

        String action = req.getParameter("action");
        if (action == null) {
            action = "join";
        }

        if (action.equals("join")) {
            url = "index.html";
        }
        else if (action.equals("add")) {
            String firstName = req.getParameter("firstName");
            String lastName = req.getParameter("lastName");
            String email = req.getParameter("email");

            User user = new User(firstName, lastName, email);
            UserDB.insert(user);

            req.setAttribute("user", user);
            url = "/thanks.jsp";
        }

        getServletContext().getRequestDispatcher(url).forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}