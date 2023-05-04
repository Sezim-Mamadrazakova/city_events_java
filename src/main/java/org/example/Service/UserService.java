package org.example.Service;

import org.example.DaoImplContainer.UserDaoImpl;
import org.example.Entity.User;

public class UserService {
    private final UserDaoImpl userDaoImpl;
    public UserService(UserDaoImpl userDaoImpl){
        this.userDaoImpl =userDaoImpl;
    }
    public Long createUser(User user){
        user.setPassword(String.valueOf(user.getPassword().hashCode()));
        User user1= userDaoImpl.insert(user);
        return user.getIdUser();
    }
    public User loginUser(String email, String password){
        User user= userDaoImpl.getByEmail(email);
        if(passwordToHash(password).equals(user.getPassword())){
            return user;
        }
        return null;
    }
    private String passwordToHash(String password){
        return String.valueOf(password.hashCode());
    }

}
