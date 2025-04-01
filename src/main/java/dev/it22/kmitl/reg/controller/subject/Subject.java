package dev.it22.kmitl.reg.controller.subject;

import dev.it22.kmitl.reg.utils.Database;

import java.sql.ResultSet;

public class Subject {
    public ResultSet getAllSubject() throws Exception{
        Database db = new Database();
        String sql = "SELECT * FROM course";
        ResultSet rs = db.getQuery(sql);
        return rs;
    }
}

