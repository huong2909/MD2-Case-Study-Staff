package com.company.view;

import com.company.controller.UserController;
import com.company.model.Role;
import com.company.model.User;
import com.company.service.user.UserServiceIMPL;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class UserView {
    Scanner scanner = new Scanner(System.in);
    List<User> userList = UserServiceIMPL.userList;
    UserController userController = new UserController();


    public void showListUser() {
        System.out.println(userController.showListUser());
        new Menu1();
    }

    public void register() {
        while (true) {
            int id;
            if (userList.size() == 0) {
                id = 1;
            } else {
                id = userList.get(userList.size() - 1).getId() + 1;
            }

            System.out.println("Nhập họ tên: ");
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

            System.out.println("Nhập tên người dùng (tối thiểu 6 ký tự)");
            String username;
            boolean checkUsername;
            while (true) {
                username = scanner.nextLine();
                checkUsername = Pattern.matches("[a-z0-9_-]{6,}", username);
                if (!checkUsername) {
                    System.err.println("Sai rồi!vui lòng nhập lại!");
                } else if (UserServiceIMPL.existedByUsername(username)) {
                    System.err.println("Tên đã tồn tại!vui lòng nhập tên khác");
                } else {
                    break;
                }
            }
            System.out.println("Nhập mật khẩu (tối thiểu 8 ký tự)");
            String password;
            boolean checkPassword;
            while (true) {
                password = scanner.nextLine();
                checkPassword = Pattern.matches("[a-z0-9_-]{8,}", password);
                if (!checkPassword) {
                    System.err.println("Sai rồi!vui lòng nhập lại!");
                } else {
                    break;
                }
            }
            System.out.println("Nhập email");
            String email;
            boolean checkEmail;
            while (true) {
                email = scanner.nextLine();
                checkEmail = Pattern.matches("^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$", email);
                if (!checkEmail) {
                    System.err.println("Sai rồi!vui lòng nhập lại!");
                } else if (UserServiceIMPL.existedByEmail(email)) {
                    System.err.println("Email đã tồn tại!vui lòng nhập mail khác");
                } else {
                    break;
                }
            }
            System.out.println("Nhập quyền sử dụng ADMIN hoặc USER");
            String role;

            boolean checkRoleName;
            while (true) {
                role = scanner.nextLine();
                checkRoleName = Pattern.matches("ADMIN|USER", role);
                if (!checkRoleName) {
                    System.err.println("Nhập sai!! Vui lòng nhập lại");
                } else {
                    break;
                }
            }
            Role.RoleName roleName = Role.RoleName.valueOf(role);
            User user = new User(id, name, username, password, email, roleName);
            userController.createUser(user);

            System.out.println("Đăng kí thành công!!!");
            new Main();

        }
    }

    public boolean login() {
        String username;
        String userlogin = null;
        do {
            System.out.println("Nhập tên người dùng: ");
            username = scanner.nextLine();
            for (int i = 0; i < userList.size(); i++) {
                if (username.equals(userList.get(i).getUserName())) {
                    userlogin = userList.get(i).getName();
                }
            }
            if (userlogin == null) {
                System.err.println("Tên đăng nhập sai!");
            }
        } while (userlogin == null);

        String password;
        String passwordlogin = null;
        do {
            System.out.println("Nhập mật khẩu: ");
            password = scanner.nextLine();
            for (int i = 0; i < userList.size(); i++) {
                if (password.equals(userList.get(i).getPassword())) {
                    passwordlogin = userList.get(i).getPassword();
                }
            }
            if (passwordlogin == null) System.err.println("Mật khẩu đăng nhập sai!");

        } while (passwordlogin == null);

        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getUserName().equals(username) && userList.get(i).getPassword().equals(password) && userList.get(i).getRoleName().equals(Role.RoleName.ADMIN)) {
                System.out.println("Chúc mừng " + userList.get(i).getRoleName() + " - " + userList.get(i).getName() + " đã đăng nhập thành công!!!");

                User user = new User(userList.get(i).getId(), userList.get(i).getName(), userList.get(i).getUserName(), userList.get(i).getPassword(), userList.get(i).getEmail(), userList.get(i).getRoleName());
                userController.createUserLogin(user);
                new Menu1();
            } else if (userList.get(i).getUserName().equals(username) && userList.get(i).getPassword().equals(password) && userList.get(i).getRoleName().equals(Role.RoleName.USER)) {
                System.out.println(" Chúc mừng " + userList.get(i).getRoleName() + " - " + userList.get(i).getName() + " đã đăng nhập thành công!!!");

                User user = new User(userList.get(i).getId(), userList.get(i).getName(), userList.get(i).getUserName(), userList.get(i).getPassword(), userList.get(i).getEmail(), userList.get(i).getRoleName());
                userController.createUserLogin(user);
                new Menu2();
            }
        }
        return false;


    }

    public void showListUserLogin() {
        System.out.println(userController.showListUserLogin());
        new Menu1();
    }

    public void deleteUser()  {
        System.out.println("Nhập ID");
        int id = Integer.parseInt(scanner.nextLine());
        userController.deleteUser(id);
        new Menu1();

    }
    public void findUserById() {
        System.out.println("Nhập ID");
        int id = scanner.nextInt();
        userController.findById(id);
        new Menu1();
        }
    }






