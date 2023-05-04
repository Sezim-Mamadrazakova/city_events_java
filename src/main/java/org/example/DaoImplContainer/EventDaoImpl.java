package org.example.DaoImplContainer;

import org.example.ConnectionFactory.ConnectionFactory;
import org.example.Dao.EventDao;
import org.example.Entity.Event;
import org.example.Repository.EventRepository;

import java.sql.SQLException;
import java.util.List;

public class EventDaoImpl implements EventDao {
    private final EventRepository eventRepository = new EventRepository(new ConnectionFactory());

    @Override
    public Event get(Long idEvent) throws SQLException {
        return eventRepository.get(idEvent);
    }

    @Override
    public Event insert(Event event) throws SQLException {
        return eventRepository.insert(event);
    }

    @Override
    public void update(Event event) {
        eventRepository.update(event);
    }

    @Override
    public void delete(Long idEvent) {
        eventRepository.delete(idEvent);
    }

    @Override
    public Event getByEventName(String eventName) {
        return eventRepository.getByEventName(eventName);
    }

    @Override
    public List<Event> getAll() {
        return eventRepository.getAll();
    }
}
