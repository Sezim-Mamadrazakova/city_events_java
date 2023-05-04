package crud;


import connect.ConnectionImpl;
import org.example.Entity.Event;
import org.example.Repository.EventRepository;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class EventTest {
    public final static Event event = new Event();
    public final static EventRepository eventRepository = new EventRepository(new ConnectionImpl());
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());

    @Test
    public void insertEventTest() throws SQLException {
        initEvent();
        assertEquals(event.getIdEvent(), eventRepository.get(event.getIdEvent()).getIdEvent());
    }

    @Test
    public void deleteEventTest() throws SQLException {
        initEvent();
        eventRepository.delete(event.getIdEvent());
        assertNull(eventRepository.get(event.getIdEvent()));
    }

    @Test
    public void getEventTest() throws SQLException {
        initEvent();
        assertEquals(event.getIdEvent(), eventRepository.get(event.getIdEvent()).getIdEvent());
    }

    @Test
    public void updateEventTest() throws SQLException {
        initEvent();
        event.setEventName("Чебурашка");
        eventRepository.update(event);
        assertEquals(event.getEventName(), eventRepository.get(event.getIdEvent()).getEventName());

    }

    @Test
    public void getByEventNameTest() throws SQLException {
        initEvent();
        assertEquals(event.getEventName(), eventRepository.getByEventName(event.getEventName()).getEventName());
    }

    @Test
    public void getAllEventTest() {
        List<Event> events = eventRepository.getAll();
        assertEquals(events.size(), eventRepository.getAll().size());
    }

    void initEvent() throws SQLException {
        event.setEventName("Буратино");
        event.setEventPlace("Куколкина 12");
        event.setDateStart(timestamp);
        event.setDuration("90 мин");
        Event event1 = eventRepository.insert(event);
        event.setIdEvent(event1.getIdEvent());
    }
}
