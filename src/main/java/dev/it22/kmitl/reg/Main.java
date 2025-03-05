package dev.it22.kmitl.reg;

import dev.it22.kmitl.reg.ui.HomePage;
import dev.it22.kmitl.reg.ui.profile.LoginFrame;
import dev.it22.kmitl.reg.utils.Config;

import javax.swing.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        // Databse Test
//        Database db = new Database();
//        ResultSet rs = null;
        JFrame a = Config.createAndShowGUI();
        new LoginFrame(a);
//        try {
//            rs = db.getQuery("SELECT * FROM user;");
//            while (rs.next()) {
//                System.out.println(rs.getString(1));
//                System.out.println(rs.getString(2));
//            }
//        }
//        catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
    }
}