package com.company.view;

import com.company.model.User;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public Main()  {
        Scanner scanner = new Scanner(System.in);
        UserView userView = new UserView();
        System.out.println("************************** MAIN ****************************");
        System.out.println("1.Đăng kí");
        System.out.println("2.Đăng nhập");
        System.out.println("Chọn thao tác:");
        String chooseMenu = scanner.nextLine();

        switch (chooseMenu) {
            case "1":
                userView.register();
                break;
            case "2":
                userView.login();
               break;
            default:
                System.err.println("Thao tác sai!! vui lòng nhập lại!!!");
                new Main();

        }
    }

    public static void main(String[] args){
        new Main();
    }
}
