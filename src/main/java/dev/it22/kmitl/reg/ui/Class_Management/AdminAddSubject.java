
package dev.it22.kmitl.reg.ui.Class_Management;
import dev.it22.kmitl.reg.utils.Config;
import dev.it22.kmitl.reg.utils.CustomCombobox;
import dev.it22.kmitl.reg.utils.RoundedButton;
import dev.it22.kmitl.reg.utils.RoundedTextField;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminAddSubject implements FocusListener {
    private JFrame frame ;
    private JPanel panelBig,panelRek1,panelRek2,panelRek3,panelRek4,panelRek5,panelHead,panelYear,panelType,panelKit,panelGroup,panelBranch,panelCode,panelName,panelTeacher,panelNote,panelCondition,panelPela;
    private JLabel addSubject,yearLabel,typeLabel,kitLabel,groupLabel,branchLabel,codeLabel,nameLabel,teacherLabel,noteLabel,conditionLabel;
    private RoundedTextField year,code,name,teacher,note,condition;
    private JComboBox type,kit,group,branch;
    private Font innerFont, regularFont;
    private RoundedButton cancel,save;
    private JPanel panelSave = new JPanel() , panelCan = new JPanel();
    protected boolean showYear, showCode, showName, showTeacher,showNote,showCondition;

    public AdminAddSubject(JFrame frame){
        this.frame = frame;
        panelBig = new JPanel();
        panelHead = new JPanel();
        panelRek1 = new JPanel();
        panelRek2 = new JPanel();
        panelRek3 = new JPanel();
        panelRek4 = new JPanel();
        panelRek5 = new JPanel();
        panelYear = new JPanel();
        panelType = new JPanel();
        panelKit = new JPanel();
        panelGroup = new JPanel();
        panelBranch = new JPanel();
        panelCode = new JPanel();
        panelName = new JPanel();
        panelTeacher = new JPanel();
        panelNote = new JPanel();
        panelCondition = new JPanel();
        panelPela = new JPanel();
        addSubject = new JLabel("              เพิ่มวิชาเรียน");
        yearLabel = new JLabel("ภาคการศึกษา");
        typeLabel = new JLabel("ประเภท");
        kitLabel = new JLabel("หน่วยกิต");
        groupLabel = new JLabel("คณะ");
        branchLabel = new JLabel("สาขา");
        codeLabel = new JLabel("รหัสวิชา");
        nameLabel = new JLabel("ชื่อวิชา");
        teacherLabel = new JLabel("อาจารย์ผู้สอน");
        noteLabel = new JLabel("หมายเหตุ");
        conditionLabel = new JLabel("เงื่อนไข");
        year = new RoundedTextField(22);
        note = new RoundedTextField(22);
        code = new RoundedTextField(22);
        name = new RoundedTextField(22);
        teacher = new RoundedTextField(22);
        condition = new RoundedTextField(22);
        cancel = new RoundedButton("CANCEL" ,22);
        save = new RoundedButton("SAVE" ,22);
        type = new JComboBox();
        kit = new JComboBox();
        group = new JComboBox();
        branch = new JComboBox();
        regularFont = Config.NORMAL_REGULAR;
        innerFont = regularFont.deriveFont(15f);

        panelBig.setBackground(null);
        panelHead.setBackground(null);
        panelRek1.setBackground(null);
        panelRek2.setBackground(null);
        panelRek3.setBackground(null);
        panelRek4.setBackground(null);
        panelRek5.setBackground(null);
        panelCan.setBackground(null);
        panelSave.setBackground(null);
        panelYear.setBackground(null);
        panelType.setBackground(null);
        panelKit.setBackground(null);
        panelGroup.setBackground(null);
        panelBranch.setBackground(null);
        panelCode.setBackground(null);
        panelName.setBackground(null);
        panelTeacher.setBackground(null);
        panelNote.setBackground(null);
        panelCondition.setBackground(null);
        panelPela.setBackground(null);

        panelHead.setLayout( new BorderLayout());
        panelHead.add(panelBig);
        panelBig.setLayout(new BoxLayout(panelBig, BoxLayout.Y_AXIS));
        panelBig.add(Box.createVerticalStrut(10));

        addSubject.setForeground(Config.primaryColor_hard);
        addSubject.setFont(Config.HEADER_SEMIBOLD[1]);
        addSubject.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        panelHead.add(addSubject,BorderLayout.NORTH);

        panelRek1.setPreferredSize(new Dimension((int)(frame.getWidth()),(frame.getHeight() / 4) - 100));
        panelYear.setLayout(new BorderLayout());
        panelYear.add(yearLabel,BorderLayout.NORTH);
        panelYear.add(year);
        yearLabel.setForeground(Config.primaryColor_base);
        yearLabel.setFont(Config.HEADER_SEMIBOLD[2]);

        panelType.setLayout(new BorderLayout());
        panelType.add(typeLabel,BorderLayout.NORTH);
        panelType.add(type);
        typeLabel.setForeground(Config.primaryColor_base);
        typeLabel.setFont(Config.HEADER_SEMIBOLD[2]);

        panelKit.setLayout(new BorderLayout());
        panelKit.add(kitLabel,BorderLayout.NORTH);
        panelKit.add(kit);
        kitLabel.setForeground(Config.primaryColor_base);
        kitLabel.setFont(Config.HEADER_SEMIBOLD[2]);

        panelRek1.add(panelYear);
        showYear = true;
        year.setText("   25xx");
        year.setFont(innerFont);
        year.setForeground(Color.GRAY);
        year.setPreferredSize(new Dimension((int)(frame.getWidth() / 4),(frame.getHeight() / 4) - 120));
        year.addFocusListener(this);

        panelRek1.add(panelType);
        type.addItem("ทฤษฏี");
        type.addItem("ปฏิบัติ");
        type.setRenderer(new CustomCombobox());
        type.setMaximumRowCount(3);
        type.setFont(Config.NORMAL_REGULAR);
        type.setFont(innerFont);
        type.setPreferredSize(new Dimension((int)(frame.getWidth() / 4),(frame.getHeight() / 4) - 120));

        panelRek1.add(panelKit);
        kit.addItem("1");
        kit.addItem("2");
        kit.addItem("3");
        kit.setRenderer(new CustomCombobox());
        kit.setMaximumRowCount(3);
        kit.setFont(Config.NORMAL_REGULAR);
        kit.setFont(innerFont);
        kit.setPreferredSize(new Dimension((int)(frame.getWidth() / 4),(frame.getHeight() / 4) - 120));

        panelBig.add(panelRek1);

        panelRek2.setPreferredSize(new Dimension((int)(frame.getWidth()),(frame.getHeight() / 4) - 100));
        panelGroup.setLayout(new BorderLayout());
        panelGroup.add(groupLabel,BorderLayout.NORTH);
        panelGroup.add(group);
        groupLabel.setForeground(Config.primaryColor_base);
        groupLabel.setFont(Config.HEADER_SEMIBOLD[2]);

        panelBranch.setLayout(new BorderLayout());
        panelBranch.add(branchLabel,BorderLayout.NORTH);
        panelBranch.add(branch);
        branchLabel.setForeground(Config.primaryColor_base);
        branchLabel.setFont(Config.HEADER_SEMIBOLD[2]);

        panelCode.setLayout(new BorderLayout());
        panelCode.add(codeLabel,BorderLayout.NORTH);
        panelCode.add(code);
        codeLabel.setForeground(Config.primaryColor_base);
        codeLabel.setFont(Config.HEADER_SEMIBOLD[2]);

        panelRek2.add(panelGroup);
        group.addItem("เทคโนโลยีสารสนเทศ");
        group.addItem("บริหารธุรกิจ");
        group.setRenderer(new CustomCombobox());
        group.setMaximumRowCount(3);
        group.setFont(Config.NORMAL_REGULAR);
        group.setFont(innerFont);
        group.setPreferredSize(new Dimension((int)(frame.getWidth() / 4),(frame.getHeight() / 4) - 120));

        panelRek2.add(panelBranch);
        branch.addItem("เทคโนโลยีสารสนเทศ");
        branch.addItem("วิทยาการข้อมูลและการวิเคราะห์เชิงธุรกิจ");
        branch.addItem("เทคโนโลยีปัญญาประดิษฐ์");
        branch.setRenderer(new CustomCombobox());
        branch.setMaximumRowCount(3);
        branch.setFont(Config.NORMAL_REGULAR);
        branch.setFont(innerFont);
        branch.setPreferredSize(new Dimension((int)(frame.getWidth() / 4),(frame.getHeight() / 4) - 120));

        panelRek2.add(panelCode);
        showCode = true;
        code.setText("   06xxxxxx");
        code.setFont(innerFont);
        code.setForeground(Color.GRAY);
        code.setPreferredSize(new Dimension((int)(frame.getWidth() / 4),(frame.getHeight() / 4) - 120));
        code.addFocusListener(this);

        panelBig.add(panelRek2);

        panelRek3.setPreferredSize(new Dimension((int)(frame.getWidth()),(frame.getHeight() / 4) - 100));
        panelName.setLayout(new BorderLayout());
        panelName.add(nameLabel,BorderLayout.NORTH);
        panelName.add(name);
        nameLabel.setForeground(Config.primaryColor_base);
        nameLabel.setFont(Config.HEADER_SEMIBOLD[2]);

        panelTeacher.setLayout(new BorderLayout());
        panelTeacher.add(teacherLabel,BorderLayout.NORTH);
        panelTeacher.add(teacher);
        teacherLabel.setForeground(Config.primaryColor_base);
        teacherLabel.setFont(Config.HEADER_SEMIBOLD[2]);

        panelRek3.add(panelName);
        showName = true;
        name.setText("   OOP");
        name.setFont(innerFont);
        name.setForeground(Color.GRAY);
        name.setPreferredSize(new Dimension((int)(frame.getWidth() / 2.65),(frame.getHeight() / 4) - 120));
        name.addFocusListener(this);

        panelRek3.add(panelTeacher);
        showTeacher = true;
        teacher.setText("  ธราวิเชษฐ์");
        teacher.setFont(innerFont);
        teacher.setForeground(Color.GRAY);
        teacher.setPreferredSize(new Dimension((int)(frame.getWidth() / 2.65),(frame.getHeight() / 4) - 120));
        teacher.addFocusListener(this);

        panelBig.add(panelRek3);

        panelRek4.setPreferredSize(new Dimension((int)(frame.getWidth()),(frame.getHeight() / 4) - 100));
        panelNote.setLayout(new BorderLayout());
        panelNote.add(noteLabel,BorderLayout.NORTH);
        panelNote.add(note);
        noteLabel.setForeground(Config.primaryColor_base);
        noteLabel.setFont(Config.HEADER_SEMIBOLD[2]);

        panelCondition.setLayout(new BorderLayout());
        panelCondition.add(conditionLabel,BorderLayout.NORTH);
        panelCondition.add(condition);
        conditionLabel.setForeground(Config.primaryColor_base);
        conditionLabel.setFont(Config.HEADER_SEMIBOLD[2]);

        panelRek4.add(panelNote);
        showNote = true;
        note.setText("   รายวิชา หลักสูตร พ.ศ.2560 : สำหรับนักศึกษาเก็บตก");
        note.setFont(innerFont);
        note.setForeground(Color.GRAY);
        note.setPreferredSize(new Dimension((int)(frame.getWidth() / 2.65),(frame.getHeight() / 4) - 120));
        note.addFocusListener(this);

        panelRek4.add(panelCondition);
        showCondition = true;
        condition.setText("   รับเฉพาะนักศึกษาคณะไอที");
        condition.setFont(innerFont);
        condition.setForeground(Color.GRAY);
        condition.setPreferredSize(new Dimension((int)(frame.getWidth() / 2.65),(frame.getHeight() / 4) - 120));
        condition.addFocusListener(this);

        panelBig.add(panelRek4);

        panelRek5.setPreferredSize(new Dimension((int)(frame.getWidth()),(frame.getHeight() / 4) - 120));
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

        panelBig.add(panelRek5);

        panelHead.add(panelBig);
        frame.add(panelHead);

        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    } public static void main(String[] args) {
        new AdminAddSubject(Config.createAndShowGUI());
    }
    public void focusGained(FocusEvent fg){
        if (fg.getSource().equals(year) && showYear){
            year.setText("");
            year.setForeground(Color.BLACK);
            showYear = false;

        }else if(fg.getSource().equals(code) && showCode){
            code.setText("");
            code.setForeground(Color.BLACK);
            showCode = false;

        }else if (fg.getSource().equals(name) && showName){
            name.setText("");
            name.setForeground(Color.BLACK);
            showName = false;

        }else if (fg.getSource().equals(teacher) && showTeacher) {
            teacher.setText("");
            teacher.setForeground(Color.BLACK);
            showTeacher = false;
        }else if (fg.getSource().equals(note) && showNote) {
            note.setText("");
            note.setForeground(Color.BLACK);
            showNote = false;
        }else if (fg.getSource().equals(condition) && showCondition) {
            condition.setText("");
            condition.setForeground(Color.BLACK);
            showCondition = false;
        }
    }public void focusLost(FocusEvent e){
        if (year.getText().isEmpty()) {
            showYear = true;
            year.setText("   25xx");
            year.setForeground(Color.GRAY);
        }

        if(code.getText().isEmpty()){
            showCode = true;
            code.setText("   06xxxxxx");
            code.setForeground(Color.GRAY);
        }

        if (name.getText().isEmpty()) {
            showName = true;
            name.setText("   OOP");
            name.setForeground(Color.GRAY);

        }if (teacher.getText().isEmpty()) {
            showTeacher = true;
            teacher.setText("  ธราวิเชษฐ์");
            teacher.setForeground(Color.GRAY);
        }if (note.getText().isEmpty()) {
            showNote = true;
            note.setText("   รายวิชา หลักสูตร พ.ศ.2560 : สำหรับนักศึกษาเก็บตก");
            note.setForeground(Color.GRAY);
        }if (condition.getText().isEmpty()) {
            showCondition = true;
            condition.setText("   รับเฉพาะนักศึกษาคณะไอที");
            condition.setForeground(Color.GRAY);
        }
    }
}
