package dev.it22.kmitl.reg.ui.Class_Management;

import dev.it22.kmitl.reg.utils.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminAddGroupClass implements FocusListener , ActionListener {
    private JFrame frame ;
    private JPanel panelBig,panelRek1,panelRek2,panelRek3,panelRek5,panelHead,panelTime,panelTimeExamMid, panelDateExamMid,panelTimeExamFinal,groupPan,numPan,typePan,towPan,roomPan,panelTimeExamMidEnd,panelDateExamFinal,panelTimeExamFinalEnd;
    private JLabel numGroupLabel,numStuLabel,typeLabel,addGroup,dateExam,timeExam,dateExamFinal,timeExamFinal, timeExamFinalEnd,timeExamEnd,towLabel,roomLabel;
    private RoundedTextField numGroup,numStu,time,mid,fi,room;
    private JComboBox tow;
    private CourseNameCombo type;
    private Font innerFont, regularFont;
    private TimeComboBox timeMid, timeMidEnd, timeFinal, timeFinalEnd;
    private RoundedButton cancel,save;
    private JPanel panelSave = new JPanel() , panelCan = new JPanel();
    protected boolean showGroup, showStu, showTime, showMid,showFi,showRoom;

    public AdminAddGroupClass(JFrame frame){
        this.frame = frame;
        panelBig = new JPanel();
        panelHead = new JPanel();
        panelRek1 = new JPanel();
        panelRek2 = new JPanel();
        panelRek3 = new JPanel();
        panelRek5 = new JPanel();
        panelTime = new JPanel();
        panelTimeExamMid = new JPanel();
        panelTimeExamFinal  = new JPanel();
        groupPan = new JPanel();
        numPan = new JPanel();
        typePan = new JPanel();
        towPan = new JPanel();
        roomPan = new JPanel();
        panelTimeExamMidEnd = new JPanel();
        panelDateExamMid = new JPanel();
        panelDateExamFinal = new JPanel();
        panelTimeExamFinal = new JPanel();
        panelTimeExamFinalEnd = new JPanel();
        timeMid =  new TimeComboBox();
        timeMidEnd = new TimeComboBox();
        timeFinal = new TimeComboBox();
        timeFinalEnd = new TimeComboBox();
        numGroupLabel = new JLabel("จำนวนกลุ่มเรียน");
        numStuLabel = new JLabel("จำนวนนักศึกษาที่รับ");
        typeLabel = new JLabel("วิชา");
        addGroup = new JLabel("              เพิ่มกลุ่มเรียน");
        //date = new JLabel("วัน-เวลาเรียน");
        dateExam = new JLabel("วันสอบกลางภาค");
        timeExam = new JLabel("เวลาเริ่มสอบกลางภาค");
        timeExamEnd = new JLabel("หมดเวลาสอบกลางภาค");
        dateExamFinal = new JLabel("วันสอบปลายภาค");
        timeExamFinal = new JLabel("เวลาเริ่มสอบปลายภาค");
        timeExamFinalEnd = new JLabel("หมดเวลาสอบปลายภาค");
        //towLabel = new JLabel("อาคารเรียน");
        //roomLabel = new JLabel("ห้องเรียน");
        numGroup = new RoundedTextField(22);
        time = new RoundedTextField(22);
        mid = new RoundedTextField(22);
        fi = new RoundedTextField(22);
        //room = new RoundedTextField(22);
        numStu = new RoundedTextField(22);
        cancel = new RoundedButton("CANCEL" ,22);
        save = new RoundedButton("SAVE" ,22);
        type = new CourseNameCombo();
        //tow = new JComboBox();
        regularFont = Config.NORMAL_REGULAR;
        innerFont = regularFont.deriveFont(15f);

        panelBig.setBackground(null);
        panelHead.setBackground(null);
        panelRek1.setBackground(null);
        panelRek2.setBackground(null);
        panelRek3.setBackground(null);
        panelRek5.setBackground(null);
        panelCan.setBackground(null);
        panelSave.setBackground(null);
        panelTime.setBackground(null);
        panelTimeExamMid.setBackground(null);
        panelTimeExamFinal.setBackground(null);
        groupPan.setBackground(null);
        numPan.setBackground(null);
        typePan.setBackground(null);
        panelDateExamMid.setBackground(null);
        panelTimeExamMidEnd.setBackground(null);
        panelDateExamFinal.setBackground(null);
        panelTimeExamFinalEnd.setBackground(null);
        //towPan.setBackground(null);
        //roomPan.setBackground(null);

        panelHead.setLayout(new BorderLayout());
        panelHead.add(panelBig);
        panelBig.setLayout(new BoxLayout(panelBig, BoxLayout.Y_AXIS));
        panelBig.add(Box.createVerticalStrut(25));

        panelHead.add(addGroup);
        addGroup.setForeground(Config.primaryColor_hard);
        addGroup.setFont(Config.HEADER_SEMIBOLD[1]);
        addGroup.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        panelHead.add(addGroup,BorderLayout.NORTH);

        panelRek1.setPreferredSize(new Dimension((int)(frame.getWidth()),(frame.getHeight() / 4) - 120));
        showGroup = true;
        groupPan.setLayout(new BorderLayout());
        groupPan.add(numGroupLabel,BorderLayout.NORTH);
        groupPan.add(numGroup);
        numGroupLabel.setForeground(Config.primaryColor_base);
        numGroupLabel.setFont(Config.HEADER_SEMIBOLD[2]);
        numGroupLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        numGroup.addFocusListener(this);

        typePan.setLayout(new BorderLayout());
        typePan.add(typeLabel,BorderLayout.NORTH);
        typePan.add(type);
        typeLabel.setForeground(Config.primaryColor_base);
        typeLabel.setFont(Config.HEADER_SEMIBOLD[2]);
        typeLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

        numPan.setLayout(new BorderLayout());
        showStu = true;
        numPan.add(numStuLabel,BorderLayout.NORTH);
        numPan.add(numStu);
        numStuLabel.setForeground(Config.primaryColor_base);
        numStuLabel.setFont(Config.HEADER_SEMIBOLD[2]);
        numStuLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        numStu.addFocusListener(this);

        panelRek1.add(groupPan);
        numGroup.setText("   3");
        numGroup.setFont(innerFont);
        numGroup.setForeground(Color.GRAY);
        numGroup.setPreferredSize(new Dimension((int)(frame.getWidth() / 4),(frame.getHeight() / 4) - 120));

        panelRek1.add(typePan);
        type.setRenderer(new CustomCombobox());
        type.setMaximumRowCount(3);
        type.setFont(Config.NORMAL_REGULAR);
        type.setFont(innerFont);
        type.setPreferredSize(new Dimension((int)(frame.getWidth() / 4),(frame.getHeight() / 4) - 120));

        panelRek1.add(numPan);
        numStu.setText("    200");
        numStu.setFont(innerFont);
        numStu.setForeground(Color.GRAY);
        numStu.setPreferredSize(new Dimension((int)(frame.getWidth() / 4),(frame.getHeight() / 4) - 120));


        panelBig.add(panelRek1);

        panelRek2.setPreferredSize(new Dimension((int)(frame.getWidth()),(int)(frame.getHeight() / 3.5) - 150));
        /*panelTime.setLayout(new BorderLayout());
        panelTime.add(date,BorderLayout.NORTH);
        panelTime.add(time);
            date.setForeground(Config.primaryColor_base);
            date.setFont(Config.HEADER_SEMIBOLD[2]);
            date.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        */

        panelDateExamMid.setLayout(new BorderLayout());
        panelDateExamMid.add(dateExam,BorderLayout.NORTH);
        panelDateExamMid.add(mid);
        dateExam.setForeground(Config.primaryColor_base);
        dateExam.setFont(Config.HEADER_SEMIBOLD[2]);
        dateExam.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

        panelTimeExamMid.setLayout(new BorderLayout());
        panelTimeExamMid.add(timeExam,BorderLayout.NORTH);
        panelTimeExamMid.add(timeMid);
            timeMid.setMaximumRowCount(3);
            timeMid.setFont(Config.NORMAL_REGULAR);
            timeMid.setFont(innerFont);
            timeMid.setPreferredSize(new Dimension((int)(frame.getWidth() / 4),(frame.getHeight() / 4) - 120));
            timeExam.setForeground(Config.primaryColor_base);
            timeExam.setFont(Config.HEADER_SEMIBOLD[2]);
            timeExam.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

        panelTimeExamMidEnd.setLayout(new BorderLayout());
        panelTimeExamMidEnd.add(timeExamEnd,BorderLayout.NORTH);
        panelTimeExamMidEnd.add(timeMidEnd);
        timeMidEnd.setMaximumRowCount(3);
        timeMidEnd.setFont(Config.NORMAL_REGULAR);
        timeMidEnd.setFont(innerFont);
        timeMidEnd.setPreferredSize(new Dimension((int)(frame.getWidth() / 4),(frame.getHeight() / 4) - 120));
        timeExamEnd.setForeground(Config.primaryColor_base);
        timeExamEnd.setFont(Config.HEADER_SEMIBOLD[2]);
        timeExamEnd.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

        panelDateExamFinal.setLayout(new BorderLayout());
        panelDateExamFinal.add(dateExamFinal,BorderLayout.NORTH);
        panelDateExamFinal.add(fi);
        //panelDateExamFinal.setPreferredSize(new Dimension((int)(frame.getWidth() / 4),(frame.getHeight() / 4) - 120));;
            dateExamFinal.setForeground(Config.primaryColor_base);
            dateExamFinal.setFont(Config.HEADER_SEMIBOLD[2]);
            dateExamFinal.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

        panelTimeExamFinal.setLayout(new BorderLayout());
        panelTimeExamFinal.add(timeExamFinal,BorderLayout.NORTH);
        panelTimeExamFinal.add(timeFinal);
        timeFinal.setMaximumRowCount(3);
        timeFinal.setFont(Config.NORMAL_REGULAR);
        timeFinal.setFont(innerFont);
        timeFinal.setPreferredSize(new Dimension((int)(frame.getWidth() / 4),(frame.getHeight() / 4) - 120));
        timeExamFinal.setForeground(Config.primaryColor_base);
        timeExamFinal.setFont(Config.HEADER_SEMIBOLD[2]);
        timeExamFinal.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

        panelTimeExamFinalEnd.setLayout(new BorderLayout());
        panelTimeExamFinalEnd.add(timeExamFinalEnd,BorderLayout.NORTH);
        panelTimeExamFinalEnd.add(timeFinalEnd);
        timeFinalEnd.setMaximumRowCount(3);
        timeFinalEnd.setFont(Config.NORMAL_REGULAR);
        timeFinalEnd.setFont(innerFont);
        timeFinalEnd.setPreferredSize(new Dimension((int)(frame.getWidth() / 4),(frame.getHeight() / 4) - 120));
        timeExamFinalEnd.setForeground(Config.primaryColor_base);
        timeExamFinalEnd.setFont(Config.HEADER_SEMIBOLD[2]);
        timeExamFinalEnd.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

        /*panelRek2.add(panelTime);
        showTime = true;
        time.setText("   จ. 8:00 - 20:00");
        time.setFont(innerFont);
        time.setForeground(Color.GRAY);
        time.setPreferredSize(new Dimension((int)(frame.getWidth() / 4),(frame.getHeight() / 4) - 120));
        time.addFocusListener(this);
        */
        panelRek2.add(panelDateExamMid);
        panelRek2.add(panelTimeExamMid);
        panelRek2.add(panelTimeExamMidEnd);
        showMid = true;
        mid.setText("   2025-01-30");
        mid.setFont(innerFont);
        mid.setForeground(Color.GRAY);
        mid.setPreferredSize(new Dimension((int)(frame.getWidth() / 4),(frame.getHeight() / 4) - 120));
        mid.addFocusListener(this);

        showFi = true;
        fi.setText("   2025-01-30");
        fi.setFont(innerFont);
        fi.setForeground(Color.GRAY);
        fi.setPreferredSize(new Dimension((int)(frame.getWidth() / 4),(frame.getHeight() / 4) - 120));
        fi.addFocusListener(this);

        panelBig.add(panelRek2);

        panelRek3.setPreferredSize(new Dimension((int)(frame.getWidth()),(int)(frame.getHeight() / 3.5) - 120));
        panelRek3.add(panelDateExamFinal);
        panelRek3.add(panelTimeExamFinal);
        panelRek3.add(panelTimeExamFinalEnd);

        panelBig.add(panelRek3);

        panelRek5.add(panelCan);
        panelCan.setLayout( new FlowLayout(FlowLayout.LEFT,93,0));
        cancel.setForeground(Color.BLACK);
        cancel.setBackground(new Color(255,247,237));
        cancel.setFont(Config.HEADER_SEMIBOLD[2]);
        cancel.setPreferredSize(new Dimension((int)((frame.getWidth()-500)/2.7),(frame.getHeight() / 4) - 120));

        panelCan.add(cancel);

        panelRek5.add(panelSave);
        panelSave.setLayout( new FlowLayout(FlowLayout.CENTER,93,0));
        save.setForeground(new Color(255, 247, 237));
        save.setBackground(Config.primaryColor_base);
        save.setFont(Config.HEADER_SEMIBOLD[2]);
        save.setPreferredSize(new Dimension((int)((frame.getWidth()-500)/2.7),(frame.getHeight() / 4) - 120));

        panelSave.add(save);
        cancel.addActionListener(this);
        save.addActionListener(this);
        panelBig.add(panelRek5);


        panelHead.add(panelBig);
        frame.add(panelHead);

        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);
}
//public static void main(String[] args) {
//        new AdminAddGroupClass(Config.createAndShowGUI());
//
//    }
    public void focusGained(FocusEvent fg){
        if (fg.getSource().equals(numGroup) && showGroup){
            numGroup.setText("");
            numGroup.setForeground(Color.BLACK);
            showGroup = false;

        }else if(fg.getSource().equals(numStu) && showStu){
            numStu.setText("");
            numStu.setForeground(Color.BLACK);
            showStu = false;

        }/*else if (fg.getSource().equals(time) && showTime){
            time.setText("");
            time.setForeground(Color.BLACK);
            showTime = false;
        }*/else if (fg.getSource().equals(mid) && showMid) {
            mid.setText("");
            mid.setForeground(Color.BLACK);
            showMid = false;
        }else if (fg.getSource().equals(fi) && showFi) {
            fi.setText("");
            fi.setForeground(Color.BLACK);
            showFi = false;
        }/*else if (fg.getSource().equals(room) && showRoom) {
            room.setText("");
            room.setForeground(Color.BLACK);
            showRoom = false;
        }*/
    }public void focusLost(FocusEvent e){
        if (numGroup.getText().isEmpty()) {
            showGroup = true;
            numGroup.setText("   3");
            numGroup.setForeground(Color.GRAY);
        }

        if(numStu.getText().isEmpty()){
            showStu = true;
            numStu.setText("    200");
            numStu.setForeground(Color.GRAY);
        }

        /*if (time.getText().isEmpty()) {
            showTime = true;
            time.setText("   จ. 8:00 - 20:00");
            time.setForeground(Color.GRAY);

        }*/if (mid.getText().isEmpty()) {
            showMid = true;
            mid.setText("   2025-01-30");
            mid.setForeground(Color.GRAY);
        }if (fi.getText().isEmpty()) {
            showFi = true;
            fi.setText("   2025-01-30");
            fi.setForeground(Color.GRAY);
        }/*if (room.getText().isEmpty()) {
            showRoom = true;
            room.setText("   M22");
            room.setForeground(Color.GRAY);
        }*/
    }
    private RoundedButton yes , no ;
    private JDialog dialog ;

    public void actionPerformed(ActionEvent ev){
        if (ev.getSource() == cancel) {
            if (!(numGroup.getText().equals("   3") && numStu.getText().equals("    200") && /*time.getText().equals("   จ. 8:00 - 20:00") && */mid.getText().equals(("   2025-01-30")) && fi.getText().equals(("   2025-01-30")) /*&& room.getText().equals(("   M22"))*/ )){
                dialog = Config.openFrame((int) (frame.getWidth() / 2), (int) (frame.getHeight() / 2));
                JPanel panelD = new JPanel();
                JPanel panelC = new JPanel();
                JPanel panelButton = new JPanel();
                JPanel panelHeader = new JPanel();
                JPanel panelLayoutButton = new JPanel();
                JPanel panelLayoutlHeader = new JPanel();
                JLabel header = new JLabel("ARE YOU SURE WANT TO CANCEL");
                yes = new RoundedButtonWithColor("YES", 22,Color.WHITE,Config.primaryColor_harder);
                no = new RoundedButtonWithColor("NO", 22,Color.BLACK,new Color(255, 247, 237));

                panelC.setBackground(null);
                panelD.setBackground(null);
                panelHeader.setBackground(null);
                panelButton.setBackground(null);
                panelLayoutButton.setBackground(null);
                panelLayoutlHeader.setBackground(null);

                dialog.setLayout(new BorderLayout());
                panelLayoutlHeader.setLayout(new FlowLayout());
                panelLayoutlHeader.add(header);
                header.setForeground(Config.primaryColor_hard);
                header.setFont(Config.HEADER_SEMIBOLD[1]);
                panelHeader.setLayout(new BoxLayout(panelHeader, BoxLayout.Y_AXIS));
                panelHeader.add(Box.createVerticalStrut(75));
                panelHeader.add(panelLayoutlHeader);
                dialog.add(panelHeader,BorderLayout.NORTH);

                panelD.setLayout(new FlowLayout(FlowLayout.RIGHT, 30, 0));
                yes.setPreferredSize(new Dimension((int) ((frame.getWidth() - 500) / 3.5), (frame.getHeight() / 4) - 120));
                panelD.add(yes);
                yes.addActionListener(this);

                panelC.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 0));
                no.setPreferredSize(new Dimension((int) ((frame.getWidth() - 500) / 3.5), (frame.getHeight() / 4) - 120));
                panelC.add(no);
                no.addActionListener(this);

                panelButton.setLayout(new GridLayout(1, 2));
                panelButton.add(panelC);
                panelButton.add(panelD);
                panelLayoutButton.setLayout(new BoxLayout(panelLayoutButton, BoxLayout.Y_AXIS));
                panelLayoutButton.add(panelButton);
                panelLayoutButton.add(Box.createVerticalStrut(100));
                dialog.add(panelLayoutButton,BorderLayout.SOUTH);

                dialog.setVisible(true);
            }
            else{
                frame.getContentPane().removeAll();
                frame.revalidate();
                frame.repaint();
                new SubjectHomepage(frame);
            }
        }else if (ev.getSource().equals(no)) {
            dialog.setVisible(false);
        }else if (ev.getSource().equals(yes) || ev.getSource().equals(save)){
            if(ev.getSource().equals(save)){
                try {
                    Double.parseDouble(numGroup.getText());
                    Double.parseDouble(numStu.getText());
                    if (numGroup.getText().equals("   3") || numStu.getText().equals("    200") ||/* time.getText().equals("   จ. 8:00 - 20:00") || */mid.getText().equals(("   2025-01-30")) || fi.getText().equals(("   2025-01-30")) || timeMid.getSelectedIndex() > timeMidEnd.getSelectedIndex() || timeFinal.getSelectedIndex() > timeFinalEnd.getSelectedIndex()) {
                        if (timeMid.getSelectedIndex() > timeMidEnd.getSelectedIndex() || timeFinal.getSelectedIndex() > timeFinalEnd.getSelectedIndex()) {
                            new ErrorModal(frame, "กรุณาเลือกเวลาสอบให้ถูกต้อง");
                            return;
                        } else {
                            new ErrorModal(frame, "กรุณากรอกข้อมูลให้ครบถ้วน");
                            return;
                        }
                    } else {
                        try {
                            String[] abc = {"A", "B", "C", "D", "E", "F", "G", "H" };
                            int num = Integer.parseInt(numStu.getText());
                            for (int i = 1; i <= Integer.valueOf(numGroup.getText()); i++) {
                                ResultSet rs = new Database().getQuery("SELECT * FROM section WHERE section_id = '" + type.getCourseCode() + abc[i - 1] + "'");
                                if (rs.next()) {
                                    new ErrorModal(frame, "วิชานี้มีข้อมูลกลุ่มเรียนอยู่แล้ว โปรดเลือกวิชาอื่น");
                                    return;
                                } else {
                                    if (i == Integer.valueOf(numGroup.getText())) {
                                        int db = new Database().postQuery("INSERT INTO section (section_id , course_id, prof_id, day_of_week, start_time, end_time, building, room, max_std, section, prof_name) VALUES ('" + type.getCourseCode() + abc[i - 1] + "', '" + type.getCourseCode() + "', '2555070002', 'MON','','','','','" + num + "', '" + i + "', '');");
                                    } else {
                                        num -= (int) (Double.valueOf(numStu.getText()) / Double.valueOf(numGroup.getText()));
                                        int db = new Database().postQuery("INSERT INTO section (section_id , course_id, prof_id, day_of_week, start_time, end_time, building, room, max_std, section, prof_name) VALUES ('" + type.getCourseCode() + abc[i - 1] + "', '" + type.getCourseCode() + "', '2555070002', 'MON','','','','','" + (int) (Double.valueOf(numStu.getText()) / Double.valueOf(numGroup.getText())) + "', '" + i + "', '');");
                                    }
                                    int db = new Database().postQuery("INSERT INTO exam (section_id , course_id, midterm_date, midterm_start_time, midterm_end_time, final_date, final_start_time, final_end_time, subject, type, room, prof_name, section) VALUES ('" + type.getCourseCode() + abc[i - 1] + "', '" + type.getCourseCode() + "', '" + mid.getText() + "', '" + timeMid.getSelectedItem() + "','" + timeMidEnd.getSelectedItem() + "','" + fi.getText() + "','" + timeFinal.getSelectedItem() + "','" + timeFinalEnd.getSelectedItem() + "','" + type.getCourseName() + "', 'ทฤษฎี', '', '', '" + i + "');");
                                }
                            }
                            int db = new Database().postQuery("UPDATE exam SET midterm_date = '" + mid.getText() + "', midterm_start_time = '" + timeMid.getSelectedItem() + "', midterm_end_time = '" + timeMidEnd.getSelectedItem() + "', final_date ='" + fi.getText() + "', final_start_time = '" + timeFinal.getSelectedItem() + "', final_end_time = '" + timeFinalEnd.getSelectedItem() + "' WHERE course_id = '" + type.getCourseCode() + "';");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }catch (Exception e){
                    new ErrorModal(frame, "กรุณากรอกกลุ่มเรียนหรือจำนวนนักศึกษาให้ถูกต้อง");
                    return;
                }
            }
            frame.getContentPane().removeAll();
            frame.revalidate();
            frame.repaint();
            new SubjectHomepage (frame);

            if (ev.getSource().equals(yes)) {
                dialog.setVisible(false);
            }
        }
    }
}
