package crud;

import org.example.DaoImpl.UserDaoImpl;
import org.example.Entity.City;
import org.example.Entity.User;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class UserTest {
    UserDaoImpl userDao=new UserDaoImpl();


    @Test
    public void getUserTest() throws SQLException {
        User user =new User();
        user.setCity(City.Moscow);
        user.setEmail("email.ru");
        user.setPassword("123");
        user.setFullName("laha");
        User user2=userDao.getByName("laha");
        assertEquals(user.getFullName(),user2.getFullName());
    }
    @Test
    public void insertUserTest(){
        User user =new User();
        user.setCity(City.Kazan);
        user.setEmail("qazwsx12.ru");
        user.setPassword("password123");
        user.setFullName("Diana");
        userDao.insert(user);
        User user2=userDao.getByName("Diana");
        assertEquals(user.getFullName(),user2.getFullName());
    }
    @Test
    public void updateUserTest(){
        User user =new User();
        user.setCity(City.Kazan);
        user.setEmail("rain@emai.com");
        user.setPassword("uhb123");
        user.setFullName("Dima");
        userDao.insert(user);
        User user2=userDao.getByName("Dima");
        user.setIdUser(user2.getIdUser());
        user.setFullName("Dima Romanov");
        userDao.update(user);
        assertEquals(user.getFullName(), userDao.getByName(user.getFullName()).getFullName());

    }
    @Test
    public void deleteUserTest() throws SQLException {
        User user =new User();
        user.setCity(City.Kazan);
        user.setEmail("rain@emai.com");
        user.setPassword("uhb123");
        user.setFullName("Dima Romanov");
        user.setIdUser(userDao.getByName("Dima Romanov").getIdUser());
        userDao.delete(user.getIdUser());
        assertEquals(null, userDao.get(user.getIdUser()));
    }
}
