package dev.it22.kmitl.reg.controller.auth;

import dev.it22.kmitl.reg.constant.UserPrefix;
import dev.it22.kmitl.reg.constant.UserRole;
import dev.it22.kmitl.reg.utils.Database;
import dev.it22.kmitl.reg.utils.PasswordHash;

import java.sql.ResultSet;

public class Register {
    private String username;
    private  String password;

    public Register(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void registerWithUsernameAndPassword() throws Exception {
        String passwordHash = new PasswordHash(this.password).hashPassword();
        System.out.println("Register with username: " + this.username );
        Database db = new Database();
        try {

            ResultSet isExist = db.getQuery("SELECT * FROM user WHERE username = '" + this.username + "';");
            if (isExist.next()) {
               throw new Exception("🔥ERROR : Username already exist");
            }

            int res = db.postQuery("INSERT INTO user (username, password) VALUES ('" + this.username + "', '" + passwordHash + "');");
            System.out.println("Register success : " + this.username + "status: " + res);
        }
        catch (Exception e) {
            System.out.println("😳 Error Create User : "+e.getMessage());
            throw new Exception("😳 Error Create User : "+e.getMessage());
        }
    }

    public static void main(String[] args) {
        Register register = new Register("Admin01", "Admin1234");
        try {
            register.registerWithUsernameAndPassword();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
