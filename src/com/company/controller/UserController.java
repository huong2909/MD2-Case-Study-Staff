package com.company.controller;

import com.company.config.ConfigReadAndWriteFile;
import com.company.model.User;
import com.company.service.user.UserServiceIMPL;

import java.io.IOException;
import java.util.List;

public class UserController {
    UserServiceIMPL userServiceIMPL = new UserServiceIMPL();
    public List<User> showListUser() {
        return userServiceIMPL.findAll();
    }
    public void createUser(User user)  {
        userServiceIMPL.save(user);
    }
    public List<User> showListUserLogin() {
        return userServiceIMPL.findAllLogin();
    }
    public void createUserLogin(User user)  {
        userServiceIMPL.saveLogin(user);
    }
    public void deleteUser(int id){
        userServiceIMPL.delete(id);
    }
    public void findById(int id){
        userServiceIMPL.findById(id);
    }


}
