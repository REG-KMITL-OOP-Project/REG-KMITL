package dev.it22.kmitl.reg.ui.event;

import dev.it22.kmitl.reg.controller.auth.Login;
import dev.it22.kmitl.reg.controller.auth.User;
import dev.it22.kmitl.reg.model.auth.Account;
import dev.it22.kmitl.reg.utils.Database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class testData {
    //database
    private Account user;
    private Database db;
    ResultSet rs;

    public testData() throws SQLException {
        user = new User().getUserAccount();
        db = new Database();
        this.getRoom();
    }

    public void getRoom() throws SQLException {
                         //write your query here
        rs = db.getQuery("SELECT room, section FROM section");
        while (rs.next()) {
            //then don't forget to change column = SELECT
            System.out.println(rs.getString("room"));
            System.out.println(rs.getString("section"));
        }
    }

    public static void main(String[] args) throws SQLException {
        try {
            new Login("Student01","Student1234").loginWithUsernameAndPassword();
            new testData();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
