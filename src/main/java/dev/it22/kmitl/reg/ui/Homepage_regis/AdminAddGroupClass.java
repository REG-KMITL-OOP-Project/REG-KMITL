package dev.it22.kmitl.reg.ui.Homepage_regis;

import dev.it22.kmitl.reg.utils.Config;
import dev.it22.kmitl.reg.utils.CustomCombobox;
import dev.it22.kmitl.reg.utils.RoundedButton;
import dev.it22.kmitl.reg.utils.RoundedTextField;

import javax.swing.*;
import java.awt.*;

public class AdminAddGroupClass {
    private JFrame frame ;
    private JPanel panelBig,panelRek1,panelRek2,panelRek3,panelRek4,panelRek5,panelHead,panelSpecial;
    private JLabel addGroup,date,timeExam;
    private RoundedTextField numGroup,time,mid,fi,room,numStu;
    private JComboBox type,tow;
    private Font innerFont, regularFont;
    private RoundedButton cancel,save;
    private JPanel panelSave = new JPanel() , panelCan = new JPanel();

    public AdminAddGroupClass(JFrame frame){
        this.frame = frame;
        panelBig = new JPanel();
        panelHead = new JPanel();
        panelRek1 = new JPanel();
        panelRek2 = new JPanel();
        panelRek3 = new JPanel();
        panelRek4 = new JPanel();
        panelRek5 = new JPanel();
        panelSpecial = new JPanel();
        addGroup = new JLabel("              เพิ่มกลุ่มเรียน");
        date = new JLabel("วัน-เวลาเรียน");
        timeExam = new JLabel("วัน-เวลาสอบ");
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
        panelRek4.setBackground(null);
        panelRek5.setBackground(null);
        panelSpecial.setBackground(null);
        panelCan.setBackground(null);
        panelSave.setBackground(null);

        panelHead.setLayout( new BorderLayout());
        panelHead.add(panelBig);
        panelBig.setLayout(new BoxLayout(panelBig, BoxLayout.Y_AXIS));
        panelBig.add(Box.createVerticalStrut(10));

        panelHead.add(addGroup);
        addGroup.setForeground(Config.primaryColor_hard);
        addGroup.setFont(Config.HEADER_SEMIBOLD[1]);
        addGroup.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        panelHead.add(addGroup,BorderLayout.NORTH);

        panelRek1.add(numGroup);
        //showYear = true;
        numGroup.setText("   จำนวนกลุ่มเรียน");
        numGroup.setFont(innerFont);
        numGroup.setForeground(Color.GRAY);
        numGroup.setPreferredSize(new Dimension((int)(frame.getWidth() / 4),(frame.getHeight() / 4) - 120));

        panelRek1.add(type);
        type.addItem("กลุ่มเรียนที่");
        type.addItem("1");
        type.addItem("2");
        type.addItem("3");
        type.setRenderer(new CustomCombobox());
        type.setMaximumRowCount(3);
        type.setFont(Config.NORMAL_REGULAR);
        type.setFont(innerFont);
        type.setPreferredSize(new Dimension((int)(frame.getWidth() / 4),(frame.getHeight() / 4) - 120));

        panelBig.add(panelRek1);

        panelSpecial.add(date);
            date.setForeground(Color.GRAY);
            date.setFont(Config.HEADER_SEMIBOLD[2]);
            date.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

        panelSpecial.add(timeExam);
            timeExam.setForeground(Color.GRAY);
            timeExam.setFont(Config.HEADER_SEMIBOLD[2]);
            timeExam.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

        panelBig.add(panelSpecial);

        panelRek2.add(time);
        time.setText("   จ. 8:00 - 20:00");
        time.setFont(innerFont);
        time.setForeground(Color.GRAY);
        time.setPreferredSize(new Dimension((int)(frame.getWidth() / 4),(frame.getHeight() / 4) - 120));

        panelRek2.add(mid);
        mid.setText("   Midterm");
        mid.setFont(innerFont);
        mid.setForeground(Color.GRAY);
        mid.setPreferredSize(new Dimension((int)(frame.getWidth() / 4),(frame.getHeight() / 4) - 120));

        panelRek2.add(fi);
        fi.setText("   Final");
        fi.setFont(innerFont);
        fi.setForeground(Color.GRAY);
        fi.setPreferredSize(new Dimension((int)(frame.getWidth() / 4),(frame.getHeight() / 4) - 120));

        panelBig.add(panelRek2);

        panelRek3.add(tow);
        tow.addItem("อาคารเรียน");
        tow.addItem("IT");
        tow.addItem("อาคารพระเทพ");
        tow.addItem("คณะบริหาร");
        tow.setRenderer(new CustomCombobox());
        tow.setMaximumRowCount(3);
        tow.setFont(Config.NORMAL_REGULAR);
        tow.setFont(innerFont);
        tow.setPreferredSize(new Dimension((int)(frame.getWidth() / 4),(frame.getHeight() / 4) - 120));

        panelRek3.add(room);
        room.setText("   ห้องเรียน");
        room.setFont(innerFont);
        room.setForeground(Color.GRAY);
        room.setPreferredSize(new Dimension((int)(frame.getWidth() / 4),(frame.getHeight() / 4) - 120));

        panelBig.add(panelRek3);

        panelHead.add(panelBig);
        frame.add(panelHead);

        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);
}public static void main(String[] args) {
        new AdminAddGroupClass(Config.createAndShowGUI());
    }
}
