package dev.it22.kmitl.reg.ui.event.calendar;

import dev.it22.kmitl.reg.ui.event.component.changeColorCheckbox;
import dev.it22.kmitl.reg.utils.Config;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class SemesterCategory extends JPanel{
    private JCheckBox sem1, sem2, specialSem;
    private JPanel sm1, sm2, special, ev, ot;
    private JPanel pn1, pn2;
    public SemesterCategory() {
        sem1 = new JCheckBox("   ภาคการศึกษาที่ 1");
        sem2 = new JCheckBox("   ภาคการศึกษาที่ 2");
        specialSem = new JCheckBox("   ภาคการศึกษาพิเศษ");


        sem1.setFont(Config.HEADER_REGULAR[3]);
        sem2.setFont(Config.HEADER_REGULAR[3]);
        specialSem.setFont(Config.HEADER_REGULAR[3]);

        sem1.setForeground(Color.WHITE);
        sem2.setForeground(Color.WHITE);
        specialSem.setForeground(Color.WHITE);

        sem1.setIcon(new changeColorCheckbox(Color.RED));
        sem2.setIcon(new changeColorCheckbox(Config.primaryColor_hard));
        specialSem.setIcon(new changeColorCheckbox(Color.GREEN));


        sm1 = new JPanel();
        sm2 = new JPanel();
        special = new JPanel();

        //
        sm1.add(sem1);
        sm1.setLayout(new FlowLayout(FlowLayout.LEFT));
        sm1.setPreferredSize(new Dimension(300, 50));
        sm1.setBackground(Config.bgColor_base.darker());
        //
        sm2.add(sem2);
        sm2.setLayout(new FlowLayout(FlowLayout.LEFT));
        sm2.setPreferredSize(new Dimension(300, 50));
        sm2.setBackground(Config.bgColor_base.darker());
        //
        special.add(specialSem);
        special.setLayout(new FlowLayout(FlowLayout.LEFT));
        special.setPreferredSize(new Dimension(300, 50));
        special.setBackground(Config.bgColor_base.darker());


        pn1 = new JPanel();
        pn1.setLayout(new FlowLayout(FlowLayout.LEFT));
        pn1.add(sm1);
        pn1.add(sm2);
        pn1.add(special);
        pn1.setPreferredSize(new Dimension(300, 300));
        pn1.setBorder(new EmptyBorder(25,30,15,0));
        pn1.setBackground(Config.bgColor_base.darker());

        pn2 = new JPanel();
        pn2.setBackground(null);

        this.setLayout(new BorderLayout());
        this.add(pn1, BorderLayout.WEST);
        this.add(pn2, BorderLayout.EAST);
        this.setBackground(null);
    }
}
