package dev.it22.kmitl.reg.ui.event;

import dev.it22.kmitl.reg.utils.Config;

import java.awt.*;
import javax.swing.*;

public class ClassSchedulePage {
    private JFrame frame;
    //all
    private JPanel pn1;
    //head
        //head-menubar
        private JMenuBar bar;
        private JMenu ETC;
        private JMenuItem savePDF, saveIMG, share;
        private JLabel classSche;
        private JLabel tarangrian;
        private JButton home;

                //private JPanel head, header;
                //private JButton etc;
    //body-information
    private JPanel allInfo, testFormat, blank, chosen, stdInfo;
    private JLabel ID, name, faculty, branch;
    private JComboBox year, semester;
    //body-schedule
    private  JTable classSchedule;

    private String years[] = {"2568", "2567", "2566"};
    private String semesters[] = {"1", "2"};

    public ClassSchedulePage(JFrame frame){
        this.frame = frame;

        pn1 = new JPanel();
        //head
            //head-menubar
                bar = new JMenuBar();
                ETC = new JMenu("ETC");
                savePDF = new JMenuItem("Save PDF");
                saveIMG = new JMenuItem("Save IMG");
                share = new JMenuItem("Share");
                classSche = new JLabel("Class Schedule");
                tarangrian = new JLabel("Class Schedule");
                home = new JButton("Home"); //temp
                    //head = new JPanel();
                    //header = new JPanel();
                    //etc = new JButton("Etc"); //temp
        //body-information
        allInfo = new JPanel();
        testFormat = new JPanel();
        blank = new JPanel();
        chosen = new JPanel();
        stdInfo = new JPanel();

        ID = new JLabel("Student ID : ");
        name = new JLabel("Name : ");
        faculty = new JLabel("Faculty : ");
        branch = new JLabel("Branch : ");

        year = new JComboBox(years);
        semester = new JComboBox(semesters);


        //place components
        //head
            //head-menubar
                bar.add(home);
                bar.add(ETC);
                bar.add(tarangrian);
                ETC.add(classSche);
                ETC.add(savePDF);
                ETC.add(saveIMG);
                ETC.add(share);
                    //un use
                        //head.setBackground(null);
                        //header.setBackground(null);
                        //allInfo.setBackground(null);
                        //testFormat.setBackground(null);
                        //blank.setBackground(null);
                        //chosen.setBackground(null);
                        //stdInfo.setBackground(null);

                        //panel-header
                        //header.add(home);
                        //header.add(etc);
                        //header.add(tarangrian);
                        //head.setLayout(new BorderLayout());
                        //head.add(header, BorderLayout.WEST);


        //panel-year and semester button
        chosen.setLayout(new GridLayout(2, 1));
        chosen.add(year);
        chosen.add(semester);

        //panel-studentInfo
        stdInfo.setLayout(new GridLayout(2, 2));
        stdInfo.add(ID);
        stdInfo.add(name);
        stdInfo.add(faculty);
        stdInfo.add(branch);

        allInfo.setLayout(new BorderLayout());
        testFormat.setLayout(new BorderLayout());
        testFormat.add(blank, BorderLayout.WEST);
        testFormat.add(chosen, BorderLayout.CENTER);
        allInfo.add(testFormat, BorderLayout.WEST);
        allInfo.add(stdInfo, BorderLayout.CENTER);

        pn1.setLayout(new BorderLayout());
            //pn1.add(head, BorderLayout.NORTH);
        pn1.add(allInfo, BorderLayout.SOUTH);

        //set panels on frame
        frame.setLayout(new BorderLayout());
        frame.setJMenuBar(bar);
        frame.add(pn1, BorderLayout.NORTH);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new ClassSchedulePage(Config.createAndShowGUI());
    }
}
