package org.example.Servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.DaoImplContainer.EventDaoImpl;
import org.example.DaoImplContainer.FavoriteDaoImpl;
import org.example.DaoImplContainer.UserDaoImpl;
import org.example.Entity.Event;
import org.example.Service.EventService;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@WebServlet("/")

public class WelcomePageServlet extends HttpServlet {
    private final EventService eventService;
    public WelcomePageServlet(){
        super();
        eventService = new EventService();
    }



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        String action=req.getParameter("action");
//        if(action==null){
//            action="list";
//        }
//        if(action.equalsIgnoreCase("delete")){
//            deleteEvent(req, resp);
//        } else if (action.equalsIgnoreCase("edit")) {
//            Long id=Long.parseLong(req.getParameter("idEvent"));
//            Event event=eventService.get(id);
//            req.setAttribute("event", event);
//            RequestDispatcher requestDispatcher=req.getRequestDispatcher("WEB-INF/JSP/event.jsp");
//            requestDispatcher.forward(req, resp);
//
//        }
//        else if(action.equalsIgnoreCase("list")){
//            allEvent(req, resp);
//        }
//        else {
//            RequestDispatcher requestDispatcher=req.getRequestDispatcher("WEB-INF/JSP/event.jsp");
//            requestDispatcher.forward(req, resp);
//        }
        String action=req.getServletPath();

        switch (action){


            case "/delete":
                deleteEvent(req,resp);
                break;
            case "/edit":
                showEditForm(req,resp);
                break;
            case "/insert":
                insertEvent(req,resp);
            case "/new":
                showNewForm(req, resp);
                break;
            case "/list":
                allEvent(req, resp);
                break;
            case "/update":
                updateEvent(req,resp);
            default:
                allEvent(req, resp);
                break;

        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        doGet(req,resp);
//        Event event=new Event();
//        event.setEventName(req.getParameter("eventName"));
//        event.setEventPlace(req.getParameter("eventPlace"));
//        event.setDateStart(Timestamp.valueOf(req.getParameter("dateStart")));
//        event.setDuration(req.getParameter("duration"));
//        Long id= Long.valueOf(req.getParameter("idEvent"));
//        if(id==null){
//            eventService.insert(event);
//        }
//        else {
//            event.setIdEvent(id);
//            eventService.update(event);
//        }
//        RequestDispatcher requestDispatcher=req.getRequestDispatcher("WEB-INF/JSP/user/welcome.jsp");
//        req.setAttribute("eventList", eventService.getAll());
//        requestDispatcher.forward(req, resp);

    }

    private void deleteEvent(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Long id=Long.parseLong(req.getParameter("idEvent"));
        eventService.delete(id);
        req.setAttribute("eventList",eventService.getAll());

        RequestDispatcher requestDispatcher=req.getRequestDispatcher("WEB-INF/JSP/user/welcome.jsp");
        requestDispatcher.forward(req, resp);

    }

    private void allEvent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var a = eventService.getAll();
        req.setAttribute("eventList",a);
        RequestDispatcher requestDispatcher=req.getRequestDispatcher("WEB-INF/JSP/user/welcome.jsp");
        requestDispatcher.forward(req, resp);
    }
    private void updateEvent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id=Long.parseLong(req.getParameter("idEvent"));
        String eventName=req.getParameter("eventName");
        String eventPlace=req.getParameter("eventPlace");
        Timestamp dataStart= Timestamp.valueOf(req.getParameter("dateStart"));
        String duration=req.getParameter("duration");
        Event event=eventService.get(id);
        event.setEventName(eventName);
        event.setEventPlace(eventPlace);
        event.setDateStart(dataStart);
        event.setDuration(duration);
        eventService.update(event);


        RequestDispatcher requestDispatcher=req.getRequestDispatcher("WEB-INF/JSP/user/welcome.jsp");
        requestDispatcher.forward(req, resp);
    }
//    private void searchEvent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String search=req.getParameter("search");
//        Event event=eventService.getByName(search);
//        req.setAttribute("event", event);
//        RequestDispatcher requestDispatcher=req.getRequestDispatcher("WEB-INF/JSP/search.jsp");
//        requestDispatcher.forward(req, resp);
//    }
    private void insertEvent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Event event=new Event();
        event.setEventName(req.getParameter("eventName"));
        event.setEventPlace(req.getParameter("eventPlace"));
        event.setDateStart(Timestamp.valueOf(req.getParameter("dateStart")));
        event.setDuration(req.getParameter("duration"));
        eventService.insert(event);
        RequestDispatcher requestDispatcher=req.getRequestDispatcher("WEB-INF/JSP/user/welcome.jsp");
        requestDispatcher.forward(req, resp);

    }
    private void showNewForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher requestDispatcher=req.getRequestDispatcher("WEB-INF/JSP/event.jsp");
        requestDispatcher.forward(req, resp);
    }
    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id=Long.parseLong(req.getParameter("idEvent"));
        Event event=eventService.get(id);
        RequestDispatcher requestDispatcher=req.getRequestDispatcher("WEB-INF/JSP/event.jsp");
        req.setAttribute("event", event);
        //getServletContext().getRequestDispatcher("/event.jsp").forward(req, resp);
        requestDispatcher.forward(req, resp);
    }


}
