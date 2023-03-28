package org.example.DaoImpl;


import org.example.ConnectionManager.ConnectionManager;
import org.example.Dao.UserDao;
import org.example.Entity.City;
import org.example.Entity.User;

import java.sql.*;

public class UserDaoImpl implements UserDao {
    private static final String INSERT = "INSERT INTO Users(fullName, email, password, city) " +
            "VALUES(?, ?, ?, ?)";
    private static final String DELETE = "DELETE FROM users WHERE idUser=?";
    private static final String UPDATE = "UPDATE users SET fullName=?, email=?, password=?, city=? WHERE idUser=?";

    private static final String GET = "SELECT iduser, fullname, email, password, city FROM users WHERE idUser=?";

    @Override
    public User get(long idUser) throws SQLException {
        //Connection connection = null;
        //PreparedStatement statement = null;
        //ResultSet resultSet;
        try {
            try (Connection connection = ConnectionManager.openConnection()) {
                PreparedStatement statement = connection.prepareStatement(GET);
                statement.setLong(1, idUser);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    User user = new User();
                    user.setIdUser(resultSet.getInt("idUser"));
                    user.setFullName(resultSet.getString("fullName"));
                    user.setEmail(resultSet.getString("email"));
                    user.setPassword(resultSet.getString("password"));
                    //user.setCity((City) resultSet.getObject("city"));
                    user.setCity(City.valueOf(resultSet.getString("city")));
                    return user;
                }
                else{
                    return null;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(User user)  {

        try(Connection connection = ConnectionManager.openConnection();) {
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

    @Override
    public void delete(long id) {


        try(Connection connection = ConnectionManager.openConnection()) {

            PreparedStatement statement = connection.prepareStatement(DELETE);
            statement.setLong(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insert(User user) {


        try(Connection connection = ConnectionManager.openConnection()) {

            PreparedStatement statement = connection.prepareStatement(INSERT);
            //statement.setLong(1, user.getIdUser());
            statement.setString(1, user.getFullName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getCity().toString());
            statement.executeUpdate();
//            resultSet=statement.getGeneratedKeys();
//            if(resultSet.next()){
//                user.setIdUser(resultSet.getInt(1));
//            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
