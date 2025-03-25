package dev.it22.kmitl.reg.controller.request;

import dev.it22.kmitl.reg.utils.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class UserRequestController {
    public boolean createRequest() {
        Database db = new Database();
        try {
            int res = db.postQuery("INSERT INTO user_request (email, field_name, old_value, new_value, status) VALUES ('?','?','?','?','?');");
            System.out.println("Create request success : " + res);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public Vector<Vector<String>> getPendingRequests() {
        Vector<Vector<String>> data = new Vector<>();
        Database db = new Database();
        try {
            ResultSet rs = db.getQuery("SELECT id, email, field_name, old_value, new_value, status, created_at FROM user_request WHERE status = 'pending'");
            while (rs.next()) {
                Vector<String> row = new Vector<>();
                row.add(String.valueOf(rs.getInt("id")));
                row.add(rs.getString("email"));
                row.add(rs.getString("field_name"));
                row.add(rs.getString("old_value"));
                row.add(rs.getString("new_value"));
                row.add(rs.getString("status"));
                row.add(rs.getTimestamp("created_at").toString());
                data.add(row);
            }
            rs.close();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    public boolean approveRequest(int id, String email, String fieldName, String newValue) {
        Database db = new Database();
        try {
            int res = db.postQuery("UPDATE user_request SET status = 'approved' WHERE id = " + id + ";");
            System.out.println("Approve request success : " + res);
            int res2 = db.postQuery("UPDATE user SET " + fieldName + " = '" + newValue + "' WHERE email = '" + email + "';");
            System.out.println("Update user success : " + res2);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean rejectRequest(int id) {
        Database db = new Database();
        try {
            int res = db.postQuery("UPDATE user_request SET status = 'rejected' WHERE id = " + id + ";");
            System.out.println("Reject request success : " + res);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}


