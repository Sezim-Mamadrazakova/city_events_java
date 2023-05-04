package org.example.Service;

import org.example.DaoImplContainer.EventDaoImpl;
import org.example.Entity.Event;
import org.example.Repository.EventRepository;

import java.sql.SQLException;
import java.util.List;

public class EventService {
    private final EventDaoImpl eventDaoImpl;

    public EventService() {
        this.eventDaoImpl = new EventDaoImpl();

    }
    public Event insert(Event event){
        try{
            return eventDaoImpl.insert(event);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void delete(Long idEvent){
        try{
            eventDaoImpl.delete(idEvent);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void update(Event event){
        try{
            eventDaoImpl.update(event);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public Event get(Long id){
        try{
            return eventDaoImpl.get(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Event getByName(String name){
        try{
            return eventDaoImpl.getByEventName(name);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public List<Event> getAll(){
        try {
            return eventDaoImpl.getAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
