package dev.it22.kmitl.reg.controller.request;

import dev.it22.kmitl.reg.model.request.UserRequestModel;
import dev.it22.kmitl.reg.utils.Database;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public List<UserRequestModel> getPendingRequest() {
        Database db = new Database();
        List<UserRequestModel> requests = new ArrayList<>();
        try {
            while (db.getQuery("SELECT * FROM user_request WHERE status = 'pending';").next()) {
                requests.add(new UserRequestModel(
                        db.getQuery("SELECT * FROM user_request WHERE status = 'pending';").getInt("id"),
                        db.getQuery("SELECT * FROM user_request WHERE status = 'pending';").getString("email"),
                        db.getQuery("SELECT * FROM user_request WHERE status = 'pending';").getString("field_name"),
                        db.getQuery("SELECT * FROM user_request WHERE status = 'pending';").getString("old_value"),
                        db.getQuery("SELECT * FROM user_request WHERE status = 'pending';").getString("new_value"),
                        db.getQuery("SELECT * FROM user_request WHERE status = 'pending';").getString("status"),
                        db.getQuery("SELECT * FROM user_request WHERE status = 'pending';").getTimestamp("created_at"),
                        db.getQuery("SELECT * FROM user_request WHERE status = 'pending';").getTimestamp("updated_at")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return requests;
    }

    public boolean qpproveRequest(int id, String email, String fieldName, String newValue) {
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
}
