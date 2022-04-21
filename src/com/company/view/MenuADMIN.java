package com.company.view;

import java.util.Scanner;

public class MenuADMIN {
    public MenuADMIN()  {
        Scanner scanner = new Scanner(System.in);
        StaffView staffView = new StaffView();
        System.out.println("=====================STAFF MANAGER====================");
        System.out.println("1.Quản lý nhân viên");
        System.out.println("2.Quản lý người dùng");
        System.out.println("Chọn thao tác: ");
        int choose = scanner.nextInt();
        switch (choose) {
            case 1:
                System.out.println("1.Thêm nhân viên");
                System.out.println("2.Hiển thị danh sách nhân viên");
                System.out.println("3.Xóa nhân viên khỏi danh sách");
                System.out.println("4.Trạng thái làm việc");
                System.out.println("5.Chỉnh sửa thông tin nhân viên");
                System.out.println("6.Tìm kiếm nhân viên");
                System.out.println("7.Phân loại nhân viên");
                System.out.println("8.Tính lương");
                System.out.println("Chọn thao tác");
                int chooseMenu1 = scanner.nextInt();
                switch (chooseMenu1) {
                    case 1:
                        staffView.formCreateStaff();
                        break;
                    case 2:
                        staffView.showListStaff();
                        break;
                    case 3:
                        staffView.deleteStaff();
                        break;
                    case 4:
                        System.out.println("1.Kiểm tra" + "\n" +
                                "2.Thay đổi");
                        String choose2 = scanner.next();
                        switch (choose2) {
                            case "1":
                                staffView.checkStatusByName();
                                break;
                            case "2": //sao lại k ra nhỉ?
                                staffView.editStatus();
                                break;
                        }
                        break;
                    case 5:
                        staffView.editStaff();
                        break;
                    case 6:
                        System.out.println("1.Tìm kiếm theo Id" + "\n" +
                                "2.Tìm kiếm theo tên");
                        String choose1 = scanner.next();
                        switch (choose1) {
                            case "1":
                                staffView.findById();
                                break;
                            case "2": //sao lại k ra nhỉ?
                                staffView.findByName();
                                break;
                        }
                        break;
                    case 7:
                        staffView.phanLoai();
                        break;
                    case 8:
                        System.out.println("1.Tính lương nhân viên Fulltime");
                        System.out.println("2.Tính lương nhân viên Parttime");
                        System.out.println("3.Hiển thị lương nhân viên FullTime");
                        System.out.println("4.Hiển thị lương nhân viên PartTime");

                        int choose3 = scanner.nextInt();
                        switch (choose3){
                            case 1:
                                staffView.salaryFull();
                                break;
                            case 2:
                                staffView.salaryPart();
                                break;
                            case 3:
                                System.out.println("========================FullTime=======================");
                                staffView.showListSalaryFull();
                                break;
                            case 4:
                                System.out.println("===========================PartTime======================");
                                staffView.showListSalaryPart();
                                break;
                        }
                }
            case 2:
                System.out.println("1.Hiện thị tài khoản đăng nhập");
                System.out.println("2.Xóa người dùng");
                System.out.println("3.Hiển thị danh sách người dùng");
                System.out.println("4.Tìm kiếm");
                System.out.println("5.Đăng xuất");

                int chooseMenu2 = scanner.nextInt();
                switch (chooseMenu2) {
                    case 1:
                        new UserView().showListUserLogin();
                        break;
                    case 2:
                        new UserView().deleteUser();
                        break;
                    case 3:
                        new UserView().showListUser();
                        break;
                    case 4:
                        new UserView().findUserById();
                        break;
                    case 5:
                        new Main();
                        break;

                }

        }


//    public static void main(String[] args) throws Exception {
//        new Menu();
//    }
    }
}
