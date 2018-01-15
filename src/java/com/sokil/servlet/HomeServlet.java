package com.sokil.servlet;

import com.sokil.configuration.ConnectionManager;
import com.sokil.dao.IRoleDAO;
import com.sokil.dao.IUserDAO;
import com.sokil.dao.impl.RoleDAOImpl;
import com.sokil.dao.impl.UserDAOImpl;
import com.sokil.service.IRoleService;
import com.sokil.service.IUserService;
import com.sokil.service.impl.RoleServiceImpl;
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

@WebServlet(urlPatterns = { "/"})
@Log4j
public class HomeServlet extends HttpServlet{

    private static final long serialVersionUID = 1L;
    private IUserDAO userDAO;
    private IRoleDAO roleDao;
    private IUserService userService;
    private IRoleService roleService;

    public void init() {
        Connection connection = ConnectionManager.getConnection();
        try {
            userDAO = new UserDAOImpl(connection);
            roleDao = new RoleDAOImpl(connection);
            userService = new UserServiceImpl(userDAO);
            roleService = new RoleServiceImpl(roleDao);
        } catch (SQLException ex) {
            log.error("HomeServlet.init() :" + ex.getMessage());
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            insertUser(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/registration.jsp");
        dispatcher.forward(request, response);
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response) {
         try {
             roleService.saveRole(request);
             userService.saveUser(request);
             response.sendRedirect("/");
         } catch (SQLException ex ) {
             log.error("HomeServlet.insertUser() :" + ex.getMessage());
         } catch (IOException ex) {
             log.error("HomeServlet.insertUser() :" + ex.getMessage());
         }
    }
}
