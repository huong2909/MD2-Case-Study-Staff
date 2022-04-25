package com.company.view;

import java.util.Scanner;

public class Menu1 {
    Scanner scanner = new Scanner(System.in);
    StaffView staffView = new StaffView();
    public Menu1()  {
        System.out.println("=======================MANAGER=====================");
        System.out.println("1.Quản lý nhân viên");
        System.out.println("2.Quản lý người dùng");
        System.out.println("Chọn thao tác: ");
        String choose = scanner.nextLine();
        switch (choose) {
            case "1":
                System.out.println("=====================STAFF MANAGER====================");
                System.out.println("1.Thêm nhân viên");
                System.out.println("2.Hiển thị danh sách nhân viên");
                System.out.println("3.Xóa nhân viên khỏi danh sách");
                System.out.println("4.Trạng thái làm việc");
                System.out.println("5.Chỉnh sửa thông tin nhân viên");
                System.out.println("6.Tìm kiếm nhân viên");
                System.out.println("7.Phân loại nhân viên");
                System.out.println("8.Tính lương");
                System.out.println("Chọn thao tác");
                String chooseMenu1 = scanner.nextLine();
                switch (chooseMenu1) {
                    case "1":
                        staffView.formCreateStaff();
                        break;
                    case "2":
                        staffView.showListStaff();
                        break;
                    case "3":
                        staffView.deleteStaff();
                        break;
                    case "4":
                        System.out.println("1.Kiểm tra" + "\n" +
                                "2.Thay đổi");
                        System.out.println("Chọn thao tác");
                        String choose2 = scanner.nextLine();
                        switch (choose2) {
                            case "1":
                                staffView.checkStatusByName();
                                break;
                            case "2":
                                staffView.editStatus();
                                break;
                            default:
                                System.err.println("Thao tác sai!! vui lòng nhập lại!!!");
                                new Menu1();
                        }
                        break;
                    case "5":
                        staffView.editStaff();
                        break;
                    case "6":
                        System.out.println("1.Tìm kiếm theo Id" + "\n" +
                                "2.Tìm kiếm theo tên");
                        System.out.println("Chọn thao tác");
                        String choose1 = scanner.nextLine();
                        switch (choose1) {
                            case "1":
                                staffView.findById();
                                break;
                            case "2":
                                staffView.findByName();
                                break;
                            default:
                                System.err.println("Thao tác sai!! vui lòng nhập lại!!!");
                                new Menu1();
                        }
                        break;
                    case "7":
                        staffView.getWorkingType();
                        break;
                    case "8":
                        System.out.println("1.FullTime");
                        System.out.println("2.Parttime");
                        System.out.println("Chọn thao tác");
                        String choose3 = scanner.nextLine();
                        switch (choose3){
                            case "1":
                                System.out.println("1.Tính toàn bộ lương");
                                System.out.println("2.Hiển thị bảng lương");
                                System.out.println("3.Tính lương của nhân viên mới");
                                System.out.println("4.Chỉnh sửa lương");
                                System.out.println("Chọn thao tác");
                                String choose4 = scanner.nextLine();
                                switch (choose4){
                                    case "1":
                                        staffView.salaryFull();
                                        break;
                                    case "2":
                                        System.out.println("========================FullTime=======================");
                                        staffView.showListSalaryFull();
                                        break;
                                    case "3":
                                        staffView.creatSalaryFull();
                                        break;
                                    case "4":
                                      staffView.setupSalary();
                                      break;
                                    default:
                                        System.err.println("Thao tác sai!! vui lòng nhập lại!!!");
                                        new Menu1();
                                }
                            case "2":
                                System.out.println("1.Tính toàn bộ lương");
                                System.out.println("2.Hiển thị bảng lương");
                                System.out.println("Chọn thao tác");
                                String choose5 = scanner.nextLine();
                                switch (choose5){
                                    case "1":
                                        staffView.salaryPart();
                                        break;
                                    case "2":
                                        System.out.println("========================PartTime=======================");
                                        staffView.showListSalaryPart();
                                        break;
                                    default:
                                        System.err.println("Thao tác sai!! vui lòng nhập lại!!!");
                                        new Menu1();
                                }
                            default:
                                System.err.println("Thao tác sai!! vui lòng nhập lại!!!");
                                new Menu1();
                        }
         }
            case "2":
                System.out.println("=====================USER MANAGER====================");
                System.out.println("1.Hiển thị tài khoản đăng nhập");
                System.out.println("2.Xóa người dùng");
                System.out.println("3.Hiển thị danh sách người dùng");
                System.out.println("4.Tìm kiếm");
                System.out.println("5.Đăng xuất");
                System.out.println("Chọn thao tác: ");
                String chooseMenu2 = scanner.nextLine();
                switch (chooseMenu2) {
                    case "1":
                        new UserView().showListUserLogin();
                        break;
                    case "2":
                        new UserView().deleteUser();
                        break;
                    case "3":
                        new UserView().showListUser();
                        break;
                    case "4":
                        new UserView().findUserById();
                        break;
                    case "5":
                        new Main();
                        break;
                    default:
                        System.err.println("Thao tác sai!! vui lòng nhập lại!!!");
                        new Menu1();

                } default:
                System.err.println("Thao tác sai!! vui lòng nhập lại!!!");
                new Menu1();

        }

    }
}
