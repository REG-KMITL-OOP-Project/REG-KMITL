package dev.it22.kmitl.reg.controller.auth;

import dev.it22.kmitl.reg.constant.UserPrefix;
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

    public User(){
        if(userAccount == null){
            throw new NullPointerException("💦 User account is null. Please Login again.");
        }
    }

    public User(ResultSet account) throws Exception {
        int userRole = (int) account.getObject("role");
        System.out.println("Login with : " + account.getString("username"));
        String id = account.getString("id");
        String email = account.getString("email");
        String username = account.getString("username");
        String firstName = account.getString("fname");
        String lastName = account.getString("lname");
        int prefixValue = account.getInt("prefix");
        UserPrefix prefix;
        switch(prefixValue) {
            case 0: prefix = UserPrefix.NONE; break;
            case 1: prefix = UserPrefix.MR; break;
            case 2: prefix = UserPrefix.MRS; break;
            case 3: prefix = UserPrefix.MS; break;
            default: throw new IllegalArgumentException("Invalid prefix value: " + prefixValue);
        }
        String phone = account.getString("phone");
        String studentId = account.getString("std_id");
        String faculty = account.getString("faculty");
        String major = account.getString("major");
        String section = account.getString("section_id");
        String address = account.getString("address");
        String prof_id = account.getString("prof_id");

        if (userRole == UserRole.STUDENT.getLevel()) {
            userAccount = new Student(
                    id,
                    UserRole.STUDENT,
                    email,
                    username,
                    prefix,
                    firstName,
                    lastName,
                    address,
                    phone,
                    studentId,
                    faculty,
                    major,
                    section);
        } else if (userRole == UserRole.PROF.getLevel()) {
            userAccount = new Prof(
                    id,
                    prof_id,
                    UserRole.PROF,
                    email,
                    username,
                    prefix,
                    firstName,
                    lastName,
                    phone,
                    new ArrayList<>()
            );
        } else if (userRole == UserRole.ADMIN.getLevel()) {
            userAccount = new Admin(
                    id,
                    UserRole.ADMIN,
                    email,
                    username,
                    prefix,
                    firstName,
                    lastName
            );
        } else {
            throw new Exception("🔥ERROR : User role not found");
        }
    }

    public Account getUserAccount() {
        return userAccount;
    }

    public void logout() {
        this.userAccount = null;
    }

}
