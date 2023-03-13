package org.example;
import org.example.ConnectionManager.ConnectionManager;
import org.example.Entity.City;
import org.example.Entity.User;
import org.example.Repository.UserRepository;
import org.postgresql.Driver;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {

        Class<Driver> driverClass=Driver.class;
        User user = new User();
        UserRepository userRepository=new UserRepository();
        user.setIdUser(4);
        user.setFullName("AAAA");
        user.setEmail("ppppp@mail.com");
        user.setPassword("CRUSH");
        user.setCity(City.Omsk);
        //userRepository.update(user);
        //userRepository.delete(1);
        //User u=userRepository.get(2);
        User user2 = new User();
        user2.setIdUser(5);
        user2.setFullName("Medina Saidova");
        user2.setEmail("madina@mail.ru");
        user2.setPassword("bhbunji12");
        user2.setCity(City.Samara);
        userRepository.insert(user2);

        //System.out.println(user);
        //userRepository.insert(user);
        //userRepository.update(user);

    }
}