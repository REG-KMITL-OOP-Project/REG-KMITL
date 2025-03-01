package dev.it22.kmitl.reg.controller.auth;

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

            if (!userCheck.next()) {
                throw new Exception("??ERROR : Username not found");
            }

            // ตรวจสอบรหัสผ่าน
            String hashedPassword = userCheck.getString("password");
            if (!new PasswordHash(this.password).checkPassword(hashedPassword)) {
                throw new Exception("??ERROR : Password not match");
            }

            // สร้าง User object
            User user = new User(userCheck);
            System.out.println("Login success");
        }
        catch (Exception e) {
            System.out.println("😳 Error Login : "+e.getMessage());
        }
    }

    public static void main(String[] args) {
        Login login = new Login("test", "test");
        login.loginWithUsernameAndPassword();
    }
}
