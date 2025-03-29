package dev.it22.kmitl.reg.ui.event.calendar;

import dev.it22.kmitl.reg.controller.auth.Login;
import dev.it22.kmitl.reg.controller.auth.User;
import dev.it22.kmitl.reg.model.auth.Account;
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

    private String[][] events;

    public calendarData() {
        try {
            user = new User().getUserAccount();
            db = new Database();

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String[][] eventsData(int month) {
        try{
            //store events in ArrayList
            ArrayList<String[]> arrayEvents = new ArrayList<String[]>();

            String q = "SELECT Date, name, type FROM Event WHERE Date " + this.setDateFormat(month) + "ORDER BY Date ASC";
            rs = db.getQuery(q);
            while (rs.next()) {
                String[] ev;
                ev = new String[]{
                        rs.getString("Date").replaceAll("-", "/"),
                        rs.getString("name"),
                        rs.getString("type")
                };
                arrayEvents.add(ev);
            }
            if (arrayEvents.size() <= 0) {
                arrayEvents.add(new String[1]);
            }

            //store data in ArrayList to array to fits table
            ArrayList<String[]> data = arrayEvents;
            int size = arrayEvents.size();
            String[][] events = new String[size][3];
            int n = 0;
            while (n < size) {
                for (String[] i : data){
                    events[n][0] = i[0];
                    events[n][1] = i[1];
                    events[n][2] = i[2];
                    n++;
                }
            }
            return events;
        }catch (Exception e){
            return new String[1][3];
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
        else if (month == 61) {
            start += "2026-06-01";
            end += "2026-06-10";
        }
        else if(month == 4 || month == 9) {
            start += "2026-0" + month + "-01";
            end += "2026-0" + month + "-30";
        }
        else if(month == 6) {
            start += "2025-0" + month + "-10";
            end += "2025-0" + month + "-30";
        }
        else if (month == 11) {
            start += "2025-" + month + "-01";
            end += "2025-" + month + "-30";
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

    public ArrayList<String[]> getDataEvents(int month) {
        try{
            ArrayList<String[]> events = new ArrayList<String[]>();

            String q = "SELECT Date, name, type FROM Event WHERE Date " + this.setDateFormat(month) + "ORDER BY Date ASC";
            rs = db.getQuery(q);
            while (rs.next()) {
                String[] ev;
                ev = new String[]{
                        rs.getString("Date").replaceAll("-", "/"),
                        rs.getString("name"),
                        rs.getString("type")
                };
                events.add(ev);
            }
            if (events.size() <= 0) {
                events.add(new String[1]);
            }
            //System.out.println(events.size());
            return events;
        }catch (Exception e){
            System.out.println("Exception");
            return null;
        }
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

