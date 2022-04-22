package com.company.model;

import java.io.Serializable;

public class Staff implements Serializable {
    private int id;
    private String name;
    private int age;
    private String country;
    private String status;
    private String workingType;

    public Staff(int id, String name, int age, String country, String status, String workingType) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.country = country;
        this.status = status;
        this.workingType = workingType;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getWorkingType() {
        return workingType;
    }

    public void setWorkingType(String workingType) {
        this.workingType = workingType;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
//        return "Staff [ Id: " + id +
//                " || Name: " + name +
//                " || Age: " + age +
//                " || Country: " + country +
//                " || Status: " + status +
//                " || WorkingType: " + workingType +
//                ']'+"\n";
        return String.format("\tID: %1s || Name: %15s || Age: %3s || Country: %12s || Status: %13s || WorkingType: %8s \n",id,name,age,country,status,workingType);

    }
}
