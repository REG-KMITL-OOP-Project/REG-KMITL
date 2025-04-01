package dev.it22.kmitl.reg.controller.classroom;

import dev.it22.kmitl.reg.utils.Database;

public class AdminCreateClassroom {
    public void create(String sectionId,String courseId,) throws Exception {
        try {
            Database db = new Database();
            String sql = "\n" +
                    "INSERT INTO `section` (`section_id`, `course_id`, `prof_id`, `day_of_week`, `start_time`, `end_time`, `building`, `room`, `max_std`, `section`, `prof_name`) VALUES ('', '', NULL, NULL, '', '', '', '', '', '', NULL)"
        }
        catch (Exception e) {
            throw new Exception("เกิดข้อผิดพลาดในการสร้างห้องเรียน โปรดตรวจสอบให้แน่ใจว่าไม่มีข้อมูลที่ซั้บซ้อนกันในระบบ");
        }
    }
}
