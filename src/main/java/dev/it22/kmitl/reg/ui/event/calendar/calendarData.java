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
import java.util.ArrayList;
import java.util.Arrays;

public class calendarData {
    //database
    private Account user;
    private Database db;
    ResultSet rs;

    //SELECT `Date`,`name`,`type` FROM `Event` WHERE `Date` BETWEEN '2026-03-1' AND '2026-03-31';

    public calendarData() {
        try {
            user = new User().getUserAccount();
            db = new Database();
//            this.getEvent();
//            this.getName();
//            this.getDate();
//            this.getType();
            this.getDataEvents(8);
        }catch (Exception e) {}
    }

    public ArrayList<String[]> getDataEvents(int month) {
        try{
            ArrayList<String[]> events = new ArrayList<String[]>();

            String q = "SELECT Date, name, type FROM Event WHERE Date " + this.setDateFormat(month);
            rs = db.getQuery(q);
            while (rs.next()) {
                String[] ev = new String[0];
                //System.out.println(rs.getString("Date") + " " + rs.getString("name") + " " + rs.getString("type"));
                ev = new String[]{
                                                rs.getString("Date").replaceAll("-", "/"),
                                                rs.getString("name"),
                                                rs.getString("type")
                                                };
                System.out.println(Arrays.toString(ev));
                events.add(ev);
            }
            System.out.println(events);
            return events;
        }catch (Exception e){
            return null;
        }
    }
    public String setDateFormat(int month) {
        // 6-12 (25) : 1-5 (26)
        // 30 : 4/6/9/11
        // 28 : 2
        String start = "";
        String end = "";
        if (month == 2) {
            start += "2026-0" + month + "-01";
            end += "2026-0" + month + "-28";
        }
        else if(month == 4 || month == 6 || month == 9) {
            start += "2026-0" + month + "-01";
            end += "2026-0" + month + "-30";
        }
        else if (month == 11) {
            start += "2026-" + month + "-01";
            end += "2026-" + month + "-30";
        }
        else if (month >= 1 && month <= 5) {
            start += "2026-0" + month + "-01";
            end += "2026-0" + month + "-31";
        }
        else if (month >= 6 && month <= 9) {
            start += "2025-0" + month + "-01";
            end += "2025-0" + month + "-31";
        }
        else if (month >= 10 && month <= 12) {
            start += "2025-" + month + "-01";
            end += "2025-" + month + "-31";
        }
        //System.out.println("BETWEEN " + start + " AND " + end);
        return "BETWEEN '" + start + "' AND '" + end + "'";
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
        System.out.println(Arrays.toString(eventArray));
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

