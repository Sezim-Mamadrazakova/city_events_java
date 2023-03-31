package crud;
import org.example.DaoImpl.EventDaoImpl;
import org.example.DaoImpl.UserDaoImpl;

import org.example.Entity.Event;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
public class EventTest {
    EventDaoImpl eventDao=new EventDaoImpl();
    @Test
    public void getEventTest(){
        Event event=new Event();
        event.setEventName("venera");
        event.setEventPlace("Nikitinskaya 22");
        event.setDateStart(Timestamp.valueOf("2023-04-05 18:00:00"));
        event.setDuration("2 hour");
        event.setIdUser(11);
        Event e2=eventDao.getByEventName("venera");
        assertEquals(event.getEventName(), e2.getEventName());
    }
    @Test
    public void insertEventTest() throws SQLException {
        Event event=new Event();
        event.setEventName("venera");
        event.setEventPlace("Nikitinskaya 22");
        event.setDateStart(Timestamp.valueOf("2023-04-05 18:00:00"));
        event.setDuration("2 hour");
        event.setIdUser(11);
        eventDao.insert(event);
        Event e2=eventDao.getByEventName("venera");
        assertEquals(event.getEventName(), e2.getEventName());

    }
    @Test
    public void updateEventTest() throws SQLException {
        Event event=new Event();
        event.setEventName("venera");
        event.setEventPlace("Nikitinskaya 22");
        event.setDateStart(Timestamp.valueOf("2023-04-05 18:00:00"));
        event.setDuration("2 hour");
        event.setIdUser(11);
        Event e2=eventDao.getByEventName("Sun");
        event.setIdEvent(e2.getIdEvent());
        event.setEventName("Venera");
        eventDao.update(event);
        assertEquals(event.getEventName(), eventDao.getByEventName(event.getEventName()).getEventName());
    }
    @Test
    public void deleteEventTest() throws SQLException {
        Event event=new Event();
        event.setEventName("venera");
        event.setEventPlace("Nikitinskaya 22");
        event.setDateStart(Timestamp.valueOf("2023-04-05 18:00:00"));
        event.setDuration("2 hour");
        event.setIdUser(11);
        event.setIdEvent(eventDao.getByEventName("Venera").getIdEvent());
        eventDao.delete(event.getIdEvent());
        assertEquals(null, eventDao.get(event.getIdEvent()));
    }
}
