package dev.it22.kmitl.reg.ui.Homepage_regis;

import kotlin.random.Random;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Register {
    private JFrame frame;
    private JButton addclass,addtime,addsubjec;
    private JPanel top,low;
    private JComboBox Faculty,Semester;
    private JTable showdetail_Subject;
    private JScrollPane table;

    public Register(JFrame frame){
        this.frame = frame;
        addsubjec = new JButton("Add-Change Subjects");
        addtime = new JButton("Add Study time");
        addclass = new JButton("Add Class");


        top = new JPanel();
        top.add(addsubjec);
        top.add(addtime);
        top.add(addclass);
        top.setLayout(new FlowLayout());

        Faculty = new JComboBox();

        Semester = new JComboBox();

        low = new JPanel();
        low.add(Faculty);
        low.add(Semester);
        low.setLayout(new FlowLayout());

        table = new JScrollPane();
        showdetail_Subject = new JTable();
        table.setViewportView(showdetail_Subject);
        DefaultTableModel model = (DefaultTableModel)showdetail_Subject.getModel();
        model.addColumn("Subject code");
        model.addColumn("subject");
        model.addColumn("Section");
        model.addColumn("Class room");
        model.addColumn("Instructor");
        model.addColumn("condition");
        model.addColumn("Note");
        model.addColumn("Exam Date");
        model.addColumn("Accept");

        frame.setVisible(true);
    }
}
