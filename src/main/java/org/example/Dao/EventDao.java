package org.example.Dao;



import org.example.Entity.Event;

import java.sql.SQLException;

public interface EventDao {
    public Event get(long idEvent) throws SQLException;
    public void insert(Event event) throws SQLException;
    public void update(Event event);
    public void delete(long idEvent);
}
