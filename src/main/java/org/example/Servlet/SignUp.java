package org.example.Servlet;

import org.example.DaoImplContainer.UserDaoImpl;
import org.example.Entity.City;
import org.example.Entity.User;
import org.example.Service.UserService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/")
public class SignUp extends HttpServlet {
    private final UserService userService = new UserService(new UserDaoImpl());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/JSP/user/signup.jsp");
        requestDispatcher.forward(req, resp);
    }

    private List<String> getCity() {
        return List.of("Moscow", "Voronezh", "Kazan", "Omsk", "Samara", "Perm");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String fullName = req.getParameter("fullName");
        String city = req.getParameter("city");
        User user = new User();
        user.setEmail(email);
        user.setFullName(fullName);
        user.setPassword(password);
        user.setCity(City.valueOf(city));
        Long created = userService.createUser(user);
        boolean save = false;
        if (created != null) {
            save = true;
        }
        req.setAttribute("userCreated", save);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/JSP/user/login.jsp");
        requestDispatcher.forward(req, resp);


    }
}
