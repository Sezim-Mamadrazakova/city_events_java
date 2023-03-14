package org.example.Repository;

import org.example.ConnectionManager.ConnectionManager;
import org.example.Dao.EventDao;
import org.example.Entity.Event;
import org.example.Entity.User;

import java.sql.*;

import static org.example.Repository.UserRepository.close;

public class EventRepository implements EventDao {
    private static final String INSERT = "INSERT INTO Events(idEvent, eventName, eventPlace, dateStart, duration, idUserFK) " +
            "VALUES(?, ?, ?, ?, ?, ?)";
    private static final String DELETE = "DELETE FROM Events WHERE idEvent=?";
    private static final String UPDATE = "UPDATE Events SET eventName=?, eventPlace=?, dateStart=?, duration=?, idUserFK=?" +
            " WHERE idEvent=?";

    private static final String GET = "SELECT * FROM Events WHERE idEvent=?";
    @Override
    public Event get(long idEvent) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet;
        try{
            connection= ConnectionManager.openConnection();
            statement=connection.prepareStatement(GET);
            statement.setLong(1,idEvent);
            resultSet=statement.executeQuery();
            if (resultSet.next()){
                Event event=new Event();
                event.setIdEvent(resultSet.getInt("idEvent"));
                event.setEventName(resultSet.getString("eventName"));
                event.setEventPlace(resultSet.getString("eventPlace"));
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
        finally {
            close(connection);
            close(statement);
        }
    }

    @Override
    public void insert(Event event) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection=ConnectionManager.openConnection();
            statement=connection.prepareStatement(INSERT);
            statement.setLong(1,event.getIdEvent());
            statement.setString(2,event.getEventName());
            statement.setString(3,event.getEventPlace());
            statement.setDate(4,event.getDateStart());
            statement.setString(5,event.getDuration());
            statement.setLong(6,event.getIdUser());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            close(connection);
            close(statement);
        }
    }

    @Override
    public void update(Event event) {
        Connection connection=null;
        PreparedStatement statement=null;
        try{
            connection=ConnectionManager.openConnection();
            statement=connection.prepareStatement(UPDATE);
            statement.setString(1, event.getEventName());
            statement.setString(2, event.getEventPlace());
            statement.setDate(3,event.getDateStart());
            statement.setString(4, event.getDuration());
            statement.setInt(5,event.getIdUser());
            statement.setLong(6, event.getIdEvent());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(connection);
            close(statement);
        }


    }

    @Override
    public void delete(long id) {
        Connection connection=null;
        PreparedStatement statement=null;
        try{
            connection=ConnectionManager.openConnection();
            statement=connection.prepareStatement(DELETE);
            statement.setLong(1,id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection);
            close(statement);
        }

    }
}
