package com.sokil.servlet;

import com.sokil.configuration.ConnectionManager;
import com.sokil.dao.IUserDAO;
import com.sokil.dao.impl.UserDAOImpl;
import com.sokil.entity.User;
import com.sokil.service.IUserService;
import com.sokil.service.impl.UserServiceImpl;
import lombok.extern.log4j.Log4j;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = { "/allusers"})
@Log4j
public class UserServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private IUserDAO userDAO;
    private IUserService userService;
    private Connection connection;

    public void init() {
        connection = ConnectionManager.getConnection();
        try {
            userDAO = new UserDAOImpl(connection);
            userService = new UserServiceImpl(userDAO);
        } catch (SQLException e) {
            log.error("UserServlet.init() :" + e.getMessage());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> list = new ArrayList<>();
        try {
            list = userService.getAllUsers();
        } catch (SQLException e) {
            log.error("UserServlet.doGet() :" + e.getMessage());
        }
        request.setAttribute("users", list);
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/user-page.jsp");
        dispatcher.forward(request, response);
    }
}
