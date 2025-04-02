package dev.it22.kmitl.reg.ui.event.classSch;

import dev.it22.kmitl.reg.controller.auth.User;
import dev.it22.kmitl.reg.model.auth.Account;
import dev.it22.kmitl.reg.model.auth.Prof;
import dev.it22.kmitl.reg.model.auth.Student;
import dev.it22.kmitl.reg.ui.event.component.SeletedItemCombobox;
import dev.it22.kmitl.reg.utils.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

public class ClassData {
    private Account user;
    private Database db;

    public ClassData() throws SQLException {
        user = new User().getUserAccount();
        db = new Database();
    }

    public String[] getSubject(String day) {
        String[] subject = new String[12];
        Arrays.fill(subject, ""); // เติมค่าเริ่มต้นเป็นว่างเปล่า

        try {
            String query = null;
            if (user instanceof Student) {
                query = "SELECT s.room, c.course_code, c.course_name, s.section, s.start_time, s.end_time " +
                        "FROM enrollment e " +
                        "JOIN section s ON e.section_id = s.section_id " +
                        "JOIN course c ON s.course_id = c.course_code " +
                        "WHERE e.std_id = '" + ((Student) user).getStudentId() + "' " +
                        "AND s.day_of_week = '" + day + "' ORDER BY s.start_time;";
            } else if (user instanceof Prof) {
                query = "SELECT s.room, c.course_code, c.course_name, s.section, s.start_time, s.end_time " +
                        "FROM section s " +
                        "JOIN course c ON s.course_id = c.course_code " +
                        "WHERE s.prof_id = '" + ((Prof) user).getProf_id() + "' " +
                        "AND s.day_of_week = '" + day + "' ORDER BY s.start_time;";
            }

            if (query == null) return subject;

            ResultSet rs = db.getQuery(query);
            while (rs.next()) {
                String sub = "[" + rs.getString("room") + "] " + rs.getString("course_name") +
                        " (SECTION " + rs.getString("section") + ")";

                int startHour = Integer.parseInt(rs.getString("start_time").split(":")[0]);
                int endHour = Integer.parseInt(rs.getString("end_time").split(":")[0]);

                int startIndex = startHour - 8;
                int endIndex = endHour - 9;

                if (startIndex >= 0 && startIndex < 12 && endIndex >= 0 && endIndex < 12) {
                    for (int i = startIndex; i <= endIndex; i++) {
                        subject[i] = sub;
                    }
                }
            }
            return subject;
        } catch (SQLException e) {
            e.printStackTrace();
            return subject;
        }
    }
}