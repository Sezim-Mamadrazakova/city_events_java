package org.example.Repository;

import org.example.ConnectionManager.ConnectionManager;
import org.example.Dao.UserDao;
import org.example.Entity.City;
import org.example.Entity.User;

import java.sql.*;

public class UserRepository implements UserDao {
    private static final String INSERT = "INSERT INTO Users(idUser,fullName, email, password, city) " +
            "VALUES(?, ?, ?, ?, ?)";
    private static final String DELETE = "DELETE FROM users WHERE idUser=?";
    private static final String UPDATE = "UPDATE users SET fullName=?, email=?, password=?, city=? WHERE idUser=?";

    private static final String GET = "SELECT * FROM users WHERE idUser=?";

    @Override
    public User get(long idUser) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet;
        try {
            connection = ConnectionManager.openConnection();
            statement = connection.prepareStatement(GET);
            statement.setLong(1, idUser);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setIdUser(resultSet.getInt("idUser"));
                user.setFullName(resultSet.getString("fullName"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                //user.setCity((City) resultSet.getObject("city"));
                user.setCity(City.valueOf(resultSet.getString("city")));
                return user;
            } else {
                return null;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection);
            close(statement);

        }
    }

    @Override
    public void update(User user) throws SQLException {

        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionManager.openConnection();
            statement = connection.prepareStatement(UPDATE);
            //statement.setLong(1,user.getIdUser());
            statement.setString(1, user.getFullName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getCity().toString());
            statement.setLong(5, user.getIdUser());
            statement.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection);
            close(statement);
        }
    }

    @Override
    public void delete(long id) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionManager.openConnection();
            statement = connection.prepareStatement(DELETE);
            statement.setLong(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection);
            close(statement);
        }
    }

    @Override
    public void insert(User user) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionManager.openConnection();
            statement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, user.getIdUser());
            statement.setString(2, user.getFullName());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPassword());
            statement.setString(5, user.getCity().toString());
            statement.executeUpdate();
//            resultSet=statement.getGeneratedKeys();
//            if(resultSet.next()){
//                user.setIdUser(resultSet.getInt(1));
//            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection);
            close(statement);
        }
    }

    private static void close(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                // e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }

    private static void close(Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                // e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }
}
