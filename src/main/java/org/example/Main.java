package org.example;

import org.example.Entity.City;
import org.example.Entity.User;
import org.example.DaoImpl.UserDaoImpl;

public class Main {
    public static void main(String[] args) {

        User user = new User();
        UserDaoImpl userRepository=new UserDaoImpl();
        user.setFullName("Vghjgjh drdr");
        user.setEmail("nful23145@mail.ru");
        user.setPassword("passqord");
        user.setCity(City.Samara);
        //userRepository.insert(user);
        //userRepository.delete(9);
        userRepository.update(user);
    }
}