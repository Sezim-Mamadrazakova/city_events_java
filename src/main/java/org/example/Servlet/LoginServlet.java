package org.example.Servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.DaoImplContainer.UserDaoImpl;
import org.example.Entity.User;
import org.example.Service.UserService;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private final UserService userService = new UserService(new UserDaoImpl());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/JSP/user/login.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        RequestDispatcher requestDispatcher;
        User user = userService.loginUser(email, password);
        if (user != null) {
            req.getSession().setAttribute("fullName", user.getFullName());
            req.getSession().setAttribute("loggedUser", user.getEmail());
            req.getSession().setAttribute("city", user.getCity());
            resp.sendRedirect(req.getContextPath() + "/welcome");
        } else {
            req.setAttribute("loggingAttempt", "Bad credentials");
            requestDispatcher = req.getRequestDispatcher("WEB-INF/JSP/login.jsp");
            requestDispatcher.forward(req, resp);
        }


    }
}
