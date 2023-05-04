package org.example.DaoImplContainer;

import org.example.ConnectionFactory.ConnectionFactory;
import org.example.Dao.UserDao;
import org.example.Entity.User;

import java.sql.SQLException;
import org.example.Repository.UserRepository;

public class UserDaoImpl implements UserDao {

    private final UserRepository userRepository=new UserRepository(new ConnectionFactory());
    @Override
    public User get(Long idUser) throws SQLException {return userRepository.get(idUser);
    }
    @Override
    public void update(User user) throws SQLException {userRepository.update(user);
    }
    @Override
    public void delete(Long id) {userRepository.delete(id);
    }
    @Override
    public User insert(User user) {
        return userRepository.insert(user);
    }

    @Override
    public User getByName(String fullName) {
        return userRepository.getByName(fullName);
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.getByEmail(email);
    }
}
