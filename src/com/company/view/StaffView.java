package com.company.view;

import com.company.controller.StaffController;
import com.company.model.*;
import com.company.service.Staff.StaffServiceIMPL;
import com.company.service.user.UserServiceIMPL;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class StaffView {
    Scanner scanner = new Scanner(System.in);
    List<Staff> staffList = StaffServiceIMPL.staffList;
    List<FullTimeStaff> staffList1 = StaffServiceIMPL.staffList1;
    StaffController staffController = new StaffController();
    List<User> userListLogin = UserServiceIMPL.userListLogin;
    StaffServiceIMPL staffServiceIMPL = new StaffServiceIMPL();
    public void showListStaff() {
        System.out.println(staffController.showListStaff());
        new Menu1();

    }

    public void formCreateStaff() {
        while (true) {
            int id;
            if (staffList.size() == 0) {
                id = 1;
            } else {
                id = staffList.get(staffList.size() - 1).getId() + 1;
            }

            //Tên
            System.out.println("Nhập họ và tên nhân viên");
            String name;
            boolean checkName;
            while (true) {
                name = scanner.nextLine();
                checkName = Pattern.matches("(.|\\s)*\\S(.|\\s)*", name);
                if (!checkName) {
                    System.err.println("Không được để trống!! Vui lòng nhập lại");
                } else {
                    break;
                }
            }
            //Tuổi
            System.out.println("Nhập tuổi nhân viên ");
            String temp;
            boolean checkTemp;
            while (true) {
                temp = scanner.nextLine();
                checkTemp = Pattern.matches("[0-9_-]{2}", temp);
                if (!checkTemp) {
                    System.err.println("Nhập sai!! Vui lòng nhập lại");
                } else {
                    break;
                }
            }
            int age = Integer.parseInt(temp);

            //quê
            System.out.println("Nhập quê quán ");
            String country;
            boolean checkCountry;
            while (true) {
                country = scanner.nextLine();
                checkCountry = Pattern.matches("(.|\\s)*\\S(.|\\s)*", country);
                if (!checkCountry) {
                    System.err.println("Không được để trống!! Vui lòng nhập lại");
                } else {
                    break;
                }
            }
            //hinh thức

            String status = "Đang làm việc";
            System.out.println("Nhập hình thức làm việc");
            System.out.println("1. Parttime" + "\n" +
                    "2. Fulltime");
            String workingType;
            boolean checkWorkingType;
            while (true) {
                workingType = scanner.nextLine();
                switch (workingType) {
                    case "1":
                        workingType = "Parttime";
                        break;
                    case "2":
                        workingType = "Fulltime";
                        break;
                }
                checkWorkingType = Pattern.matches("Parttime|Fulltime", workingType);
                if (!checkWorkingType) {
                    System.err.println("Nhập sai!! Vui lòng nhập lại");
                } else {
                    break;
                }
            }
            Staff staff = new Staff(id, name, age, country, status, workingType);
            staffController.createStaff(staff);
            System.out.println("Thêm nhân viên thành công!!!");
            new Menu1();
        }
    }


    public void deleteStaff() {
        System.out.println("Nhập ID của nhân viên cần xóa");
        int id = Integer.parseInt(scanner.nextLine());
        staffController.deleteStaff(id);
        staffController.showListStaff();
        new Menu1();
    }

    public void checkStatusByName() {
        System.out.println("Nhập tên nhân viên cần kiểm tra");
        String name = scanner.nextLine();
        staffController.checkStatusByName(name);
        new Menu1();
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
            new Menu1();
        }


        System.out.println("Nhập tên mới, nhập skip nếu không muốn thay đổi");
        String name;
        boolean checkName;
        while (true) {
            name = scanner.nextLine();
            checkName = Pattern.matches("(.|\\s)*\\S(.|\\s)*", name);
            if (!checkName) {
                System.err.println("Không được để trống!! Vui lòng nhập lại");
            } else {
                break;
            }
        }
        for (int i = 0; i < staffList.size(); i++) {
            if (id == staffList.get(i).getId()) {
                if (name.equalsIgnoreCase("skip")) {
                    name = staffList.get(i).getName();
                }
            }
        }


        System.out.println("Nhập tuổi mới, nhập số 0 nếu không muốn thay đổi");
        int age = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < staffList.size(); i++) {
            if (id == staffList.get(i).getId()) {
                if (age==0) {
                    age = staffList.get(i).getAge();
                }
            }
        }

        System.out.println("Nhập quê quán mới, nhập skip nếu không muốn thay đổi");
        String country;
        boolean checkCountry;
        while (true) {
            country = scanner.nextLine();
            checkCountry = Pattern.matches("(.|\\s)*\\S(.|\\s)*", country);
            if (!checkCountry) {
                System.err.println("Không được để trống!! Vui lòng nhập lại");
            } else {
                break;
            }
        }
        for (int i = 0; i < staffList.size(); i++) {
            if (id == staffList.get(i).getId()) {
                if (country.equalsIgnoreCase("skip")) {
                    country = staffList.get(i).getCountry();
                }
            }
        }


        System.out.println("Nhập trạng thái làm việc: " + "\n" +
                "1.Đang làm việc" + "\n" +
                "2.Nghỉ việc");
        String status;
        boolean checkStatus;
        while (true) {
            status = scanner.nextLine();
            switch (status) {
                case "1":
                    status = "Đang làm việc";
                    break;
                case "2":
                    status = "Nghỉ việc";
                    break;
            }
            checkStatus = Pattern.matches("Đang làm việc|Nghỉ việc", status);
            if (!checkStatus) {
                System.err.println("Nhập sai!! Vui lòng nhập lại");
            } else {
                break;
            }
        }
        
        System.out.println("Nhập hình thức làm việc:");
        System.out.println("1. Parttime" + "\n" +
                "2. Fulltime");
        String workingType;
        boolean checkWorkingType;
        while (true) {
            workingType = scanner.nextLine();
            switch (workingType) {
                case "1":
                    workingType = "Parttime";
                    break;
                case "2":
                    workingType = "Fulltime";
                    break;
            }
            checkWorkingType = Pattern.matches("Parttime|Fulltime", workingType);
            if (!checkWorkingType) {
                System.err.println("Nhập sai!! Vui lòng nhập lại");
            } else {
                break;
            }
        }

        staffController.editStaffById(id, name, age, country, status, workingType);
        System.out.println("Thay đổi thành công!!!");
        new Menu1();
    }

    public void findById() {
        System.out.println("Nhập ID");
        int id = Integer.parseInt(scanner.nextLine());
        staffController.findById(id);
        new Menu1();

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
                    new Menu1();
                } else {
                    new Menu2();
                }
            }
        }
    }

    public void editStatus() {
        System.out.println("Nhập id: ");
        int id = Integer.parseInt(scanner.nextLine());
        staffController.editStatus(id);
        new Menu1();
    }

    public void getWorkingType() {
        System.out.println("1.Fulltime" + "\n" +
                "2.Parttime");
        String choose2 = scanner.nextLine();
        switch (choose2) {
            case "1":
                choose2 = "Fulltime";
                staffController.getWorkingType(choose2);
                break;
            case "2":
                choose2 = "Parttime";
                staffController.getWorkingType(choose2);
                break;
        }
        new Menu1();


    }

    public void salaryFull() {
        staffController.deleteSalary();
        for (int i = 0; i < staffList.size(); i++) {
            if (staffList.get(i).getWorkingType().equalsIgnoreCase("FullTime") && staffList.get(i).getStatus().equalsIgnoreCase("đang làm việc")) {
                System.out.println("Nhập số ngày nghỉ của nhân viên " + staffList.get(i).getName()+"(không quá 20 ngày)");
                String temp;
                boolean checkTemp;
                while (true) {
                    temp = scanner.nextLine();
                    checkTemp = Pattern.matches("[0-2_-]{1,2}", temp);
                    if (!checkTemp) {
                        System.err.println("Nhập sai!! Vui lòng nhập lại");
                    } else {
                        break;
                    }
                }
                int fine = Integer.parseInt(temp);
                FullTimeStaff fullTimeStaff = new FullTimeStaff(staffList.get(i).getId(), staffList.get(i).getName(), staffList.get(i).getAge(), staffList.get(i).getCountry(), staffList.get(i).getStatus(), staffList.get(i).getWorkingType(), 1000, fine, 10000);

                staffController.createSalaryFull(fullTimeStaff);
                System.out.println(staffController.showListSalaryFull());
            }
        }
        new Menu1();
    }
    public void creatSalaryFull() {
        System.out.println("Nhập Id");
        int id = Integer.parseInt(scanner.nextLine());
        boolean checkID = false;
        for (int i = 0; i < staffList.size(); i++) {
            if (id == staffList.get(i).getId()) {
                checkID = true;
                if (staffList.get(i).getWorkingType().equalsIgnoreCase("FullTime") && staffList.get(i).getStatus().equalsIgnoreCase("đang làm việc")) {
                    System.out.println("Nhập số ngày nghỉ của nhân viên " + staffList.get(i).getName()+"(không quá 20 ngày)");
                    String temp1;
                    boolean checkTemp1;
                    while (true) {
                        temp1 = scanner.nextLine();
                        checkTemp1 = Pattern.matches("[0-2_-]{1,2}", temp1);
                        if (!checkTemp1) {
                            System.err.println("Nhập sai!! Vui lòng nhập lại");
                        } else {
                            break;
                        }
                    }
                    int fine = Integer.parseInt(temp1);
                    FullTimeStaff fullTimeStaff = new FullTimeStaff(staffList.get(i).getId(), staffList.get(i).getName(), staffList.get(i).getAge(), staffList.get(i).getCountry(), staffList.get(i).getStatus(), staffList.get(i).getWorkingType(), 1000, fine, 10000);

                    staffController.createSalaryFull(fullTimeStaff);
                    System.out.println(staffController.showListSalaryFull());
                }
            }
        } if (checkID == false){
            System.err.println("ID không tồn tại");
        }
        new Menu1();
    }


    public void showListSalaryFull() {
        System.out.println(staffController.showListSalaryFull());
        new Menu1();

    }

    public void salaryPart() {
        staffController.deleteSalaryPart();
        for (int i = 0; i < staffList.size(); i++) {
            if (staffList.get(i).getWorkingType().equalsIgnoreCase("PartTime") && staffList.get(i).getStatus().equalsIgnoreCase("đang làm việc")) {
                System.out.println("Nhập số giờ làm việc của nhân viên " + staffList.get(i).getName());
                int houseWork = scanner.nextInt();
                PartTimeStaff partTimeStaff = new PartTimeStaff(staffList.get(i).getId(), staffList.get(i).getName(), staffList.get(i).getAge(), staffList.get(i).getCountry(), staffList.get(i).getStatus(), staffList.get(i).getWorkingType(), houseWork);
                staffController.createSalaryPart(partTimeStaff);
            }
        }
        System.out.println(staffController.showListSalaryPart());
        new Menu1();
    }

    public void showListSalaryPart() {
        System.out.println(staffController.showListSalaryPart());
        new Menu1();

    }
    public void setupSalary(){
        System.out.println(staffController.showListSalaryFull());
        System.out.println("Nhập Id của nhân viên:");
        int id = Integer.parseInt(scanner.nextLine());
        boolean check = false;
        for (int i = 0; i < staffList1.size(); i++) {
            if (id == staffList1.get(i).getId()) {
                check = true;
            }
        }
        if (check == false) {
            System.err.println("ID không tồn tại");
            new Menu1();
        }
        //thưởng
        System.out.println("Nhập tiền thưởng(không quá 4 số)");
        String temp;
        boolean checkTemp;
        while (true) {
            temp = scanner.nextLine();
            checkTemp = Pattern.matches("[0-9_-]{0,4}", temp);
            if (!checkTemp) {
                System.err.println("Nhập sai!! Vui lòng nhập lại");
            } else {
                break;
            }
        }
        int bonus = Integer.parseInt(temp);
       //ngày nghỉ
        System.out.println("Nhập số ngày nghỉ (không quá 20 ngày)");
        String temp1;
        boolean checkTemp1;
        while (true) {
            temp1 = scanner.nextLine();
            checkTemp1 = Pattern.matches("[0-2_-]{1,2}", temp1);
            if (!checkTemp1) {
                System.err.println("Nhập sai!! Vui lòng nhập lại");
            } else {
                break;
            }
        }
        int fine = Integer.parseInt(temp1);

        //lương cứng
        System.out.println("Nhập lương cứng (không quá 5 số)");
        String temp2;
        boolean checkTemp2;
        while (true) {
            temp2 = scanner.nextLine();
            checkTemp2 = Pattern.matches("[0-9_-]{5}", temp2);
            if (!checkTemp2) {
                System.err.println("Nhập sai!! Vui lòng nhập lại");
            } else {
                break;
            }
        }
        int salary = Integer.parseInt(temp2);

        staffController.setUpSalaryFull(id,bonus,fine,salary);
        System.out.println("Chỉnh sửa thành công");
        System.out.println(staffController.showListSalaryFull());
        new Menu1();
    }

}

