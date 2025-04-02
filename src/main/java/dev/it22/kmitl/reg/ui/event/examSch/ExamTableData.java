package dev.it22.kmitl.reg.ui.event.examSch;

import dev.it22.kmitl.reg.model.auth.Account;
import dev.it22.kmitl.reg.utils.Database;

import java.sql.SQLException;

import dev.it22.kmitl.reg.controller.auth.User;
import dev.it22.kmitl.reg.model.auth.*;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import dev.it22.kmitl.reg.ui.event.component.SeletedItemCombobox;

public class ExamTableData {
    //database
    private Account user;
    private Database db;

    public ExamTableData() throws SQLException {
        user = new User().getUserAccount();
        db = new Database();

    }

    public String[][] getData() {
        ArrayList<String[]> allDataList = new ArrayList<>();
        try {
            String q = null;
            if (user instanceof Student) {
                q = "SELECT subject, midterm_date, midterm_start_time, midterm_end_time, course_id,room ," +
                        "type FROM exam WHERE section =" + ((Student) user).getSection();

                /*q = "SELECT u.std_id, c.course_code, c.course_name, e.date AS exam_date, " +
                        "e.start_time AS exam_start, " + "e.end_time AS exam_end, " +
                        "e.subject AS exam_subject, e.type AS exam_type, e.room AS exam_room " +
                        "FROM enrollment en INNER JOIN user u ON en.std_id = u.std_id INNER JOIN " +
                        "section s ON en.section_id = s.section_id " +
                        "INNER JOIN exam e ON s.section_id = e.section_id " +
                        "INNER JOIN course c ON s.course_id = c.course_code " +
                        "WHERE u.std_id ="+ ((Student) user).getStudentId();*/

            } else if (user instanceof Prof) {
                q = "SELECT e.*, s.* FROM exam e JOIN section s ON e.section_id = s.section_id AND e.course_id = s.course_id WHERE s.prof_id = '"+ ((Prof)user).getProf_id()+"';";
            }
            ResultSet rs = db.getQuery(q);

            while (rs.next()) {
                //ดึงข้อมูล
                String dayOfWeek = rs.getString("midterm_date");
                String startTime = rs.getString("midterm_start_time");
                String endTime = rs.getString("midterm_end_time");
                String courseId = rs.getString("course_id");
                String courseName = rs.getString("subject");
                String type = rs.getString("type");
                String room = rs.getString("room");

                //เอาข้อมูลใส่ list
                String[] data = new String[6];
                data[0] = this.formatDate(dayOfWeek);
                data[1] = this.getTime(startTime,endTime);
                data[2] = courseId;
                data[3] = courseName;
                data[4] = type;
                data[5] = room;

                allDataList.add(data);
            }

            //เอา list มาทำเป็น array
            String[][] result = new String[allDataList.size()][6];
            allDataList.toArray(result);
            return result;

        } catch (SQLException e) {
            e.printStackTrace();
            return new String[0][0];
        }
    }

    public String formatDate (String inputDate)throws SQLException {
        LocalDate date = LocalDate.parse(inputDate);
        DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return date.format(outputFormat);
    }

    public String getTime(String start,String end) throws SQLException {
            String timeRange = start.substring(0, 5) + "-" + end.substring(0, 5);
            return (timeRange);
    }


    public void SelectedItem(SeletedItemCombobox comboBoxHandler) {
        System.out.println("Year Item: " + comboBoxHandler.getYearItem());
        System.out.println("Semester Item: " + comboBoxHandler.getSemItem());
        System.out.println("Exam Item: " + comboBoxHandler.getExamItem());
    }

//    public static void main(String[] args) {
//        try {
//            new Login("Student01","Student1234").loginWithUsernameAndPassword();
//            examTableData exData = new examTableData();
//            exData.SelectedItem(new ExamSchedulePage(Config.createAndShowGUI()));
//        }
//        catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
//

    //get subject name from another table
    public String getCourseName(String id) throws SQLException {
        ResultSet rc = db.getQuery("SELECT course_name FROM course WHERE course_code = '" + id + "'");
        while (rc.next()) {
            return (rc.getString("course_name"));
        }
        return null;
    }
}