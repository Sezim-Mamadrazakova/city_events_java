package org.example;

import org.example.DaoImplContainer.EventDaoImpl;
import org.example.Entity.City;
import org.example.Entity.User;
import org.example.Repository.EventRepository;
import org.example.Entity.Event;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EventDaoImpl eventDao=new EventDaoImpl();

        List<Event> events=eventDao.getAll();
        for (int i=0; i<events.size();i++){
            System.out.println(events.get(i));
        }


//        UserDaoImpl userRepository=new UserDaoImpl();
//        user.setFullName("Vghjgjh drdr");
//        user.setEmail("nful23145@mail.ru");
//        user.setPassword("passqord");
//        user.setCity(City.Samara);
//        EventRepository eventDao=new EventRepository();
//        List<Event> eventList=eventDao.getAll();
//        System.out.println(eventList.size());

    }
}