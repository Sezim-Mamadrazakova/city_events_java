package org.example.DaoImpl;
import org.example.ConnectionManager.ConnectionManager;
import org.example.Dao.FavoriteDao;
import org.example.Entity.Favorites;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FavoriteDaoImpl implements FavoriteDao {
    private static final String INSERT = "INSERT INTO Favorites(idUserFK, idEventFK) " +
            "VALUES(?, ?)";
    private static final String DELETE = "DELETE FROM Favorites WHERE idFav=?";
    private static final String UPDATE = "UPDATE Favorites SET idUserFK=?, idEventFK=? WHERE idFav=?";

    private static final String GET = "SELECT idfav, iduserfk, ideventfk FROM Favorites WHERE idFav=?";
    @Override
    public Favorites get(long idFavorite) {

        try(Connection connection= ConnectionManager.openConnection()){
            PreparedStatement statement=connection.prepareStatement(GET);
            statement.setLong(1,idFavorite);
            ResultSet resultSet=statement.executeQuery();
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

    }

    @Override
    public void insert(Favorites favorites) {

        try(Connection connection=ConnectionManager.openConnection()){
            PreparedStatement statement=connection.prepareStatement(INSERT);
            statement.setLong(1,favorites.getIdUser());
            statement.setLong(2,favorites.getIdEvent());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void update(Favorites favorites) {
        try(Connection connection=ConnectionManager.openConnection()){
            PreparedStatement statement=connection.prepareStatement(UPDATE);
            statement.setLong(1,favorites.getIdUser());
            statement.setLong(2,favorites.getIdEvent());
            statement.setLong(3,favorites.getIdFavorite());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(long idFavorite) {
        try(Connection connection=ConnectionManager.openConnection()){
            PreparedStatement statement=connection.prepareStatement(DELETE);
            statement.setLong(1,idFavorite);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
