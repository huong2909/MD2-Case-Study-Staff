package com.company.model;

import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private String name;
    private String userName;
    private String password;
    private String email;
    private Role.RoleName roleName;

    public User() {
    }

    public User(int id, String name, String userName, String password, String email, Role.RoleName roleName) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.roleName = roleName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role.RoleName getRoleName() {
        return roleName;
    }

    public void setRoleName(Role.RoleName roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", userName='" + userName + '\'' +
//                ", password='" + password + '\'' +
//                ", email='" + email + '\'' +
//                ", roleName=" + roleName +
//                '}'+"\n";
        return String.format("\tID: %1s || Name: %15s || Username: %12s || Password: %10s || Email: %20s || roleName %5s \n",id,name,userName,password,email,roleName);
    }

}
