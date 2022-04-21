package com.company.config;

import com.company.model.Staff;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ConfigReadAndWriteFile<T> {
    public List<T> readFromFile(String path){
        List<T> tList = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            tList = (List<T>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return tList;
    }
    public void writeToFile(String path, List<T> tList){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(tList);
            fileOutputStream.close();
            objectOutputStream.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
