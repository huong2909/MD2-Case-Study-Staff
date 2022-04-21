package com.company.controller;

import com.company.model.Staff;
import com.company.service.Staff.StaffServiceIMPL;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StaffController {
    StaffServiceIMPL staffServiceIMPL = new StaffServiceIMPL();
    public List<Staff> showListStaff()  {
        return staffServiceIMPL.findAll();
    }
    public void createStaff(Staff staff)  {
        staffServiceIMPL.save(staff);
    }
    public void deleteStaff(int id){
        staffServiceIMPL.delete(id);
    }
    public void checkStatusByName(String name){
        staffServiceIMPL.checkStatusByName(name);
    }
    public void editStaffById(int id, String name,int age, String country,String status, String workingType) {
        staffServiceIMPL.editStaffById(id,name,age,country,status,workingType);
    }
    public void findById(int id){
        staffServiceIMPL.findById(id);
    }
    public void findByName(String name){
        staffServiceIMPL.findByName(name);
    }
    public void editStatus(int id){
        staffServiceIMPL.editStatus(id);
    }
    public void phanLoai(String workingType){
        staffServiceIMPL.phanloai(workingType);
    }

    public List<Staff> showListSalaryFull()  {
        return staffServiceIMPL.findSalary();
    }
    public void createSalaryFull(Staff staff)  {
        staffServiceIMPL.saveSalaryFull(staff);
    }
    public List<Staff> showListSalaryPart()  {
        return  staffServiceIMPL.findSalaryPart();
    }
    public void createSalaryPart(Staff staff)  {
        staffServiceIMPL.saveSalaryPart(staff);
    }
}