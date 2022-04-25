package com.company.controller;

import com.company.model.FullTimeStaff;
import com.company.model.PartTimeStaff;
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
    public void getWorkingType(String workingType){
        staffServiceIMPL.getWorkingType(workingType);
    }

    public List<FullTimeStaff> showListSalaryFull()  {
        return staffServiceIMPL.findSalary();
    }
    public void createSalaryFull(FullTimeStaff fullTimeStaff)  {

        staffServiceIMPL.saveSalaryFull(fullTimeStaff);
    }
    public List<PartTimeStaff> showListSalaryPart()  {
        return  staffServiceIMPL.findSalaryPart();
    }
    public void createSalaryPart(PartTimeStaff partTimeStaff)  {
        staffServiceIMPL.saveSalaryPart(partTimeStaff);
    }
    public void setUpSalaryFull(int id, int bonus, int fine, int hardSalary){
        staffServiceIMPL.setUpSalaryFull(id,bonus,fine,hardSalary);
    }
    public void deleteSalary(){
        staffServiceIMPL.deleteSalary();
    }
    public void deleteSalaryPart(){
        staffServiceIMPL.deleteSalaryPart();
    }
}
