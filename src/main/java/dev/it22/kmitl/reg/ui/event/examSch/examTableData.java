package dev.it22.kmitl.reg.ui.event.examSch;

import dev.it22.kmitl.reg.model.auth.Account;
import dev.it22.kmitl.reg.utils.Database;
import java.sql.SQLException;
import dev.it22.kmitl.reg.controller.auth.Login;
import dev.it22.kmitl.reg.controller.auth.User;
import dev.it22.kmitl.reg.controller.auth.User;
import dev.it22.kmitl.reg.model.auth.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class examTableData {
    //database
    private Account user;
    private Database db;

    public examTableData() throws SQLException {
        user = new User().getUserAccount();
        db = new Database();

    }

    public String[][] getData() {
        ArrayList<String[]> allDataList = new ArrayList<>();
        try {
            String q = null;
            if (user instanceof Student) {
                q = "SELECT day_of_week, start_time, end_time, course_id," +
                        " section_id, room FROM section WHERE section = " + ((Student) user).getSection();
            } else if (user instanceof Prof) {
                q = "SELECT day_of_week, start_time, end_time, course_id," +
                        " section_id, room FROM section WHERE prof_id = " + ((Prof)user).getProf_id();
            }
            ResultSet rs = db.getQuery(q);

            while (rs.next()) {
                String dayOfWeek = rs.getString("day_of_week");
                String startTime = rs.getString("start_time");
                String endTime = rs.getString("end_time");
                String courseId = rs.getString("course_id");
                String type = rs.getString("section_id");
                String room = rs.getString("room");

                String[] data = new String[6];
                data[0] = dayOfWeek;
                data[1] = this.getTime(startTime,endTime);
                data[2] = courseId;
                data[3] = this.getCourseName(rs.getString("course_id"));
                data[4] = type;
                data[5] = room;

                allDataList.add(data);
            }
            String[][] result = new String[allDataList.size()][6];
            allDataList.toArray(result);
            return result;

        } catch (SQLException e) {
            e.printStackTrace();
            return new String[0][0];
        }
    }

    public String getTime(String start,String end) throws SQLException {
            String timeRange = start.substring(0, 5) + "-" + end.substring(0, 5);
            return (timeRange);
    }

    //get subject name from another table
    public String getCourseName(String id) throws SQLException {
        ResultSet rc = db.getQuery("SELECT course_name FROM course WHERE course_code = '" + id + "'");
        while (rc.next()) {
            return (rc.getString("course_name"));
        }
        return null;
    }
}