package dev.it22.kmitl.reg.ui.Class_Management;

import dev.it22.kmitl.reg.utils.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminAddGroupClass implements FocusListener , ActionListener {
    private JFrame frame ;
    private JPanel panelBig,panelRek1,panelRek2,panelRek3,panelRek5,panelHead,panelTime,panelTimeExamMid,panelTimeExamFinal,groupPan,numPan,typePan,towPan,roomPan;
    private JLabel numGroupLabel,numStuLabel,typeLabel,addGroup,date,timeExam,timeExamFinal,towLabel,roomLabel;
    private RoundedTextField numGroup,numStu,time,mid,fi,room;
    private JComboBox type,tow;
    private Font innerFont, regularFont;
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
        numGroupLabel = new JLabel("จำนวนกลุ่มเรียน");
        numStuLabel = new JLabel("จำนวนนักศึกษาที่รับ");
        typeLabel = new JLabel("กลุ่มเรียนที่");
        addGroup = new JLabel("              เพิ่มกลุ่มเรียน");
        date = new JLabel("วัน-เวลาเรียน");
        timeExam = new JLabel("วัน-เวลาสอบกลางภาค");
        timeExamFinal = new JLabel("วัน-เวลาสอบปลายภาค");
        towLabel = new JLabel("อาคารเรียน");
        roomLabel = new JLabel("ห้องเรียน");
        numGroup = new RoundedTextField(22);
        time = new RoundedTextField(22);
        mid = new RoundedTextField(22);
        fi = new RoundedTextField(22);
        room = new RoundedTextField(22);
        numStu = new RoundedTextField(22);
        cancel = new RoundedButton("CANCEL" ,22);
        save = new RoundedButton("SAVE" ,22);
        type = new JComboBox();
        tow = new JComboBox();
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
        towPan.setBackground(null);
        roomPan.setBackground(null);

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
        type.addItem("1");
        type.addItem("2");
        type.addItem("3");
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
        panelTime.setLayout(new BorderLayout());
        panelTime.add(date,BorderLayout.NORTH);
        panelTime.add(time);
            date.setForeground(Config.primaryColor_base);
            date.setFont(Config.HEADER_SEMIBOLD[2]);
            date.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

        panelTimeExamMid.setLayout(new BorderLayout());
        panelTimeExamMid.add(timeExam,BorderLayout.NORTH);
        panelTimeExamMid.add(mid);
            timeExam.setForeground(Config.primaryColor_base);
            timeExam.setFont(Config.HEADER_SEMIBOLD[2]);
            timeExam.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

        panelTimeExamFinal.setLayout(new BorderLayout());
        panelTimeExamFinal.add(timeExamFinal,BorderLayout.NORTH);
        panelTimeExamFinal.add(fi);
            timeExamFinal.setForeground(Config.primaryColor_base);
            timeExamFinal.setFont(Config.HEADER_SEMIBOLD[2]);
            timeExamFinal.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

        panelRek2.add(panelTime);
        showTime = true;
        time.setText("   จ. 8:00 - 20:00");
        time.setFont(innerFont);
        time.setForeground(Color.GRAY);
        time.setPreferredSize(new Dimension((int)(frame.getWidth() / 4),(frame.getHeight() / 4) - 120));
        time.addFocusListener(this);

        panelRek2.add(panelTimeExamMid);
        showMid = true;
        mid.setText("   จ. 9:00 - 12:00");
        mid.setFont(innerFont);
        mid.setForeground(Color.GRAY);
        mid.setPreferredSize(new Dimension((int)(frame.getWidth() / 4),(frame.getHeight() / 4) - 120));
        mid.addFocusListener(this);

        panelRek2.add(panelTimeExamFinal);
        showFi = true;
        fi.setText("   จ. 9:00 - 12:00");
        fi.setFont(innerFont);
        fi.setForeground(Color.GRAY);
        fi.setPreferredSize(new Dimension((int)(frame.getWidth() / 4),(frame.getHeight() / 4) - 120));
        fi.addFocusListener(this);

        panelBig.add(panelRek2);

        panelRek3.setPreferredSize(new Dimension((int)(frame.getWidth()),(int)(frame.getHeight() / 3.5) - 120));
        towPan.setLayout(new BorderLayout());
        towPan.add(towLabel,BorderLayout.NORTH);
        towPan.add(tow);
        towLabel.setForeground(Config.primaryColor_base);
        towLabel.setFont(Config.HEADER_SEMIBOLD[2]);
        towLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

        roomPan.setLayout(new BorderLayout());
        roomPan.add(roomLabel,BorderLayout.NORTH);
        roomPan.add(room);
        roomLabel.setForeground(Config.primaryColor_base);
        roomLabel.setFont(Config.HEADER_SEMIBOLD[2]);
        roomLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

        panelRek3.add(towPan);
        tow.addItem("IT");
        tow.addItem("อาคารพระเทพ");
        tow.addItem("คณะบริหาร");
        tow.setRenderer(new CustomCombobox());
        tow.setMaximumRowCount(3);
        tow.setFont(Config.NORMAL_REGULAR);
        tow.setFont(innerFont);
        tow.setPreferredSize(new Dimension((int)(frame.getWidth() / 2.5),(frame.getHeight() / 4) - 120));

        panelRek3.add(roomPan);
        showRoom = true;
        room.setText("   M22");
        room.setFont(innerFont);
        room.setForeground(Color.GRAY);
        room.setPreferredSize(new Dimension((int)(frame.getWidth() / 2.8),(frame.getHeight() / 4) - 120));
        room.addFocusListener(this);

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
}public static void main(String[] args) {
        new AdminAddGroupClass(Config.createAndShowGUI());
    }
    public void focusGained(FocusEvent fg){
        if (fg.getSource().equals(numGroup) && showGroup){
            numGroup.setText("");
            numGroup.setForeground(Color.BLACK);
            showGroup = false;

        }else if(fg.getSource().equals(numStu) && showStu){
            numStu.setText("");
            numStu.setForeground(Color.BLACK);
            showStu = false;

        }else if (fg.getSource().equals(time) && showTime){
            time.setText("");
            time.setForeground(Color.BLACK);
            showTime = false;

        }else if (fg.getSource().equals(mid) && showMid) {
            mid.setText("");
            mid.setForeground(Color.BLACK);
            showMid = false;
        }else if (fg.getSource().equals(fi) && showFi) {
            fi.setText("");
            fi.setForeground(Color.BLACK);
            showFi = false;
        }else if (fg.getSource().equals(room) && showRoom) {
            room.setText("");
            room.setForeground(Color.BLACK);
            showRoom = false;
        }
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

        if (time.getText().isEmpty()) {
            showTime = true;
            time.setText("   จ. 8:00 - 20:00");
            time.setForeground(Color.GRAY);

        }if (mid.getText().isEmpty()) {
            showMid = true;
            mid.setText("   จ. 9:00 - 12:00");
            mid.setForeground(Color.GRAY);
        }if (fi.getText().isEmpty()) {
            showFi = true;
            fi.setText("   จ. 9:00 - 12:00");
            fi.setForeground(Color.GRAY);
        }if (room.getText().isEmpty()) {
            showRoom = true;
            room.setText("   M22");
            room.setForeground(Color.GRAY);
        }
    }
    private RoundedButton yes , no ;
    private JDialog dialog ;

    public void actionPerformed(ActionEvent ev){
        if (ev.getSource() == cancel) {
            if (!(numGroup.getText().equals("   3") && numStu.getText().equals("    200") && time.getText().equals("   จ. 8:00 - 20:00") && mid.getText().equals(("   จ. 9:00 - 12:00")) && fi.getText().equals(("   จ. 9:00 - 12:00")) && room.getText().equals(("   M22")) )){
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
                if (numGroup.getText().equals("   3") && numStu.getText().equals("    200") && time.getText().equals("   จ. 8:00 - 20:00") && mid.getText().equals(("   จ. 9:00 - 12:00")) && fi.getText().equals(("   จ. 9:00 - 12:00")) && room.getText().equals(("   M22")) ) {
                    new ErrorModal(frame, "กรุณากรอกข้อมูลให้ครบถ้วน");
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
