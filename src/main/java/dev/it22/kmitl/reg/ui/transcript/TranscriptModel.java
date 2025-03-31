package dev.it22.kmitl.reg.ui.transcript;

import dev.it22.kmitl.reg.controller.auth.User;
import dev.it22.kmitl.reg.model.auth.Account;
import dev.it22.kmitl.reg.model.auth.Student;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
    private String [][] subject = {{"MATHEMATICS FOR INFORMATION TECHNOLOGY", "INFORMATION TECHNOLOGY FUNDAMENTALS", "INTRODUCTION TO COMPUTER SYSTEMS", "PROBLEM SOLVING AND COMPUTER PROGRAMMING", "CHARM SCHOOL", "FOUNDATION ENGLISH 1", "FOUNDATION ENGLISH 2"},
            {"OBJECT-ORIENTED PROGRAMMING", "PROBABILITY AND STATISTICS", "BUSINESS FUNDAMENTALS FOR INFORMATION", "DATA STRUCTURES AND ALGORITHMS", "DIGITAL CITIZEN"}};
    private String[][] subjectNumberList = {{"06016401", "06016402", "06016411", "06066303", "90642999", "90644007", "90644008"},
            {"06016408", "06066001", "06066101", "06066301", "90641007"}};
    private int[][] creditsList = {{3, 3, 3, 3, 3, 3, 3},
            {3, 3, 3, 3, 3}};
    private String[][] gradeList = {{"A", "B+", "B+", "A", "S", "S", "S"}};

    public void getTranscript(){
        Transcript.pdfFilepath =  System.getProperty("user.home") + "/Downloads/transcript_" + dtf.format(LocalDateTime.now()) + ".pdf";
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

    public String[][] getSubject(){
        return subject;
    }

    public String[][] getSubjectNumberList(){
        return subjectNumberList;
    }

    public int[][] getCreditsList(){
        return creditsList;
    }

    public String[][] getGradeList(){
        return gradeList;
    }
}
