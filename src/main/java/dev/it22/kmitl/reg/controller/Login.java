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
        PasswordHash passwordHash = new PasswordHash(this.password);
        ResultSet rs = null;
        try {
            ResultSet userCheck = db.getQuery("SELECT * FROM user WHERE username = '" + this.username + "';");
            while (userCheck.next()) {
                System.out.println("Username: " + userCheck.getString("username"));
            }

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Login login = new Login("admin", "admin");
        login.loginWithUsernameAndPassword();
    }
}
