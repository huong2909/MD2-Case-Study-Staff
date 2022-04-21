package com.company.view;

import java.util.Scanner;

public class MenuUSER {
    MenuUSER() {
        Scanner scanner = new Scanner(System.in);
        StaffView staffView = new StaffView();
        System.out.println("======STAFF MANAGE======");

        System.out.println("1.Hiển thị danh sách nhân viên");
        System.out.println("2.Trạng thái làm việc");
        System.out.println("3.Tìm kiếm nhân viên");
        System.out.println("4.Phân loại nhân viên");
        System.out.println("5.Hiện thị tài khoản đăng nhập");
        System.out.println("6.Hiển thị bảng lương");
        System.out.println("7.Đăng xuất");

        int chooseMenu = scanner.nextInt();
        switch (chooseMenu) {
            case 1:
                staffView.showListStaff();
                break;
            case 2:
                System.out.println("1.Kiểm tra" + "\n" +
                        "2.Thay đổi");
                String choose = scanner.next();
                switch (choose) {
                    case "1":
                        staffView.checkStatusByName();
                        break;
                    case "2":
                        staffView.editStatus();
                        break;
                }
                break;
            case 3:
                System.out.println("1.Tìm kiếm theo Id" + "\n" +
                        "2.Tìm kiếm theo tên");
                String choose1 = scanner.next();
                switch (choose1) {
                    case "1":
                        staffView.findById();
                        break;
                    case "2":
                        staffView.findByName();
                        break;
                }
                break;
            case 4:
                staffView.phanLoai();
                break;
            case 5:
                new UserView().showListUserLogin();
                break;
            case 6:
                System.out.println("1.FullTime");
                System.out.println("2.PartTime");
                int choose4 = scanner.nextInt();
                switch (choose4){
                    case 1:
                        System.out.println("========================FullTime=======================");
                        staffView.showListSalaryFull();
                        break;
                    case 2:
                        System.out.println("===========================PartTime======================");
                        staffView.showListSalaryPart();
                        break;
                }

            case 7:
                new Main();
                break;


        }
    }
}

