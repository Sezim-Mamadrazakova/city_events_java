package org.example.Repository;

import org.example.ConnectionManager.ConnectionManager;
import org.example.Dao.FavoriteDao;
import org.example.Entity.Favorites;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.example.Repository.UserRepository.close;

public class FavoriteRepository implements FavoriteDao {
    private static final String INSERT = "INSERT INTO Favorites(idFav,idUserFK, idEventFK) " +
            "VALUES(?, ?, ?)";
    private static final String DELETE = "DELETE FROM Favorites WHERE idFav=?";
    private static final String UPDATE = "UPDATE Favorites SET idUserFK=?, idEventFK=? WHERE idFav=?";

    private static final String GET = "SELECT * FROM Favorites WHERE idFav=?";
    @Override
    public Favorites get(long idFavorite) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet;
        try{
            connection= ConnectionManager.openConnection();
            statement=connection.prepareStatement(GET);
            statement.setLong(1,idFavorite);
            resultSet=statement.executeQuery();
            if (resultSet.next()){
                Favorites fav=new Favorites();
                fav.setIdFavorite(resultSet.getInt("idFav"));
                fav.setIdUser(resultSet.getInt("idUserFK"));
                fav.setIdEvent(resultSet.getInt("idEventFK"));
                return fav;
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
    public void insert(Favorites favorites) {
        Connection connection=null;
        PreparedStatement statement=null;
        try{
            connection=ConnectionManager.openConnection();
            statement=connection.prepareStatement(INSERT);
            statement.setLong(1,favorites.getIdFavorite());
            statement.setLong(2,favorites.getIdUser());
            statement.setLong(3,favorites.getIdEvent());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(connection);
            close(statement);
        }


    }

    @Override
    public void update(Favorites favorites) {
        Connection connection=null;
        PreparedStatement statement=null;
        try{
            connection=ConnectionManager.openConnection();
            statement=connection.prepareStatement(UPDATE);
            statement.setLong(1,favorites.getIdUser());
            statement.setLong(2,favorites.getIdEvent());
            statement.setLong(3,favorites.getIdFavorite());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        close(connection);
        close(statement);

    }

    @Override
    public void delete(long idFavorite) {
        Connection connection=null;
        PreparedStatement statement=null;
        try{
            connection=ConnectionManager.openConnection();
            statement=connection.prepareStatement(DELETE);
            statement.setLong(1,idFavorite);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        close(connection);
        close(statement);

    }
}
