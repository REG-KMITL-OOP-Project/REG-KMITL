package dev.it22.kmitl.reg.ui.Class_Management;

import dev.it22.kmitl.reg.utils.*;
import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class AdminAddClassroom implements FocusListener, ActionListener {
    private JFrame frame ;
    private JPanel panelBig,panelRek1,panelRek2,panelRek3,panelRek5,panelHead,panelRek22,panelPela,panelPela1,panelRek33;
    private JLabel addGroup;
    private RoundedTextField subjectName,subjectCode,teacherName;
    private JComboBox group,type;
    private Font innerFont, regularFont;
    private RoundedButtonWithColor cancel,save,add;
    private JPanel panelSave = new JPanel() , panelCan = new JPanel();
    protected boolean showName, showCode, showTeacher;
    private teacherNameTable table;
    private String [] nameCher ;

    public AdminAddClassroom(JFrame frame){
        this.frame = frame;
        panelBig = new JPanel();
        panelHead = new JPanel();
        panelRek1 = new JPanel();
        panelRek2 = new JPanel();
        panelRek3 = new JPanel();
        panelRek5 = new JPanel();
        panelRek22 = new JPanel();
        panelPela = new JPanel();
        panelPela1 = new JPanel();
        panelRek33 = new JPanel();
        addGroup = new JLabel("              สร้างห้องเรียน");
        subjectName = new RoundedTextField(22);
        teacherName = new RoundedTextField(22);
        subjectCode = new RoundedTextField(22);
        cancel = new RoundedButtonWithColor ("CANCEL" ,22,Color.BLACK,new Color(255,247,237));
        save = new RoundedButtonWithColor("SAVE" ,22,new Color(255, 247, 237),Config.primaryColor_base);
        add = new RoundedButtonWithColor("ADD" ,22,new Color(255, 247, 237),Config.primaryColor_base);
        group = new JComboBox();
        type = new JComboBox();
        nameCher = new String[5];
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
        panelRek22.setBackground(null);
        panelPela.setBackground(null);
        panelPela1.setBackground(null);
        panelRek33.setBackground(null);
        panelHead.setLayout(new BorderLayout());
        panelHead.add(panelBig);
        panelBig.setLayout(new BoxLayout(panelBig, BoxLayout.Y_AXIS));
        panelBig.add(Box.createVerticalStrut(25));

        panelHead.add(addGroup);
        addGroup.setForeground(Config.primaryColor_hard);
        addGroup.setFont(Config.HEADER_SEMIBOLD[1]);
        addGroup.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        panelHead.add(addGroup,BorderLayout.NORTH);

        panelRek1.add(subjectName);
        showName = true;
        subjectName.setText("   ชื่อวิชา");
        subjectName.setFont(innerFont);
        subjectName.setForeground(Color.GRAY);
        subjectName.setPreferredSize(new Dimension((int)(frame.getWidth() / 2.3),(frame.getHeight() / 4) - 120));
        subjectName.addFocusListener(this);

        panelRek1.add(subjectCode);
        showCode = true;
        subjectCode.setText("   รหัสวิชา");
        subjectCode.setFont(innerFont);
        subjectCode.setForeground(Color.GRAY);
        subjectCode.setPreferredSize(new Dimension((int)(frame.getWidth() / 3.5),(frame.getHeight() / 4) - 120));
        subjectCode.addFocusListener(this);

        panelBig.add(panelRek1);

        panelRek2.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelRek2.add(panelRek22);
        panelRek22.setPreferredSize(new Dimension((int)(frame.getWidth() / 8),(frame.getHeight() / 4) - 120));
        panelRek2.add(group);
        group.addItem("กลุ่มเรียนที่");
        group.addItem("1");
        group.addItem("2");
        group.addItem("3");
        group.setRenderer(new CustomCombobox());
        group.setMaximumRowCount(3);
        group.setFont(Config.NORMAL_REGULAR);
        group.setFont(innerFont);
        group.setPreferredSize(new Dimension((int)(frame.getWidth() / 5),(frame.getHeight() / 4) - 120));

        panelRek2.add(panelPela);
        panelPela.setPreferredSize(new Dimension((int)(frame.getWidth() / 16),(frame.getHeight() / 4) - 120));

        panelRek2.add(type);
        type.addItem("ประเภท");
        type.addItem("ทฤษฏี");
        type.addItem("ปฏิบัติ");
        type.setRenderer(new CustomCombobox());
        type.setMaximumRowCount(3);
        type.setFont(Config.NORMAL_REGULAR);
        type.setFont(innerFont);
        type.setPreferredSize(new Dimension((int)(frame.getWidth() / 5),(frame.getHeight() / 4) - 120));

        panelBig.add(panelRek2);

        panelRek3.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelRek3.add(panelRek33);
        panelRek33.setPreferredSize(new Dimension((int)(frame.getWidth() / 8),(frame.getHeight() / 4) - 120));
        panelRek3.add(teacherName);
        showTeacher = true;
        teacherName.setText("   เพิ่มชื่อผู้สอน");
        teacherName.setFont(innerFont);
        teacherName.setForeground(Color.GRAY);
        teacherName.setPreferredSize(new Dimension((int)(frame.getWidth() / 2),(frame.getHeight() / 4) - 120));
        teacherName.addFocusListener(this);
        panelRek3.add(panelPela1);
        panelPela1.setPreferredSize(new Dimension((int)(frame.getWidth() / 10.5),(frame.getHeight() / 4) - 120));

        panelRek3.add(add);
        add.setPreferredSize(new Dimension((int)((frame.getWidth()-500)/5),(frame.getHeight() / 4) - 120));
        panelBig.add(panelRek3);
        add.addActionListener(this);

        table = new teacherNameTable();
        panelBig.add(table);

        panelRek5.add(panelCan);
        panelCan.setLayout( new FlowLayout(FlowLayout.LEFT,93,0));
        cancel.setPreferredSize(new Dimension((int)((frame.getWidth()-500)/2.7),(frame.getHeight() / 4) - 120));

        panelCan.add(cancel);

        panelRek5.add(panelSave);
        panelSave.setLayout( new FlowLayout(FlowLayout.CENTER,93,0));
        save.setPreferredSize(new Dimension((int)((frame.getWidth()-500)/2.7),(frame.getHeight() / 4) - 120));

        panelSave.add(save);
        save.addActionListener(this);
        cancel.addActionListener(this);

        panelBig.add(panelRek5);
        panelHead.add(panelBig);

        frame.add(panelHead);

        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }public static void main(String[] args) {
        new AdminAddClassroom(Config.createAndShowGUI());
    }
    @Override
    public void focusGained(FocusEvent fg){
        if (fg.getSource().equals(subjectName) && showName){
            subjectName.setText("");
            subjectName.setForeground(Color.BLACK);
            showName = false;

        }else if(fg.getSource().equals(subjectCode) && showCode){
            subjectCode.setText("");
            subjectCode.setForeground(Color.BLACK);
            showCode = false;

        }else if (fg.getSource().equals(teacherName) && showTeacher) {
            teacherName.setText("");
            teacherName.setForeground(Color.BLACK);
            showTeacher = false;
        }
    }@Override
    public void focusLost(FocusEvent e){
        if (subjectName.getText().isEmpty()) {
            showName = true;
            subjectName.setText("   ชื่อวิชา");
            subjectName.setForeground(Color.GRAY);
        }
        if(subjectCode.getText().isEmpty()){
            showCode = true;
            subjectCode.setText("   รหัสวิชา");
            subjectCode.setForeground(Color.GRAY);
        }
        if (teacherName.getText().isEmpty()) {
            showTeacher = true;
            teacherName.setText("   เพิ่มชื่อผู้สอน");
            teacherName.setForeground(Color.GRAY);
        }
    }
    int index = 0;
    private RoundedButton yes , no ;
    private JDialog dialog ;

    @Override
    public void actionPerformed(ActionEvent ev) {
        if (ev.getSource().equals(add)){
            if (!showTeacher) {
                if (index < 5){
                    table.getName_table().getModel().setValueAt(teacherName.getText(), index, 0);
                    nameCher[index] = teacherName.getText();
                    index++ ;
                    showTeacher = true;
                    teacherName.setText("   เพิ่มชื่อผู้สอน");
                    teacherName.setForeground(Color.GRAY);
                }
            }
        }
        if (ev.getSource() == cancel) {
            if (!(subjectName.getText().equals("   ชื่อวิชา") && subjectCode.getText().equals("   รหัสวิชา") )){
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
                new create_class(frame);
            }
        }else if (ev.getSource().equals(no)) {
            dialog.setVisible(false);
        }else if (ev.getSource().equals(yes) || ev.getSource().equals(save)){
            if(ev.getSource().equals(save)){
                if (subjectName.getText().equals("   ชื่อวิชา") && subjectCode.getText().equals("   รหัสวิชา") ) {
                    new ErrorModal(frame, "กรุณากรอกข้อมูลให้ครบถ้วน");
                    return;
                }
            }
            frame.getContentPane().removeAll();
            frame.revalidate();
            frame.repaint();
            new create_class (frame);
            if (ev.getSource().equals(yes)) {
                dialog.setVisible(false);
            }
        }
    }
}
