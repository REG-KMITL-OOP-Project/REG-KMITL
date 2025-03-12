package dev.it22.kmitl.reg.ui.Homepage_regis;
import dev.it22.kmitl.reg.ui.event.AdminAddEvent;
import dev.it22.kmitl.reg.utils.Config;
import dev.it22.kmitl.reg.utils.CustomCombobox;
import dev.it22.kmitl.reg.utils.RoundedTextField;

import javax.swing.*;
import java.awt.*;

public class AdminAddSubject {
    private JFrame frame ;
    private JPanel panelBig,panelRek1,panelRek2,panelRek3,panelRek4,panelRek5,panelHead;
    private JLabel addSubject;
    private RoundedTextField year,name,code,note,condition;
    private JComboBox type,kit,group,branch;
    private Font innerFont, regularFont;

    public AdminAddSubject(JFrame frame){
        this.frame = frame;
        panelBig = new JPanel();
        panelHead = new JPanel();
        panelRek1 = new JPanel();
        panelRek2 = new JPanel();
        panelRek3 = new JPanel();
        panelRek4 = new JPanel();
        panelRek5 = new JPanel();
        addSubject = new JLabel("              Add Subject");
        year = new RoundedTextField(22);
        name = new RoundedTextField(22);
        code = new RoundedTextField(22);
        note = new RoundedTextField(22);
        condition = new RoundedTextField(22);
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

        panelHead.setLayout( new BorderLayout());
        panelHead.add(panelBig);
        panelBig.setLayout(new BoxLayout(panelBig, BoxLayout.Y_AXIS));
        panelBig.add(Box.createVerticalStrut(10));

        panelHead.add(addSubject);
        addSubject.setForeground(new Color(255,247,237));
        addSubject.setFont(Config.HEADER_SEMIBOLD[1]);
        addSubject.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        panelHead.add(addSubject,BorderLayout.NORTH);

        panelRek1.add(year);
        //showYear = true;
        year.setText("   ภาคการศึกษา");
        year.setFont(innerFont);
        year.setForeground(Color.GRAY);
        year.setPreferredSize(new Dimension((int)(frame.getWidth() / 4),(frame.getHeight() / 4) - 120));

        panelRek1.add(type);
        type.addItem("ประเภท");
        type.addItem("ทฤษฏี");
        type.addItem("ปฏิบัติ");
        type.setRenderer(new CustomCombobox());
        type.setMaximumRowCount(3);
        type.setFont(Config.NORMAL_REGULAR);
        type.setFont(innerFont);
        type.setPreferredSize(new Dimension((int)(frame.getWidth() / 4),(frame.getHeight() / 4) - 120));

        panelRek1.add(kit);
        kit.addItem("หน่วยกิต");
        kit.addItem("1");
        kit.addItem("2");
        kit.addItem("3");
        kit.setRenderer(new CustomCombobox());
        kit.setMaximumRowCount(3);
        kit.setFont(Config.NORMAL_REGULAR);
        kit.setFont(innerFont);
        kit.setPreferredSize(new Dimension((int)(frame.getWidth() / 4),(frame.getHeight() / 4) - 120));

        panelBig.add(panelRek1);

        panelRek2.add(group);
        group.addItem("คณะ");
        group.addItem("เทคโนโลยีสารสนเทศ");
        group.setRenderer(new CustomCombobox());
        group.setMaximumRowCount(3);
        group.setFont(Config.NORMAL_REGULAR);
        group.setFont(innerFont);
        group.setPreferredSize(new Dimension((int)(frame.getWidth() / 4),(frame.getHeight() / 4) - 120));

        panelRek2.add(branch);
        branch.addItem("สาขา");
        branch.addItem("เทคโนโลยีสารสนเทศ");
        branch.addItem("วิทยาการข้อมูลและการวิเคราะห์เชิงธุรกิจ");
        branch.addItem("เทคโนโลยีปัญญาประดิษฐ์");
        branch.setRenderer(new CustomCombobox());
        branch.setMaximumRowCount(3);
        branch.setFont(Config.NORMAL_REGULAR);
        branch.setFont(innerFont);
        branch.setPreferredSize(new Dimension((int)(frame.getWidth() / 4),(frame.getHeight() / 4) - 120));

        panelRek2.add(code);
        code.setText("   รหัสวิชาค");
        code.setFont(innerFont);
        code.setForeground(Color.GRAY);
        code.setPreferredSize(new Dimension((int)(frame.getWidth() / 4),(frame.getHeight() / 4) - 120));

        panelBig.add(panelRek2);

        panelHead.add(panelBig);
        frame.add(panelHead);

        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    } public static void main(String[] args) {
        new AdminAddSubject(Config.createAndShowGUI());
    }
}
