package org.example.Dao;

import org.example.Entity.User;

import java.sql.SQLException;

public interface UserDao {
    public User get(long idUser) throws SQLException;

    public void update(User user) throws SQLException;

    public void delete(long id);

    public void insert(User user);
}
