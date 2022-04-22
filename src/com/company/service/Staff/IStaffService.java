package com.company.service.Staff;

import com.company.model.FullTimeStaff;
import com.company.model.PartTimeStaff;
import com.company.model.Staff;
import com.company.service.IServiceGeneric;

import java.util.List;

public interface IStaffService extends IServiceGeneric<Staff> {
    void checkStatusByName(String name);

    void editStaffById(int id, String name,int age,String country, String status, String workingType);

    void findById(int id);

    void findByName(String name);

    void editStatus(int id);

    void getWorkingType(String workingType);

    void saveSalaryFull(FullTimeStaff fullTimeStaff) ;

    List<FullTimeStaff> findSalary() ;

    void saveSalaryPart(PartTimeStaff partTimeStaff) ;

    List<PartTimeStaff> findSalaryPart() ;
    void setUpSalaryFull(int id, int bonus, int fine, int hardSalary);
    }
