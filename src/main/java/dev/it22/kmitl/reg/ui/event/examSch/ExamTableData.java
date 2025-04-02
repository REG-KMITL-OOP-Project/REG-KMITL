package dev.it22.kmitl.reg.ui.event.examSch;

import dev.it22.kmitl.reg.model.auth.Account;
import dev.it22.kmitl.reg.utils.Database;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import dev.it22.kmitl.reg.controller.auth.User;
import dev.it22.kmitl.reg.model.auth.*;

import dev.it22.kmitl.reg.ui.event.component.SeletedItemCombobox;

public class ExamTableData {
    // Database connection
    private Account user;
    private Database db;

    public ExamTableData() throws SQLException {
        user = new User().getUserAccount();
        db = new Database();
    }

    public String[][] getData(String year, String semester) {
        ArrayList<String[]> allDataList = new ArrayList<>();
        try {
            String q = null;
            if (user instanceof Student) {
                q = "SELECT e.ID, e.course_id, c.course_name, e.section_id, e.midterm_date, e.midterm_start_time, " +
                        "e.midterm_end_time, e.final_date, e.final_start_time, e.final_end_time, e.subject, e.room, e.type " +
                        "FROM enrollment en " +
                        "JOIN section s ON en.section_id = s.section_id " +
                        "JOIN exam e ON s.section_id = e.section_id " +
                        "JOIN course c ON s.course_id = c.course_code " +
                        "WHERE en.std_id = '" + ((Student) user).getStudentId() + "';";
            } else if (user instanceof Prof) {
                q = "SELECT e.ID, e.course_id, c.course_name, e.section_id, e.midterm_date, e.midterm_start_time, " +
                        "e.midterm_end_time, e.final_date, e.final_start_time, e.final_end_time, e.subject, e.room, e.type " +
                        "FROM exam e " +
                        "JOIN section s ON e.section_id = s.section_id " +
                        "JOIN course c ON s.course_id = c.course_code " +
                        "WHERE s.prof_id = '" + ((Prof) user).getProf_id() + "';";
            }

            ResultSet rs = db.getQuery(q);

            while (rs.next()) {
                // Extract data
                String examDate = rs.getString("midterm_date"); // ใช้ midterm_date เป็นค่าหลัก
                String startTime = rs.getString("midterm_start_time");
                String endTime = rs.getString("midterm_end_time");
                String courseId = rs.getString("course_id");
                String courseName = rs.getString("course_name");
                String examType = rs.getString("type");
                String room = rs.getString("room");

                if (courseName == null || courseName.isEmpty()) {
                    courseName = getCourseName(courseId);
                }

                // Format data
                String[] data = new String[6];
                data[0] = this.formatDate(examDate);
                data[1] = this.getTime(startTime, endTime);
                data[2] = courseId;
                data[3] = courseName;
                data[4] = examType;
                data[5] = room;

                allDataList.add(data);
            }

            // Convert list to array
            String[][] result = new String[allDataList.size()][6];
            allDataList.toArray(result);
            return result;

        } catch (SQLException e) {
            e.printStackTrace();
            return new String[0][0];
        }
    }

    public String formatDate(String inputDate) {
        if (inputDate == null) return "-";
        LocalDate date = LocalDate.parse(inputDate);
        DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return date.format(outputFormat);
    }

    public String getTime(String start, String end) {
        if (start == null || end == null) return "-";
        return start.substring(0, 5) + "-" + end.substring(0, 5);
    }

    public String getCourseName(String id) throws SQLException {
        ResultSet rc = db.getQuery("SELECT course_name FROM course WHERE course_code = '" + id + "'");
        while (rc.next()) {
            return rc.getString("course_name");
        }
        return "-";
    }

    public void SelectedItem(SeletedItemCombobox comboBoxHandler) {
        System.out.println("Year: " + comboBoxHandler.getYearItem());
        System.out.println("Semester: " + comboBoxHandler.getSemItem());
        System.out.println("Exam Type: " + comboBoxHandler.getExamItem());
    }
}
