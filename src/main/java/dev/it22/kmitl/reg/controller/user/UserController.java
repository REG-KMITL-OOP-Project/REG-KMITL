package dev.it22.kmitl.reg.controller.user;

import dev.it22.kmitl.reg.utils.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class UserController {
    public Vector<Vector<String>> getAllUser() {
        Vector<Vector<String>> data = new Vector<>();
        Database db = new Database();
        try {
            ResultSet rs = db.getQuery("SELECT id, role, std_id, prof_id, section_id, email, prefix, fname, lname, faculty, major, address, phone FROM user ORDER BY role");
            while (rs.next()) {
                Vector<String> row = new Vector<>();
                row.add(String.valueOf(rs.getInt("id")));
                switch (rs.getInt("role")) {
                    case 1 -> row.add("Admin");
                    case 2 -> row.add("Student");
                    case 3 -> row.add("Professor");
                    default -> row.add("Unknown");
                }
                row.add(rs.getString("std_id"));
                row.add(rs.getString("prof_id"));
                row.add(rs.getString("section_id"));
                row.add(rs.getString("email"));
                switch (rs.getInt("prefix")) {
                    case 1 -> row.add("นาย");
                    case 2 -> row.add("นาง");
                    case 3 -> row.add("นางสาว");
                    default -> row.add("Unknown");
                }
                row.add(rs.getString("fname"));
                row.add(rs.getString("lname"));
                row.add(rs.getString("faculty"));
                row.add(rs.getString("major"));
                row.add(rs.getString("address"));
                row.add(rs.getString("phone"));
                data.add(row);
            }
            rs.close();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return data;
    }
}
