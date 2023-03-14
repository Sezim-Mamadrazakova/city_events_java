package org.example;
import org.example.ConnectionManager.ConnectionManager;
import org.example.Entity.City;
import org.example.Entity.Event;
import org.example.Entity.Favorites;
import org.example.Entity.User;
import org.example.Repository.EventRepository;
import org.example.Repository.FavoriteRepository;
import org.example.Repository.UserRepository;
import org.postgresql.Driver;
import java.sql.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws SQLException {


//        User user = new User();
//        UserRepository userRepository=new UserRepository();
//        user.setIdUser(4);
//        user.setFullName("AAAA");
//        user.setEmail("ppppp@mail.com");
//        user.setPassword("CRUSH");
//        user.setCity(City.Omsk);
//        //userRepository.update(user);
//        //userRepository.delete(1);
//        //User u=userRepository.get(2);
//        User user2 = new User();
//        user2.setIdUser(5);
//        user2.setFullName("Medina Saidova");
//        user2.setEmail("madina@mail.ru");
//        user2.setPassword("bhbunji12");
//        user2.setCity(City.Samara);
//        userRepository.delete(5);
        Event event=new Event();
        event.setIdEvent(3);
        event.setEventName("Birth");
        event.setEventPlace("Voronezh, 12");
        //LocalDate date1=LocalDate.of(2023,01,12);
        long ms=900000000;
        Date date=new Date(ms);
        event.setDateStart(date);
        event.setDuration("2:30");
        event.setIdUser(2);
        EventRepository eventRepository=new EventRepository();
        //eventRepository.insert(event);
        Event event2=new Event();
        event2.setIdEvent(3);
        event2.setEventName("ygyui");
        event2.setEventPlace("Voronezh, 12");
        //LocalDate date1=LocalDate.of(2023,01,12);
        long ms1=120000000;
        Date date1=new Date(ms1);
        event2.setDateStart(date1);
        event2.setDuration("2:00");
        event2.setIdUser(2);
        //eventRepository.update(event2);
        //eventRepository.delete(3);
        Favorites favorites=new Favorites();
        favorites.setIdFavorite(3);
        favorites.setIdUser(2);
        favorites.setIdEvent(1);
        FavoriteRepository favoriteRepository=new FavoriteRepository();
        //favoriteRepository.insert(favorites);
        Favorites favorites1=new Favorites();
        favorites1.setIdFavorite(0);
        favorites1.setIdUser(3);
        favorites1.setIdEvent(1);
        //favoriteRepository.update(favorites1);
        favoriteRepository.delete(0);



    }
}