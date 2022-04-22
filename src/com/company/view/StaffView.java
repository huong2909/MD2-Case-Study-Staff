package com.company.view;

import com.company.controller.StaffController;
import com.company.model.*;
import com.company.service.Staff.StaffServiceIMPL;
import com.company.service.user.UserServiceIMPL;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StaffView {
    Scanner scanner = new Scanner(System.in);
    List<Staff> staffList = StaffServiceIMPL.staffList;
    StaffController staffController = new StaffController();
    List<User> userListLogin = UserServiceIMPL.userListLogin;
    StaffServiceIMPL staffServiceIMPL = new StaffServiceIMPL();
    public void showListStaff() {
        System.out.println(staffController.showListStaff());
        System.out.println("Nhập quit để quay lại Menu");
        String backMenu = scanner.nextLine();
        if (backMenu.equalsIgnoreCase("quit")) {
            for (int i = 0; i < userListLogin.size(); i++) {
                if (Role.RoleName.ADMIN.equals(userListLogin.get(i).getRoleName())) {
                    new MenuADMIN();
                } else {
                    new MenuUSER();
                }
            }
        }
    }

    public void formCreateStaff() {
        while (true) {
            int id;
            if (staffList.size() == 0) {
                id = 1;
            } else {
                id = staffList.get(staffList.size() - 1).getId() + 1;
            }
            System.out.println("Nhập tên nhân viên ");
            String name = scanner.nextLine();
            System.out.println("Tuổi nhân viên ");
            int age = Integer.parseInt(scanner.nextLine());
            System.out.println("Nhập quê quán ");
            String country = scanner.nextLine();
            System.out.println("Chọn trạng thái làm việc ");
            System.out.println("1.Đang làm việc" + "\n" +
                    "2.Nghỉ việc");
            String status = scanner.nextLine();
            switch (status) {
                case "1":
                    status = "Đang làm việc";
                    break;
                case "2":
                    status = "Nghỉ việc";
                    break;
            }
            System.out.println("Nhập hình thức làm việc");
            System.out.println("1.Parttime" + "\n" +
                    "2.Fulltime");
            String workingType = scanner.nextLine();
            switch (workingType) {
                case "1":
                    workingType = "Parttime";
                    break;
                case "2":
                    workingType = "Fulltime";
                    break;
            }
            Staff staff = new Staff(id, name, age, country, status, workingType);
            staffController.createStaff(staff);

            System.out.println("Nhập phím bất kỳ để tiếp tục hoặc nhập quit để quay lại Menu");
            String backMenu = scanner.nextLine();
            if (backMenu.equalsIgnoreCase("quit")) {
                for (int i = 0; i < userListLogin.size(); i++) {
                    if (Role.RoleName.ADMIN.equals(userListLogin.get(i).getRoleName())) {
                        new MenuADMIN();
                    } else {
                        new MenuUSER();
                    }
                }
            }
        }
    }

    public void deleteStaff() {
        System.out.println("Nhập ID của nhân viên cần xóa");
        int id = Integer.parseInt(scanner.nextLine());
        staffController.deleteStaff(id);
        System.out.println("nhập quit để quay lại Menu");
        String backMenu = scanner.nextLine();
        if (backMenu.equalsIgnoreCase("quit")) {
            for (int i = 0; i < userListLogin.size(); i++) {
                if (Role.RoleName.ADMIN.equals(userListLogin.get(i).getRoleName())) {
                    new MenuADMIN();
                } else {
                    new MenuUSER();
                }
            }
        }
    }

    public void checkStatusByName() {
        System.out.println("Nhập tên nhân viên cần kiểm tra");
        String name = scanner.nextLine();
        staffController.checkStatusByName(name);
        new MenuADMIN();
    }

    public void editStaff() {
        System.out.println("Nhập Id của nhân viên:");
        int id = Integer.parseInt(scanner.nextLine());
        boolean check = false;
        for (int i = 0; i < staffList.size(); i++) {
            if (id == staffList.get(i).getId()) {
                check = true;
            }
        }
        if (check == false) {
            System.err.println("ID không tồn tại");
            System.out.println("Nhập quit để quay lại Menu");
            String backMenu = scanner.nextLine();
            if (backMenu.equalsIgnoreCase("quit")) {
                for (int i = 0; i < userListLogin.size(); i++) {
                    if (Role.RoleName.ADMIN.equals(userListLogin.get(i).getRoleName())) {
                        new MenuADMIN();
                    } else {
                        new MenuUSER();
                    }
                }
            }
        }


        System.out.println("Nhập tên mới, nhập skip nếu không muốn thay đổi");
        String name = scanner.nextLine();
        for (int i = 0; i < staffList.size(); i++) {
            if (id == staffList.get(i).getId()) {
                if (name.equalsIgnoreCase("skip")) {
                    name = staffList.get(i).getName();
                }
            }
        }
        System.out.println("Nhập tuổi mới, nhập skip nếu không muốn thay đổi");

        int age = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < staffList.size(); i++) {
            if (id == staffList.get(i).getId()) {
                if (String.valueOf(age).equalsIgnoreCase("skip")) {
                    age = staffList.get(i).getAge();
                }
            }
        }
        System.out.println("Nhập quê quán mới, nhập skip nếu không muốn thay đổi");
        String country = scanner.nextLine();
        for (int i = 0; i < staffList.size(); i++) {
            if (id == staffList.get(i).getId()) {
                if (country.equalsIgnoreCase("skip")) {
                    country = staffList.get(i).getCountry();
                }
            }
        }


        System.out.println("Nhập trạng thái làm việc mới, nhập skip nếu không muốn thay đổi" + "\n" +
                "1.Đang làm việc" + "\n" +
                "2.Nghỉ việc");
        String status = scanner.nextLine();

        switch (status) {
            case "1":
                status = "Đang làm việc";
                break;
            case "2":
                status = "Nghỉ việc";
                break;
        }
        for (int i = 0; i < staffList.size(); i++) {
            if (id == staffList.get(i).getId()) {
                if (status.equalsIgnoreCase("skip")) {
                    status = staffList.get(i).getStatus();
                }
            }
        }
        System.out.println("Nhập hình thức làm việc mới,nhập skip nếu không muốn thay đổi");
        String workingType = scanner.nextLine();
        for (int i = 0; i < staffList.size(); i++) {
            if (id == staffList.get(i).getId()) {
                if (workingType.equalsIgnoreCase("skip")) {
                    workingType = staffList.get(i).getWorkingType();
                }
            }
        }

        staffController.editStaffById(id, name, age, country, status, workingType);
        System.out.println("Nhập quit để quay lại Menu");
        String backMenu = scanner.nextLine();
        if (backMenu.equalsIgnoreCase("quit")) {
            for (int i = 0; i < userListLogin.size(); i++) {
                if (Role.RoleName.ADMIN.equals(userListLogin.get(i).getRoleName())) {
                    new MenuADMIN();
                } else {
                    new MenuUSER();
                }
            }
        }
    }

    public void findById() {
        System.out.println("Nhập ID");
        int id = Integer.parseInt(scanner.nextLine());
        staffController.findById(id);
        System.out.println("Nhập quit để quay lại Menu");
        String backMenu = scanner.nextLine();
        if (backMenu.equalsIgnoreCase("quit")) {
            for (int i = 0; i < userListLogin.size(); i++) {
                if (Role.RoleName.ADMIN.equals(userListLogin.get(i).getRoleName())) {
                    new MenuADMIN();
                } else {
                    new MenuUSER();
                }
            }
        }

    }

    public void findByName() {
        System.out.println("Nhập tên");
        String name = scanner.nextLine();
        staffController.findByName(name);
        System.out.println();
        System.out.println("Nhập quit để quay lại Menu");
        String backMenu = scanner.nextLine();
        if (backMenu.equalsIgnoreCase("quit")) {
            for (int i = 0; i < userListLogin.size(); i++) {
                if (Role.RoleName.ADMIN.equals(userListLogin.get(i).getRoleName())) {
                    new MenuADMIN();
                } else {
                    new MenuUSER();
                }
            }
        }
    }

    public void editStatus() {
        System.out.println("Nhập id: ");
        int id = Integer.parseInt(scanner.nextLine());
        staffController.editStatus(id);
        System.out.println("Thay đổi thành công!!!");
        System.out.println("Nhập quit để quay lại Menu");
        String backMenu = scanner.nextLine();
        if (backMenu.equalsIgnoreCase("quit")) {
            for (int i = 0; i < userListLogin.size(); i++) {
                if (Role.RoleName.ADMIN.equals(userListLogin.get(i).getRoleName())) {
                    new MenuADMIN();
                } else {
                    new MenuUSER();
                }
            }
        }
    }

    public void phanLoai() {
        System.out.println("1.Fulltime" + "\n" +
                "2.Parttime");
        String choose2 = scanner.nextLine();
        switch (choose2) {
            case "1":
                choose2 = "Fulltime";
                staffController.phanLoai(choose2);
                break;
            case "2":
                choose2 = "Parttime";
                staffController.phanLoai(choose2);
                break;
        }
        System.out.println("Nhập quit để quay lại Menu");
        String backMenu = scanner.nextLine();
        if (backMenu.equalsIgnoreCase("quit")) {
            for (int i = 0; i < userListLogin.size(); i++) {
                if (Role.RoleName.ADMIN.equals(userListLogin.get(i).getRoleName())) {
                    new MenuADMIN();
                } else {
                    new MenuUSER();
                }
            }
        }


    }

    public void salaryFull() {
        for (int i = 0; i < staffList.size(); i++) {
            if (staffList.get(i).getWorkingType().equalsIgnoreCase("FullTime") && staffList.get(i).getStatus().equalsIgnoreCase("đang làm việc")) {
                System.out.println("Nhập tiền thưởng của nhân viên " + staffList.get(i).getName());
                int bonus = scanner.nextInt();
                System.out.println("Nhập tiền phạt của nhân viên " + staffList.get(i).getName());
                int fine = scanner.nextInt();
                FullTimeStaff fullTimeStaff = new FullTimeStaff(staffList.get(i).getId(), staffList.get(i).getName(), staffList.get(i).getAge(), staffList.get(i).getCountry(), staffList.get(i).getStatus(), staffList.get(i).getWorkingType(), bonus, fine, 10000);

                staffController.createSalaryFull(fullTimeStaff);
                System.out.println(staffController.showListSalaryFull());
            }
        }
        new MenuADMIN();
    }

    public void showListSalaryFull() {
        System.out.println(staffController.showListSalaryFull());
        System.out.println("Nhập quit để quay lại");
        String backMenu = scanner.nextLine();
        if (backMenu.equalsIgnoreCase("quit")) {
            for (int i = 0; i < userListLogin.size(); i++) {
                if (Role.RoleName.ADMIN.equals(userListLogin.get(i).getRoleName())) {
                    new MenuADMIN();
                } else {
                    new MenuUSER();
                }
            }
        }

    }

    public void salaryPart() {
        for (int i = 0; i < staffList.size(); i++) {
            if (staffList.get(i).getWorkingType().equalsIgnoreCase("PartTime") && staffList.get(i).getStatus().equalsIgnoreCase("đang làm việc")) {
                System.out.println("Nhập số giờ làm việc của nhân viên " + staffList.get(i).getName());
                int houseWork = scanner.nextInt();
                PartTimeStaff partTimeStaff = new PartTimeStaff(staffList.get(i).getId(), staffList.get(i).getName(), staffList.get(i).getAge(), staffList.get(i).getCountry(), staffList.get(i).getStatus(), staffList.get(i).getWorkingType(), houseWork);
                staffController.createSalaryPart(partTimeStaff);
            }
        }
        System.out.println(staffController.showListSalaryPart());
        new MenuADMIN();
    }

    public void showListSalaryPart() {
        System.out.println(staffController.showListSalaryPart());
        System.out.println("Nhập quit để quay lại");
        String backMenu = scanner.nextLine();
        if (backMenu.equalsIgnoreCase("quit")) {
            for (int i = 0; i < userListLogin.size(); i++) {
                if (Role.RoleName.ADMIN.equals(userListLogin.get(i).getRoleName())) {
                    new MenuADMIN();
                } else {
                    new MenuUSER();
                }
            }
        }

    }
    public void setupSalary(){
    }
}

