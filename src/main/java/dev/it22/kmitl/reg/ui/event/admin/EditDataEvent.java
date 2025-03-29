package dev.it22.kmitl.reg.ui.event.admin;
import dev.it22.kmitl.reg.utils.Database;
import java.sql.ResultSet;
import java.util.ArrayList;

public class  EditDataEvent {
    public ArrayList<String> getData(String name , String type){
        ArrayList<String> list = new ArrayList<String>();
        try{
            Database db = new Database();
            ResultSet rs = db.getQuery("SELECT *  FROM Event WHERE name = '"+name+"' AND type = '"+type+"';");
            while (rs.next()){
                if (list.isEmpty()){
                    list.add(rs.getString("name"));
                    list.add(rs.getString("description"));
                    list.add(rs.getString("Date"));
                    list.add(rs.getString("type"));
                } else{
                    list.add(rs.getString("Date"));
                }
                list.add(rs.getString("id"));
            }
        }
        catch (Exception e) {

        }
        return list;
    }/*
    public static void main(String[] args) {
        new EditDataEvent().changeData(27,28,"ห้ะ","-","2025-01-22","2025-01-24","ภาคการศึกษาที่ 2");
    }*/
    public void changeData(int id1,int id2, String name, String description, String dateStart ,String dateEnd , String type){
        try{
            Database db = new Database();
            int ch = db.postQuery("UPDATE Event SET name = '"+name+"' , description = '"+description+"', Date = '"+dateStart+"' , type = '"+type+"' WHERE id = "+id1+";");
            ch = db.postQuery("UPDATE Event SET name = '"+name+"' , description = '"+description+"', Date = '"+dateEnd+"' , type = '"+type+"' WHERE id = "+id2+";");
        }
        catch (Exception e) {

        }
    }
    public void changeData(int id1, String name, String description, String dateStart, String type){
        try{
            Database db = new Database();
            int ch = db.postQuery("UPDATE Event SET name = '"+name+"' , description = '"+description+"', Date = '"+dateStart+"' , type = '"+type+"' WHERE id = "+id1+";");
        }
        catch (Exception e) {

        }
    }

    public void deleteData(int id1,int id2){
        try{
            Database db = new Database();
            int ch = db.postQuery("DELETE FROM Event WHERE id = "+id1+";");
            ch = db.postQuery("DELETE FROM Event WHERE id = "+id2+";");
        }
        catch (Exception e) {

        }
    }

    public void deleteData(int id1){
        try{
            Database db = new Database();
            int ch = db.postQuery("DELETE FROM Event WHERE id = "+id1+";");
        }
        catch (Exception e) {

        }
    }
}
