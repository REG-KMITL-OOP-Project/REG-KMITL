package dev.it22.kmitl.reg.model.transcript;

import dev.it22.kmitl.reg.controller.auth.User;
import dev.it22.kmitl.reg.model.auth.Account;
import dev.it22.kmitl.reg.model.auth.Student;
import dev.it22.kmitl.reg.controller.transcript.Transcript;
import dev.it22.kmitl.reg.utils.Database;

import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class TranscriptModel {
    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm");
    private Account user = new User().getUserAccount();

    private String name = user.getFullName(),
            dateOB = "N/A",
            dateOA = (Integer.valueOf("25" +(((Student)user).getStudentId().charAt(0) +"" + ((Student)user).getStudentId().charAt(1))) - 543)+"",
            degree = "Bachelor of Science",
            major = ((Student)user).getMajor(),
            studentID = ((Student)user).getStudentId();

    private String []semester = {"1st Semester, Year, "+Integer.valueOf(dateOA) +"-"+ (Integer.valueOf(dateOA)+1), "2nd Semester, Year, "+(Integer.valueOf(dateOA)) +"-"+ (Integer.valueOf(dateOA)+1),
            "1st Semester, Year, "+Integer.valueOf(dateOA+1) +"-"+ (Integer.valueOf(dateOA)+2), "2nd Semester, Year, "+(Integer.valueOf(dateOA)+1) +"-"+ (Integer.valueOf(dateOA)+2),
            "1st Semester, Year, "+Integer.valueOf(dateOA+2) +"-"+ (Integer.valueOf(dateOA)+3), "2nd Semester, Year, "+(Integer.valueOf(dateOA)+2) +"-"+ (Integer.valueOf(dateOA)+3),
            "1st Semester, Year, "+Integer.valueOf(dateOA+3) +"-"+ (Integer.valueOf(dateOA)+4), "2nd Semester, Year, "+(Integer.valueOf(dateOA)+3) +"-"+ (Integer.valueOf(dateOA)+4)};
    private ArrayList<ArrayList<String>> subject = new ArrayList<>();
    private ArrayList<ArrayList<String>> subjectNumberList = new ArrayList<>();
    private ArrayList<ArrayList<String>> creditsList = new ArrayList<>();
    private ArrayList<ArrayList<String>> gradeList = new ArrayList<>();

    public TranscriptModel() {
        try{
            for (int i = 2024; i <= 2025; i++) {
                ResultSet rs = new Database().getQuery("SELECT c.course_code, c.course_name, c.credits,g.grade, ex.final_date FROM enrollment e JOIN grade g ON e.enrollment_id = g.enrollment_id JOIN section s ON e.section_id = s.section_id JOIN course c ON s.course_id = c.course_code JOIN exam ex ON e.section_id = ex.section_id WHERE e.std_id = '" + ((Student) user).getStudentId() + "' AND YEAR(ex.final_date) = '"+ i +"'ORDER BY c.course_code ASC;");
                ArrayList<String> a1 = new ArrayList<>();
                ArrayList<String> a2 = new ArrayList<>();
                ArrayList<String> a3 = new ArrayList<>();
                ArrayList<String> a4 = new ArrayList<>();
                while (rs.next()) {
                    a1.add(rs.getString("course_code"));
                    a2.add(rs.getString("course_name"));
                    a3.add(rs.getString("credits"));
                    a4.add(rs.getString("grade"));
                }
                subject.add(a2);
                subjectNumberList.add(a1);
                creditsList.add(a3);
                gradeList.add(a4);
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void getTranscript(){
        Transcript.pdfFilepath =  System.getProperty("user.home") + "/Downloads/transcript_" + dtf.format(LocalDateTime.now()) + ".pdf";
        try{
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(subject);
        System.out.println(subjectNumberList);
        System.out.println(creditsList);
        System.out.println(gradeList);
        new Transcript(name, dateOB, dateOA, degree, major, studentID, semester, subject, subjectNumberList, creditsList, gradeList);
    }

    public String getName(){
        return name;
    }

    public String getDateOB(){
        return dateOB;
    }

    public String getDateOA(){
        return dateOA;
    }

    public String getDegree(){
        return degree;
    }

    public String getMajor(){
        return major;
    }

    public String getStudentID(){
        return studentID;
    }

    public String[] getSemester(){
        return semester;
    }

    public ArrayList<ArrayList<String>> getSubject(){
        return subject;
    }

    public ArrayList<ArrayList<String>> getSubjectNumberList(){
        return subjectNumberList;
    }

    public ArrayList<ArrayList<String>> getCreditsList(){
        return creditsList;
    }

    public ArrayList<ArrayList<String>> getGradeList(){
        return gradeList;
    }
}
