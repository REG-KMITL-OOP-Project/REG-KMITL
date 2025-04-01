package dev.it22.kmitl.reg.controller.classroom;

import dev.it22.kmitl.reg.utils.Database;

public class AdminCreateClassroom {
    public void create(String courseId, String dayOfWeek,String startTime , String endTime , String building , String room , int section , String  type , String teacherName ) throws Exception {
        try {
            Database db = new Database();
            String sectionCode = "0" ;
            if (section == 1) {
                sectionCode = "A";
            }
            if (section == 2) {
                sectionCode = "B";
            }
            if (section == 3) {
                sectionCode = "C";
            }
            String sql = "UPDATE `section` SET  WHERE `section`.`section_id` = '"+ ( "" + courseId + sectionCode) +"'";
        }
        catch (Exception e) {
            throw new Exception("ตรวจสอบให้แน่ใจว่า Section และ Course ID ถูกต้อง");
        }
    }
}
