package crud;

import connect.ConnectionImpl;
import org.example.Entity.City;
import org.example.Entity.User;
import org.example.Repository.UserRepository;
import org.junit.jupiter.api.Test;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class UserTest {
    public final static User user = new User();
    public final static UserRepository userRepository = new UserRepository(new ConnectionImpl());

    @Test
    public void insertUserTest() throws SQLException {
        initUser();
        assertEquals(user.getIdUser(), userRepository.get(user.getIdUser()).getIdUser());

    }

    @Test
    public void deleteUserTest() throws SQLException {
        initUser();
        userRepository.delete(user.getIdUser());
        assertNull(userRepository.get(user.getIdUser()));

    }

    @Test
    public void getUserTest() throws SQLException {
        initUser();
        assertEquals(user.getIdUser(), userRepository.get(user.getIdUser()).getIdUser());

    }

    @Test
    public void updateUserTest() throws SQLException {
        initUser();
        user.setCity(City.Kazan);
        userRepository.update(user);
        assertEquals(user.getCity(), userRepository.get(user.getIdUser()).getCity());
    }

    @Test
    public void getByEmailUserTest() {
        initUser();
        assertEquals(user.getEmail(), userRepository.getByEmail(user.getEmail()).getEmail());


    }

    void initUser() {
        user.setFullName("Maxim");
        user.setEmail("max@gmail.com");
        user.setPassword("qazwsx");
        user.setCity(City.Omsk);
        User user1 = userRepository.insert(user);
        user.setIdUser(user1.getIdUser());
    }


}
