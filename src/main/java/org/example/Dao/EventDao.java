package org.example.Dao;


import org.example.Entity.Event;

import java.sql.SQLException;
import java.util.List;

public interface EventDao {
    public Event get(Long idEvent) throws SQLException;

    public Event insert(Event event) throws SQLException;

    public void update(Event event);

    public void delete(Long idEvent);

    public Event getByEventName(String eventName);

    public List<Event> getAll();
}
