package dev.it22.kmitl.reg.ui.event;

import dev.it22.kmitl.reg.utils.Config;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.metal.MetalCheckBoxIcon;
import java.awt.*;

public class eventCategory extends JPanel{
    private JCheckBox semester, exam, bill, eval, other;
    private JPanel sem, ex, bi, ev, ot;
    private JPanel pn1, pn2;
    public eventCategory() {
        semester = new JCheckBox("   เปิด-ปิดภาคเรียน");
        exam = new JCheckBox("   ช่วงการสอบ");
        bill = new JCheckBox("   การชำระเงิน");
        eval = new JCheckBox("   การลงทะเบียน");
        other = new JCheckBox("   อื่นๆ");

        semester.setFont(Config.HEADER_REGULAR[3]);
        exam.setFont(Config.HEADER_REGULAR[3]);
        bill.setFont(Config.HEADER_REGULAR[3]);
        eval.setFont(Config.HEADER_REGULAR[3]);
        other.setFont(Config.HEADER_REGULAR[3]);

        semester.setForeground(Color.WHITE);
        exam.setForeground(Color.WHITE);
        bill.setForeground(Color.WHITE);
        eval.setForeground(Color.WHITE);
        other.setForeground(Color.WHITE);

        semester.setIcon(new changeColorCheckbox(Color.RED));
        exam.setIcon(new changeColorCheckbox(Config.primaryColor_hard));
        bill.setIcon(new changeColorCheckbox(Color.GREEN));
        eval.setIcon(new changeColorCheckbox(Color.BLUE));
        other.setIcon(new changeColorCheckbox(Color.magenta));


        sem = new JPanel();
        ex = new JPanel();
        bi = new JPanel();
        ev = new JPanel();
        ot = new JPanel();
        //
        sem.add(semester);
        sem.setLayout(new FlowLayout(FlowLayout.LEFT));
        sem.setPreferredSize(new Dimension(300, 50));
        sem.setBackground(Config.bgColor_base.darker());
        //
        ex.add(exam);
        ex.setLayout(new FlowLayout(FlowLayout.LEFT));
        ex.setPreferredSize(new Dimension(300, 50));
        ex.setBackground(Config.bgColor_base.darker());
        //
        bi.add(bill);
        bi.setLayout(new FlowLayout(FlowLayout.LEFT));
        bi.setPreferredSize(new Dimension(300, 50));
        bi.setBackground(Config.bgColor_base.darker());
        //
        ev.add(eval);
        ev.setLayout(new FlowLayout(FlowLayout.LEFT));
        ev.setPreferredSize(new Dimension(300, 50));
        ev.setBackground(Config.bgColor_base.darker());
        //
        ot.add(other);
        ot.setLayout(new FlowLayout(FlowLayout.LEFT));
        ot.setPreferredSize(new Dimension(300, 50));
        ot.setBackground(Config.bgColor_base.darker());

        pn1 = new JPanel();
        pn1.setLayout(new FlowLayout(FlowLayout.LEFT));
        pn1.add(sem);
        pn1.add(ex);
        pn1.add(bi);
        pn1.add(ev);
        pn1.add(ot);
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
