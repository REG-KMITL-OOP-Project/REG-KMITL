package dev.it22.kmitl.reg.ui.event.classSch;

import dev.it22.kmitl.reg.controller.auth.User;
import dev.it22.kmitl.reg.model.auth.Account;
import dev.it22.kmitl.reg.model.auth.Prof;
import dev.it22.kmitl.reg.model.auth.Student;
import dev.it22.kmitl.reg.ui.event.component.SeletedItemCombobox;
import dev.it22.kmitl.reg.ui.event.examSch.ExamTableData;
import dev.it22.kmitl.reg.utils.Database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClassData {
    //database
    private Account user;
    private Database db;

    public ClassData() throws SQLException {
        user = new User().getUserAccount();
        db = new Database();

        //this.getSubject("MON");
    }


    public String[] getSubject(String day){
        String[] subject = new String[12];
        try{
            String q = null;
            if (user instanceof Student) {
                q = "SELECT room, course_id, section_id, section FROM section WHERE section = " + ((Student)user).getSection() + " AND day_of_week = '" + day + "'" ;
            }
            else if (user instanceof Prof){
                q = "SELECT room, course_id, section_id, section FROM section WHERE prof_id = " + ((Prof)user).getProf_id() + " AND day_of_week = '" + day + "'" ;
            }
            ResultSet rs = db.getQuery(q);
            int i = 0;
            while (rs.next()) {
                String[] ject;
                String sub = "";
                sub += "[" + rs.getString("room") + "] " + this.getCourseName(rs.getString("course_id")) + " (SECTION " + rs.getString("section") + ")";
                //System.out.println(sub);

                //add subject at table by time
                ResultSet rc = db.getQuery("SELECT start_time, end_time FROM section WHERE section_id = '" + rs.getString("section_id") + "'");
                while (rc.next()) {
                    int start = Integer.parseInt(rc.getString("start_time").substring(0, 2)) - 8;
                    int end = Integer.parseInt(rc.getString("end_time").substring(0, 2)) - 9;
                    if (start < 0 || start > 12 || end < 0 || end > 12) {
                        break;
                    }
                    while (start <= end) {
                        subject[start] = sub;
                        start++;
                    }
                    //System.out.println(Arrays.deepToString(subject));
                }
            }
            //System.out.println(subject);
            return subject;
        }catch (SQLException e){
            return subject;
        }
    }

    //get subject name from another table
    public String getCourseName(String id) throws SQLException {
        ResultSet rc = db.getQuery("SELECT course_name FROM course WHERE course_code = '" + id + "'");
        while (rc.next()) {
            return (rc.getString("course_name"));
        }
        return null;
    }

    public void SelectedItem(SeletedItemCombobox comboBoxHandler) {
        System.out.println("Year Item: " + comboBoxHandler.getYearItem());
        System.out.println("Semester Item: " + comboBoxHandler.getSemItem());
        System.out.println("Exam Item: " + comboBoxHandler.getExamItem());
    }


//    public static void main(String[] args) throws SQLException {
//        try {
//            new Login("Student01","Student1234").loginWithUsernameAndPassword();
//            classData classCombo = new classData();
//            classCombo.SelectedItem(new ClassSchedulePage(Config.createAndShowGUI()));
//        }
//        catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
}
