package org.example.Repository;



import org.example.ConnectionFactory.ConnectionBuilder;
import org.example.Entity.Event;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class EventRepository   {
    private final Connection connection;
    public EventRepository(ConnectionBuilder connection)  {
        this.connection= connection.getConnection();
    }

    private static final String INSERT = "INSERT INTO Events( eventName, eventPlace, dateStart, duration) " +
            "VALUES(?, ?, ?, ?)";
    private static final String DELETE = "DELETE FROM Events WHERE idEvent=?";
    private static final String UPDATE = "UPDATE Events SET eventName=?, eventPlace=?,dateStart=?,duration=?" +
            " WHERE idEvent=?";

    private static final String GET = "SELECT idevent, eventname, eventplace,datestart, duration FROM Events WHERE idEvent=?";
    private static final String GET_All="SELECT idevent, eventname, eventplace,datestart, duration FROM Events";
    private static final String GET_BY_NAME="SELECT idevent, eventname, eventplace,datestart, duration FROM Events WHERE eventname=?";


    public Event get(Long idEvent) throws SQLException {

        try{
            PreparedStatement statement=connection.prepareStatement(GET);
            statement.setLong(1,idEvent);
            ResultSet resultSet=statement.executeQuery();
            if (resultSet.next()){
                Event event=new Event();
                event.setIdEvent(resultSet.getLong("idEvent"));
                event.setEventName(resultSet.getString("eventName"));
                event.setEventPlace(resultSet.getString("eventPlace"));
                event.setDateStart(resultSet.getTimestamp("dateStart"));
                event.setDuration(resultSet.getString("duration"));
                return event;

            }
            else {
                return null;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public Event insert(Event event) throws SQLException {
        try{
            PreparedStatement statement=connection.prepareStatement(INSERT, new String[]{"idevent"});
            statement.setString(1,event.getEventName());
            statement.setString(2,event.getEventPlace());
            statement.setTimestamp(3,event.getDateStart());
            statement.setString(4,event.getDuration());
            statement.executeUpdate();
            var generetedKey=statement.getGeneratedKeys();
            generetedKey.next();
            event.setIdEvent(generetedKey.getLong("idevent"));
            return event;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void update(Event event) {

        try{
            PreparedStatement statement = connection.prepareStatement(UPDATE);
            statement.setString(1, event.getEventName());
            statement.setString(2,event.getEventPlace());
            statement.setTimestamp(3,event.getDateStart());
            statement.setString(4, event.getDuration());
            statement.setLong(5, event.getIdEvent());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void delete(Long idEvent) {

        try{

            PreparedStatement statement=connection.prepareStatement(DELETE);
            statement.setLong(1,idEvent);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public Event getByEventName(String eventName) {
        try{
            PreparedStatement statement=connection.prepareStatement(GET_BY_NAME);
            statement.setString(1,eventName);
            ResultSet resultSet=statement.executeQuery();
            if (resultSet.next()){
                Event event=new Event();
                event.setIdEvent(resultSet.getLong("idEvent"));
                event.setEventName(resultSet.getString("eventName"));
                event.setEventPlace(resultSet.getString("eventPlace"));
                event.setDateStart(resultSet.getTimestamp("dateStart"));
                event.setDuration(resultSet.getString("duration"));
                return event;

            }
            else {
                return null;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Event> getAll() {
        List<Event> events=new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(GET_All);
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next()){
                Event event=new Event(resultSet.getLong("idEvent"),
                        resultSet.getString("eventName"),
                        resultSet.getString("eventPlace"),
                        resultSet.getTimestamp("dateStart"),
                        resultSet.getString("duration"));
//                event.setIdEvent(resultSet.getLong("idEvent"));
//                event.setEventName(resultSet.getString("eventName"));
//                event.setEventPlace(resultSet.getString("eventPlace"));
//                event.setDateStart(resultSet.getTimestamp("dateStart"));
//                event.setDuration(resultSet.getString("duration"));
                events.add(event);
            }
            //return events;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return events;
    }
}
