package org.example.Servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.Entity.Event;
import org.example.Service.EventService;

import java.io.IOException;
import java.sql.Timestamp;


@WebServlet("/welcome")

public class WelcomePageServlet extends HttpServlet {
    private final EventService eventService;

    public WelcomePageServlet() {
        super();
        eventService = new EventService();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");
        if (action == null) {
            action = "list";
        }
        switch (action) {


            case "delete":
                deleteEvent(req, resp);
                break;
            case "edit":
                showEditForm(req, resp);
                break;
            case "insert":
                insertEvent(req, resp);
                break;
            case "new":
                showNewForm(req, resp);
                break;
            case "list":
                allEvent(req, resp);
                break;
            case "update":
                updateEvent(req, resp);
                break;
            case "search":
                searchEvent(req, resp);
                break;
//            default:
//                allEvent(req, resp);
//                break;

        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        doGet(req, resp);
    }

    private void deleteEvent(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Long id = Long.parseLong(req.getParameter("idEvent"));
        eventService.delete(id);
        req.setAttribute("eventList", eventService.getAll());

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/JSP/user/welcome.jsp");
        requestDispatcher.forward(req, resp);

    }

    private void allEvent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var a = eventService.getAll();
        req.setAttribute("eventList", a);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/JSP/user/welcome.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void updateEvent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("idEvent"));
        String eventName = req.getParameter("eventName");
        String eventPlace = req.getParameter("eventPlace");
        Timestamp dataStart = Timestamp.valueOf(req.getParameter("dateStart"));
        String duration = req.getParameter("duration");
        Event event = eventService.get(id);
        event.setEventName(eventName);
        event.setEventPlace(eventPlace);
        event.setDateStart(dataStart);
        event.setDuration(duration);
        eventService.update(event);


        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/JSP/user/welcome.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void searchEvent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/JSP/search.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void insertEvent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Event event = new Event();
        event.setEventName(req.getParameter("eventName"));
        event.setEventPlace(req.getParameter("eventPlace"));
        event.setDateStart(Timestamp.valueOf(req.getParameter("dateStart")));
        event.setDuration(req.getParameter("duration"));
        eventService.insert(event);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/JSP/user/welcome.jsp");
        requestDispatcher.forward(req, resp);

    }

    private void showNewForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/JSP/event.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("idEvent"));
        Event event = eventService.get(id);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/JSP/event.jsp");
        req.setAttribute("event", event);
        requestDispatcher.forward(req, resp);
    }


}
