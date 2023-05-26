package com.example.servlet;

import com.example.User;
import com.example.Warehouse;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.UnknownHostException;

@WebServlet("/add")
public class AddUserServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            getServletContext().getRequestDispatcher("/jsp/add.jsp").forward(req, resp);
        } catch (UnknownHostException uhex) {
            uhex.getCause().printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String firstName = req.getParameter("firstName");
            String lastName = req.getParameter("lastName");
            User user = new User(firstName, lastName);
            req.setAttribute("user", user);
            Warehouse warehouse = Warehouse.getInstance();
            warehouse.addUser(user);

            req.getServletContext().getRequestDispatcher("/jsp/add.jsp").forward(req, resp);
        } catch (UnknownHostException uhex) {
            uhex.getCause().printStackTrace();
        }
    }
}
