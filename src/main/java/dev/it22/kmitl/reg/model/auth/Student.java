package dev.it22.kmitl.reg.model.auth;

import dev.it22.kmitl.reg.constant.UserPrefix;
import dev.it22.kmitl.reg.constant.UserRole;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student extends Account {
    private String address;
    private String phone;
    private String studentId;
    private String faculty;
    private String major;
    private String section;
    private ArrayList<String> subjects;

    public Student(ResultSet userData) throws SQLException {
        String id = userData.getString("id");
        UserRole role = UserRole.STUDENT;
        String email = userData.getString("email");
        String username = userData.getString("username");
        UserPrefix prefix = UserPrefix.valueOf(userData.getString("prefix"));
        String firstName = userData.getString("first_name");
        String lastName = userData.getString("last_name");
        Date dateOfBirth = userData.getDate("date_of_birth");
        this.address = userData.getString("address");
        this.phone = userData.getString("phone");
        this.studentId = userData.getString("student_id");
        this.faculty = userData.getString("faculty");
        this.major = userData.getString("major");
        this.section = userData.getString("section");
        this.subjects = new ArrayList<>(List.of(userData.getString("subjects").split(",")));
        super(id, role, email, username, prefix, firstName, lastName, dateOfBirth);
        this.address = address;
        this.phone = phone;
        this.studentId = studentId;
        this.faculty = faculty;
        this.major = major;
        this.section = section;
        this.subjects = subjects;
    }
}