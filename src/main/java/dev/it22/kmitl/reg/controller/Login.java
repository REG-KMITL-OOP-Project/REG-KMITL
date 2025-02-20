package dev.it22.kmitl.reg.controller;

import dev.it22.kmitl.reg.utils.Database;
import dev.it22.kmitl.reg.utils.PasswordHash;

import java.sql.ResultSet;

public class Login {
    private String username;
    private String password;

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void loginWithUsernameAndPassword() {
        Database db = new Database();
        ResultSet rs = null;
        try {
            ResultSet userCheck = db.getQuery("SELECT * FROM user WHERE username = '" + this.username + "';");
            if (userCheck == null) {
                throw new Exception("??ERROR : Username not found");
            }
            while (userCheck.next()) {
                String hashedPassword = userCheck.getString("password");
                if (new PasswordHash(this.password).checkPassword(hashedPassword)) {
                    System.out.println("Login success");
                } else {
                    throw new Exception("??ERROR : Password not match");
                }
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Login login = new Login("test1234567", "test");
        login.loginWithUsernameAndPassword();
    }
}
