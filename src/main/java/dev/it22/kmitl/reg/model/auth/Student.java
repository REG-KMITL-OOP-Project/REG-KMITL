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

    public Student(String id,
                   UserRole role,
                   String email,
                   String username,
                   UserPrefix prefix,
                   String firstName,
                   String lastName,
                   String address,
                   String phone,
                   String studentId,
                   String faculty,
                   String major,
                   String section
    ) throws SQLException {

        super(id, role, email, username, prefix, firstName, lastName);
        this.address = address;
        this.phone = phone;
        this.studentId = studentId;
        this.faculty = faculty;
        this.major = major;
        this.section = section;
    }
}