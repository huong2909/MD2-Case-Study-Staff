package com.company.service.Staff;

import com.company.config.ConfigReadAndWriteFile;
import com.company.model.Staff;
import com.company.view.MenuADMIN;

import java.io.IOException;
import java.util.List;

public class StaffServiceIMPL implements IStaffService{
    public static String PATH = "D:\\MD2-Case Study-Staff\\src\\com\\company\\data\\staff.txt";
    public static List<Staff> staffList = new ConfigReadAndWriteFile<Staff>().readFromFile(PATH);

    public static String PATH1 = "D:\\MD2-Case Study-Staff\\src\\com\\company\\data\\salary.txt";
    public static List<Staff> staffList1 = new ConfigReadAndWriteFile<Staff>().readFromFile(PATH1);

    public static String PATH2 = "D:\\MD2-Case Study-Staff\\src\\com\\company\\data\\SalaryPart.txt";
    public static List<Staff> staffList2 = new ConfigReadAndWriteFile<Staff>().readFromFile(PATH2);
    @Override
    public List<Staff> findAll()  {
        new ConfigReadAndWriteFile<Staff>().writeToFile(PATH,staffList);
        return staffList;
    }

    @Override
    public void save(Staff staff)  {
        staffList.add(staff);
        new ConfigReadAndWriteFile<Staff>().writeToFile(PATH,staffList);
    }
    @Override
    public void delete(int id) {
        String checkName = null;
        for (int i = 0; i < staffList.size(); i++) {
            if (id==staffList.get(i).getId()){
                staffList.remove(i);
                System.out.println("Đã xóa thành công!!!");
                findAll();
                new MenuADMIN();
            }
            if (id==staffList1.get(i).getId()){
                staffList1.remove(i);
            }
            if (id==staffList2.get(i).getId()){
                staffList2.remove(i);
            }
        }
        if (checkName==null)
            System.err.println("ID sai hoặc không tồn tại");
    }
    @Override
    public void checkStatusByName(String name) {
        String checkName = null;

        for (int i = 0; i < staffList.size(); i++) {
            if (name.equalsIgnoreCase(staffList.get(i).getName())){
                checkName =staffList.get(i).getStatus();
                System.out.println("ID "+staffList.get(i).getId()+"|| Name: "+staffList.get(i).getName() +"|| Status: "+ checkName);

            }
        }
        if (checkName==null)
        System.err.println("Tên sai hoặc không tồn tại");

    }
    @Override
    public void editStaffById(int id, String name,int age,String country,String status, String workingType) {
        for (int i = 0; i < staffList.size(); i++) {
            if (id == staffList.get(i).getId()){
                staffList.get(i).setName(name);
                staffList.get(i).setAge(age);
                staffList.get(i).setCountry(country);
                staffList.get(i).setWorkingType(workingType);
                staffList.get(i).setStatus(status);

            }
        }
    }

    @Override
    public void findById(int id) {
        for (int i = 0; i < staffList.size(); i++) {
            if (id==staffList.get(i).getId()){
                System.out.println(staffList.get(i));
            }
        }
    }

    @Override
    public void findByName(String name) {
        boolean checkName = false;
        for (int i = 0; i < staffList.size(); i++) {
            if (name.equalsIgnoreCase(staffList.get(i).getName())){
                System.out.println(staffList.get(i));
                checkName = true;
            }
        }
        if (checkName==false)
            System.err.println("Tên sai hoặc không tồn tại");

    }

    @Override
    public void editStatus(int id) {
        for (int i = 0; i < staffList.size(); i++) {
            if (id == staffList.get(i).getId()) {
                if (staffList.get(i).getStatus().equalsIgnoreCase("đang làm việc")) {
                    staffList.get(i).setStatus("Nghỉ việc");
                } else if (staffList.get(i).getStatus().equalsIgnoreCase("nghỉ việc")){
                    staffList.get(i).setStatus("Đang làm việc");
                }
            }
        }

    }

    @Override
    public void phanloai(String workingType) {
        for (int i = 0; i < staffList.size(); i++) {
            if (workingType.equalsIgnoreCase(staffList.get(i).getWorkingType())){
                System.out.println(staffList.get(i));
            }
        }
    }

    @Override
    public void saveSalaryFull(Staff staff)  {
        staffList1.add(staff);
        new ConfigReadAndWriteFile<Staff>().writeToFile(PATH1,staffList1);;
    }

    @Override
    public List<Staff> findSalary()  {
        new ConfigReadAndWriteFile<Staff>().writeToFile(PATH1,staffList1);
        return staffList1;
    }

    @Override
    public void saveSalaryPart(Staff staff)  {
       staffList2.add(staff);
       new ConfigReadAndWriteFile<Staff>().writeToFile(PATH2,staffList2);
    }

    @Override
    public List<Staff> findSalaryPart() {
       new ConfigReadAndWriteFile<Staff>().writeToFile(PATH2,staffList2);
       return staffList2;
    }

    @Override
    public void setUpSalaryFull(int id, String name, int age, String country, String status, String workingType, int bonus, int fine, int hardSalary) {
        for (int i = 0; i < staffList1.size(); i++) {
            if (id == staffList1.get(i).getId()){
                staffList1.get(i).setName(name);
                staffList1.get(i).setAge(age);
                staffList1.get(i).setCountry(country);
                staffList1.get(i).setWorkingType(workingType);
                staffList1.get(i).setStatus(status);

            }
        }
    }

}
