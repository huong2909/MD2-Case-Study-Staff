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
        int chooseMenu = scanner.nextInt();
        switch (chooseMenu) {
            case 1:
                userView.register();
                break;
            case 2:
                userView.login();
               break;

        }
    }

    public static void main(String[] args){
        new Main();
    }
}
