package dev.it22.kmitl.reg.ui.event.classSch;

import dev.it22.kmitl.reg.controller.auth.Login;
import dev.it22.kmitl.reg.controller.auth.User;
import dev.it22.kmitl.reg.model.auth.Account;
import dev.it22.kmitl.reg.model.auth.Prof;
import dev.it22.kmitl.reg.model.auth.Student;
import dev.it22.kmitl.reg.utils.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class classData {
    //database
    private Account user;
    private Database db;

    public classData() throws SQLException {
        user = new User().getUserAccount();
        db = new Database();

        //this.getSubject("MON");
    }


    public String[] getSubject(String day) throws SQLException {
        String q = null;
        if (user instanceof Student) {
            q = "SELECT room, course_id, section_id FROM section WHERE section = " + ((Student)user).getSection() + " AND day_of_week = '" + day + "'" ;
        }
        else if (user instanceof Prof){
            q = "SELECT room, course_id, section_id FROM section WHERE prof_id = " + ((Prof)user).getProf_id() + " AND day_of_week = '" + day + "'" ;
        }
        ResultSet rs = db.getQuery(q);
        String[] subject = new String[12];
        int i = 0;
        while (rs.next()) {
            String[] ject;
            String sub = "";
            sub += "[" + rs.getString("room") + "] " + this.getCourseName(rs.getString("course_id"));
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
        return subject;
    }

    //get subject name from another table
    public String getCourseName(String id) throws SQLException {
        ResultSet rc = db.getQuery("SELECT course_name FROM course WHERE course_code = '" + id + "'");
        while (rc.next()) {
            return (rc.getString("course_name"));
        }
        return null;
    }

    public static void main(String[] args) throws SQLException {
        try {
            new Login("Student01","Student1234").loginWithUsernameAndPassword();
            new classData();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
