package com.company.service.user;

import com.company.model.User;
import com.company.service.IServiceGeneric;

import java.io.IOException;
import java.util.List;

public interface IUserSevice extends IServiceGeneric<User> {
    List<User> findAllLogin() ;
    void saveLogin(User user) ;
    void findById(int id);
}
