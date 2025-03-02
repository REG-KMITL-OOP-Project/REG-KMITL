package dev.it22.kmitl.reg.controller.auth;

import dev.it22.kmitl.reg.constant.UserRole;
import dev.it22.kmitl.reg.model.auth.Account;
import dev.it22.kmitl.reg.model.auth.Admin;
import dev.it22.kmitl.reg.model.auth.Prof;
import dev.it22.kmitl.reg.model.auth.Student;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

public class User {

    private static Account userAccount;

    public User(ResultSet account) throws Exception {
        int userRole = (int) account.getObject("role");
        System.out.println("Login with : " + account.getString("username"));
        if (userRole == UserRole.STUDENT.getLevel()) {
            userAccount = new Student(account);
        } else if (userRole == UserRole.PROF.getLevel()) {
            userAccount = new Prof(account);
        } else if (userRole == UserRole.ADMIN.getLevel()) {
            userAccount = new Admin(account);
        } else {
            throw new Exception("🔥ERROR : User role not found");
        }
    }


}
