package org.example.Repository;


import org.example.ConnectionFactory.ConnectionBuilder;
import org.example.Entity.City;
import org.example.Entity.User;

import java.sql.*;

public class UserRepository {
    private final Connection connection;

    public UserRepository(ConnectionBuilder connection) {
        this.connection = connection.getConnection();
    }

    private static final String INSERT = "INSERT INTO Users(fullName, email, password, city) " +
            "VALUES(?, ?, ?, ?)";
    private static final String DELETE = "DELETE FROM users WHERE idUser=?";
    private static final String UPDATE = "UPDATE users SET fullName=?, email=?, password=?, city=? WHERE idUser=?";

    private static final String GET = "SELECT iduser, fullname, email, password, city FROM users WHERE idUser=?";
    private static final String GET_BY_NAME = "SELECT idUser,fullname, email, password, city FROM users WHERE fullName=?";
    private static final String GET_BY_EMAIL = "SELECT idUser, fullName, email, password, city FROM users WHERE email=?";

    public User get(Long idUser) throws SQLException {

        try {
            PreparedStatement statement = connection.prepareStatement(GET);
            statement.setLong(1, idUser);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setIdUser(resultSet.getLong("idUser"));
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
        }
    }


    public void update(User user) {

        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE);
            statement.setString(1, user.getFullName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getCity().toString());
            statement.setLong(5, user.getIdUser());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(Long id) {

        try {
            PreparedStatement statement = connection.prepareStatement(DELETE);
            statement.setLong(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public User insert(User user) {
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT, new String[]{"iduser"});
            statement.setString(1, user.getFullName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getCity().toString());
            statement.executeUpdate();
            var generetedKey = statement.getGeneratedKeys();
            generetedKey.next();
            user.setIdUser(generetedKey.getLong("idUser"));
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public User getByName(String fullName) {
        try {
            PreparedStatement statement = connection.prepareStatement(GET_BY_NAME);
            statement.setString(1, fullName);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setIdUser(resultSet.getLong("idUser"));
                user.setFullName(resultSet.getString("fullName"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setCity(City.valueOf(resultSet.getString("city")));
                return user;
            } else {
                return null;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public User getByEmail(String email) {
        try {
            PreparedStatement statement = connection.prepareStatement(GET_BY_EMAIL);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setIdUser(resultSet.getLong("idUser"));
                user.setFullName(resultSet.getString("fullName"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setCity(City.valueOf(resultSet.getString("city")));
                return user;
            } else {
                return null;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
