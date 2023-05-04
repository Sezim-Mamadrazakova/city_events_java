package org.example.Dao;
import org.example.Entity.User;

import java.sql.SQLException;

public interface UserDao {
    public User get(Long idUser) throws SQLException;

    public void update(User user) throws SQLException;

    public void delete(Long id);

    public User insert(User user);

    public User getByName(String fullName);
    public User getByEmail(String email);

}
