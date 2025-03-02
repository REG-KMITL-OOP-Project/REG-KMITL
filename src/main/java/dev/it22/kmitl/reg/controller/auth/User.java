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

    public User(ResultSet account) throws Exception {
        int userRole = (int) account.getObject("role");
        System.out.println("Login with : " + account.getString("username"));
        String id = account.getString("id");
        String email = account.getString("email");
        String username = account.getString("username");
        String firstName = account.getString("first_name");
        String lastName = account.getString("last_name");
        UserPrefix prefix = UserPrefix.valueOf(String.valueOf(account.getInt("prefix")));
        String phone = account.getString("phone");
        String studentId = account.getString("student_id");
        String faculty = account.getString("faculty");
        String major = account.getString("major");
        String section = account.getString("section");

        if (userRole == UserRole.STUDENT.getLevel()) {
            userAccount = new Student(
                    id,
                    UserRole.STUDENT,
                    email,
                    username,
                    prefix,
                    firstName,
                    lastName,
                    phone,
                    studentId,
                    faculty,
                    major,
                    section);
        } else if (userRole == UserRole.PROF.getLevel()) {
            userAccount = new Prof(account);
        } else if (userRole == UserRole.ADMIN.getLevel()) {
            userAccount = new Admin(account);
        } else {
            throw new Exception("🔥ERROR : User role not found");
        }
    }


}
