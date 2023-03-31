package org.example.DaoImpl;



import org.example.ConnectionManager.ConnectionManager;
import org.example.Dao.EventDao;
import org.example.Entity.Event;

import java.sql.*;


public class EventDaoImpl implements EventDao {
    private static final String INSERT = "INSERT INTO Events( eventName, eventPlace, dateStart, duration, idUserFK) " +
            "VALUES(?, ?, ?, ?, ?)";
    private static final String DELETE = "DELETE FROM Events WHERE idEvent=?";
    private static final String UPDATE = "UPDATE Events SET eventName=?, eventPlace=?, dateStart=?, duration=?, idUserFK=?" +
            " WHERE idEvent=?";

    private static final String GET = "SELECT idevent, eventname, eventplace,datestart, duration,iduserfk FROM Events WHERE idEvent=?";
    private static final String GET_BY_NAME="SELECT idevent, eventname, eventplace,datestart, duration,iduserfk FROM Events WHERE eventname=?";
    @Override
    public Event get(long idEvent) throws SQLException {

        try(Connection connection= ConnectionManager.openConnection();){
            PreparedStatement statement=connection.prepareStatement(GET);
            statement.setLong(1,idEvent);
            ResultSet resultSet=statement.executeQuery();
            if (resultSet.next()){
                Event event=new Event();
                event.setIdEvent(resultSet.getInt("idEvent"));
                event.setEventName(resultSet.getString("eventName"));
                event.setEventPlace(resultSet.getString("eventPlace"));
                event.setDateStart(resultSet.getTimestamp("dateStart"));
                event.setDuration(resultSet.getString("duration"));
                event.setIdUser(resultSet.getInt("idUserFK"));
                return event;

            }
            else {
                return null;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void insert(Event event) throws SQLException {
        try(Connection connection=ConnectionManager.openConnection();){
            PreparedStatement statement=connection.prepareStatement(INSERT);
            statement.setString(1,event.getEventName());
            statement.setString(2,event.getEventPlace());
            statement.setTimestamp(3,event.getDateStart());
            statement.setString(4,event.getDuration());
            statement.setLong(5,event.getIdUser());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void update(Event event) {

        try(Connection connection=ConnectionManager.openConnection();){
            PreparedStatement statement = connection.prepareStatement(UPDATE);
            statement.setString(1, event.getEventName());
            statement.setString(2, event.getEventPlace());
            statement.setTimestamp(3,event.getDateStart());
            statement.setString(4, event.getDuration());
            statement.setLong(5,event.getIdUser());
            statement.setLong(6, event.getIdEvent());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(long idEvent) {

        try(Connection connection=ConnectionManager.openConnection();){

            PreparedStatement statement=connection.prepareStatement(DELETE);
            statement.setLong(1,idEvent);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Event getByEventName(String eventName) {
        try(Connection connection= ConnectionManager.openConnection();){
            PreparedStatement statement=connection.prepareStatement(GET_BY_NAME);
            statement.setString(1,eventName);
            ResultSet resultSet=statement.executeQuery();
            if (resultSet.next()){
                Event event=new Event();
                event.setIdEvent(resultSet.getInt("idEvent"));
                event.setEventName(resultSet.getString("eventName"));
                event.setEventPlace(resultSet.getString("eventPlace"));
                event.setDateStart(resultSet.getTimestamp("dateStart"));
                event.setDuration(resultSet.getString("duration"));
                event.setIdUser(resultSet.getInt("idUserFK"));
                return event;

            }
            else {
                return null;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
