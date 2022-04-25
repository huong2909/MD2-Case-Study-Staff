package com.company.service.Staff;

import com.company.config.ConfigReadAndWriteFile;
import com.company.model.FullTimeStaff;
import com.company.model.PartTimeStaff;
import com.company.model.Staff;
import com.company.view.Menu1;

import java.util.List;

public class StaffServiceIMPL implements IStaffService{
    public static String PATH = "D:\\MD2-Case Study-Staff\\src\\com\\company\\data\\staff.txt";
    public static List<Staff> staffList = new ConfigReadAndWriteFile<Staff>().readFromFile(PATH);

    public static String PATH1 = "D:\\MD2-Case Study-Staff\\src\\com\\company\\data\\salary.txt";
    public static List<FullTimeStaff> staffList1 = new ConfigReadAndWriteFile<FullTimeStaff>().readFromFile(PATH1);

    public static String PATH2 = "D:\\MD2-Case Study-Staff\\src\\com\\company\\data\\SalaryPart.txt";
    public static List<PartTimeStaff> staffList2 = new ConfigReadAndWriteFile<PartTimeStaff>().readFromFile(PATH2);
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
        boolean checkID = false;
        for (int i = 0; i < staffList.size(); i++) {

            if (id==staffList.get(i).getId()){
                staffList.remove(i);
                checkID = true;
                System.out.println("Đã xóa thành công!!!");
                findAll();

            }
        }
        if (checkID==false) {
            System.err.println("ID không tồn tại");
        }
        for (int i = 0; i < staffList1.size(); i++) {
            if (id==staffList1.get(i).getId()){
                staffList1.remove(i);
                findSalary();
            }
        }
        for (int i = 0; i < staffList2.size(); i++) {
            if (id==staffList2.get(i).getId()){
                staffList2.remove(i);
                findSalaryPart();
            }
        } new Menu1();


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
        boolean checkID = false;
        for (int i = 0; i < staffList.size(); i++) {
            if (id==staffList.get(i).getId()){
                System.out.println(staffList.get(i));
                checkID = true;
            }
        } if (checkID==false) {
            System.err.println("ID không tồn tại");
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
        boolean checkID = false;
        for (int i = 0; i < staffList.size(); i++) {
            if (id == staffList.get(i).getId()) {
                checkID = true;
                if (staffList.get(i).getStatus().equalsIgnoreCase("đang làm việc")) {
                    staffList.get(i).setStatus("Nghỉ việc");
                } else if (staffList.get(i).getStatus().equalsIgnoreCase("nghỉ việc")){
                    staffList.get(i).setStatus("Đang làm việc");
                }
                System.out.println("Thay đổi thành công!!!");
            }
        } if (checkID==false) {
            System.err.println("ID không tồn tại");
        }

    }

    @Override
    public void getWorkingType(String workingType) {
        for (int i = 0; i < staffList.size(); i++) {
            if (workingType.equalsIgnoreCase(staffList.get(i).getWorkingType())){
                System.out.println(staffList.get(i));
            }
        }
    }

    @Override
    public void saveSalaryFull(FullTimeStaff fullTimeStaff)  {
//        staffList1.clear();
//        staffList1.set(0,fullTimeStaff);
        staffList1.add(fullTimeStaff);
        new ConfigReadAndWriteFile<FullTimeStaff>().writeToFile(PATH1,staffList1);;
    }
    public void deleteSalary(){
        for (int i = 0; i < staffList1.size(); i++) {
            staffList1.clear();
        }
    }
    public void deleteSalaryPart(){
        for (int i = 0; i < staffList2.size(); i++) {
            staffList2.clear();
        }
    }

    @Override
    public List<FullTimeStaff> findSalary()  {
        new ConfigReadAndWriteFile<FullTimeStaff>().writeToFile(PATH1,staffList1);
        return staffList1;
    }

    @Override
    public void saveSalaryPart(PartTimeStaff partTimeStaff)  {
       staffList2.add(partTimeStaff);
       new ConfigReadAndWriteFile<PartTimeStaff>().writeToFile(PATH2,staffList2);
    }

    @Override
    public List<PartTimeStaff> findSalaryPart() {
       new ConfigReadAndWriteFile<PartTimeStaff>().writeToFile(PATH2,staffList2);
       return staffList2;
    }

    @Override
    public void setUpSalaryFull(int id, int bonus, int fine, int hardSalary) {
        for (int i = 0; i < staffList1.size(); i++) {
            if (id == staffList1.get(i).getId()){
                staffList1.get(i).setBonus(bonus);
                staffList1.get(i).setFine(fine);
                staffList1.get(i).setHardSalary(hardSalary);
                findSalary();
            }
        }
    }

}
