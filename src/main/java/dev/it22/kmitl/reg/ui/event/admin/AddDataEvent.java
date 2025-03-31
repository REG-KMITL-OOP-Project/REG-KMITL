package dev.it22.kmitl.reg.ui.event.admin;

import dev.it22.kmitl.reg.utils.Database;

public class AddDataEvent {
    public AddDataEvent(String name,String description,String date,String type) {
        try{
            int db = new Database().postQuery("INSERT INTO Event (name, description, date, type) VALUES    ('"+name+"', '"+description+"', '"+date+"', '"+type+"');");
        }
        catch (Exception e) {

        }
    }
    /*
    public static void main(String[] args) {
        new AddDataEvent("Tech Conference 2025","งานประชุมเทคโนโลยีระดับนานาชาติ","2025-06-15","Conference");
    }*/
}
