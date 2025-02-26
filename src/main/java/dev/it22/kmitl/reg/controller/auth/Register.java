package dev.it22.kmitl.reg.controller.auth;

import dev.it22.kmitl.reg.constant.UserPrefix;
import dev.it22.kmitl.reg.constant.UserRole;
import dev.it22.kmitl.reg.utils.Database;
import dev.it22.kmitl.reg.utils.PasswordHash;

import java.sql.ResultSet;

public class Register {
    private UserRole role;
    private String email;
    private String username;
    private  String password;
    private UserPrefix prefix;
    private String fname;
    private String lname;
    private String phone;
    private String address;
    private String studentid;
    private String faculty;
    private String major;
    private String section;

    public Register(UserRole role, String email, String username, String password,
                    UserPrefix prefix, String fname, String lname, String phone,
                    String address, String studentid, String faculty, String major,
                    String section) {
        this.role = role;
        this.email = email;
        this.username = username;
        this.password = password;
        this.prefix = prefix;
        this.fname = fname;
        this.lname = lname;
        this.phone = phone;
        this.address = address;
        this.studentid = studentid;
        this.faculty = faculty;
        this.major = major;
        this.section = section;
    }

    public Register(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void registerWithUsernameAndPassword() {
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
        }
    }

    public static void main(String[] args) {
        Register register = new Register("test1234567", "test");
        register.registerWithUsernameAndPassword();
    }
}
