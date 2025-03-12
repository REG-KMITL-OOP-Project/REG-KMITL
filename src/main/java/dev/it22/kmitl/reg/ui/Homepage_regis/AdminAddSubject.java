package dev.it22.kmitl.reg.ui.Homepage_regis;
import dev.it22.kmitl.reg.ui.event.AdminAddEvent;
import dev.it22.kmitl.reg.utils.Config;

import javax.swing.*;
import java.awt.*;

public class AdminAddSubject {
    private JFrame frame ;
    private JPanel panelBig,panelRek1,panelRek2,panelRek3,panelRek4,panelRek5,panelHead;
    private JLabel addSubject;
    private  JTextField year,name,code,note,condition;
    private JComboBox type,kit,group,branch;
    private Font innerFont, regularFont;

    public AdminAddSubject(JFrame frame){
        this.frame = frame;
        panelBig = new JPanel();
        panelHead = new JPanel();
        panelRek1 = new JPanel();
        addSubject = new JLabel("              Add Subject");
        year = new JTextField(10);
        regularFont = Config.NORMAL_REGULAR;
        innerFont = regularFont.deriveFont(15f);

        panelBig.setBackground(null);
        panelHead.setBackground(null);
        panelRek1.setBackground(null);

        frame.add(panelHead);
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
        year.setPreferredSize(new Dimension((int)(frame.getWidth() / 1.2),(frame.getHeight() / 4) - 120));
        panelBig.add(panelRek1);
        panelHead.add(panelBig);
        frame.add(panelHead);

        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    } public static void main(String[] args) {
        new AdminAddSubject(Config.createAndShowGUI());
    }
}
