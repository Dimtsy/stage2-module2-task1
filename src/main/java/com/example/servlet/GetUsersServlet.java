package com.example.servlet;

import com.example.User;
import com.example.Warehouse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.UnknownHostException;
import java.util.Set;

@WebServlet("/users")
public class GetUsersServlet extends HttpServlet {
    @Override
    public void init() {

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Set<User> userSet = Warehouse.getInstance().getUsers();
            req.setAttribute("users", userSet);
            req.getServletContext().getRequestDispatcher("/jsp/users.jsp").forward(req, resp);
        } catch (UnknownHostException uhex) {
            uhex.getCause().printStackTrace();
        }
    }
}