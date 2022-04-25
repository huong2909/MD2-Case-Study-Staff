package com.company.view;

import java.util.Scanner;

public class Menu2 {
    Menu2() {
        Scanner scanner = new Scanner(System.in);
        StaffView staffView = new StaffView();
        System.out.println("================STAFF MANAGE================");

        System.out.println("1.Hiển thị danh sách nhân viên");
        System.out.println("2.Trạng thái làm việc");
        System.out.println("3.Tìm kiếm nhân viên");
        System.out.println("4.Phân loại nhân viên");
        System.out.println("5.Hiện thị tài khoản đăng nhập");
//        System.out.println("6.Hiển thị bảng lương");
        System.out.println("6.Đăng xuất");


        System.out.println("Chọn thao tác:");

        int chooseMenu = Integer.parseInt(scanner.nextLine());
        switch (chooseMenu) {
            case 1:
                staffView.showListStaff();
                break;
            case 2:
                System.out.println("1.Kiểm tra" + "\n" +
                        "2.Thay đổi");
                String choose = scanner.nextLine();
                switch (choose) {
                    case "1":
                        staffView.checkStatusByName();
                        break;
                    case "2":
                        staffView.editStatus();
                        break;
                    default:
                        System.err.println("Thao tác sai!! vui lòng nhập lại!!!");
                        new Menu2();
                }
                break;
            case 3:
                System.out.println("1.Tìm kiếm theo Id" + "\n" +
                        "2.Tìm kiếm theo tên");
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
                        new Menu2();
                }
                break;
            case 4:
                staffView.getWorkingType();
                break;
            case 5:
                new UserView().showListUserLogin();
                break;
//            case 6:
//                System.out.println("1.FullTime");
//                System.out.println("2.Parttime");
//                int choose2 = Integer.parseInt(scanner.nextLine());
//                switch (choose2){
//                    case 1:
//                        staffView.showListSalaryFull();
//                        break;
//                    case 2:
//                        staffView.showListSalaryPart();
//                        break;
//                    default:
//                        System.err.println("Thao tác sai!! vui lòng nhập lại!!!");
//                        new Menu2();
//                }

            case 6:
                new Main();
                break;


            default:
                System.err.println("Thao tác sai!! vui lòng nhập lại!!!");
                new Menu2();


        }
    }
}

