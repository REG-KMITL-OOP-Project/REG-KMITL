package dev.it22.kmitl.reg.ui.event.calendar;

import dev.it22.kmitl.reg.controller.auth.Login;
import dev.it22.kmitl.reg.controller.auth.User;
import dev.it22.kmitl.reg.model.auth.Account;
import dev.it22.kmitl.reg.model.auth.Prof;
import dev.it22.kmitl.reg.model.auth.Student;
import dev.it22.kmitl.reg.ui.event.testData;
import dev.it22.kmitl.reg.utils.Database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class calendarData {
    //database
    private Account user;
    private Database db;
    ResultSet rs;

    public calendarData() throws SQLException {
        user = new User().getUserAccount();
        db = new Database();
        this.getEvent();
        this.getName();
        this.getDate();
        this.getType();
    }

    public String[] getEvent() throws SQLException {
        ResultSet rs = db.getQuery("SELECT name,Date,type FROM Event ");
        int rowCount = 0;
        rs.beforeFirst();
        while (rs.next()) {
            rowCount++;
        }
        String[] eventArray = new String[rowCount];

        int i = 0;
        while (rs.next()) {
            String eventInfo = rs.getString("name") + " - " +
                    rs.getString("Date") + " - " +
                    rs.getString("type");

            eventArray[i] = eventInfo;
            i++;
        }
        return eventArray;
    }

    public void getName() throws SQLException {
        rs = db.getQuery("SELECT name FROM Event");
        while (rs.next()) {
            System.out.println(rs.getString("name"));
        }
    }

    public void getDate() throws SQLException {
        rs = db.getQuery("SELECT Date FROM Event");
        while (rs.next()) {
            System.out.println(rs.getString("Date"));
        }
    }

    public void getType() throws SQLException {
        rs = db.getQuery("SELECT type FROM Event");
        while (rs.next()) {
            System.out.println(rs.getString("type"));
        }
    }
    public static void main(String[] args) throws SQLException {
        try {
            new Login("Student01","Student1234").loginWithUsernameAndPassword();
            new calendarData();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

