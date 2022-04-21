package com.company.service.Staff;

import com.company.model.Staff;
import com.company.service.IServiceGeneric;

import java.io.IOException;
import java.util.List;

public interface IStaffService extends IServiceGeneric<Staff> {
    void checkStatusByName(String name);

    void editStaffById(int id, String name,int age,String country, String status, String workingType);

    void findById(int id);

    void findByName(String name);

    void editStatus(int id);

    void phanloai(String workingType);

    void saveSalaryFull(Staff staff) ;

    List<Staff> findSalary() ;

    void saveSalaryPart(Staff staff) ;

    List<Staff> findSalaryPart() ;
    }
