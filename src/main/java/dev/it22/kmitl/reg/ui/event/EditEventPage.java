
package dev.it22.kmitl.reg.ui.event;
import dev.it22.kmitl.reg.utils.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.*;

public class EditEventPage extends EventPage implements ActionListener {
    private JPanel panelSave,panelDel,panelCan;
    private RoundedButton delete,cancel;
    private ButtonSave save;
    private JLabel editEvent;

    public EditEventPage(JFrame frame){
        super(frame);
        panelSave = new JPanel();
        panelDel = new JPanel();
        panelCan = new JPanel();
        delete = new RoundedButton("DELETE", 22);
        cancel = new RoundedButton("CANCEL", 22);
        save = new ButtonSave("SAVE CHANGE",22);
        editEvent = new JLabel("              EDIT EVENT");

        panelSave.setBackground(null);
        panelDel.setBackground(null);
        panelCan.setBackground(null);

            editEvent.setForeground(new Color(255,247,237));
            editEvent.setFont(Config.HEADER_SEMIBOLD[1]);
        editEvent.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        panelHead.add(editEvent,BorderLayout.NORTH);

        panelRek5.add(panelCan);
        panelCan.setLayout( new FlowLayout(FlowLayout.LEFT,93,0));
        cancel.setForeground(Color.BLACK);
        cancel.setBackground(new Color(255,247,237));
        cancel.setFont(Config.HEADER_SEMIBOLD[2]);
        cancel.setPreferredSize(new Dimension((int)((frame.getWidth()-500)/2.7),(frame.getHeight() / 4) - 120));

        cancel.addActionListener(this);

        panelCan.add(cancel);

        panelRek5.add(panelSave);
        panelSave.setLayout(new FlowLayout(FlowLayout.CENTER, 93, 0));
        save.setPreferredSize(new Dimension((int) ((frame.getWidth() - 500) / 2.7), (frame.getHeight() / 4) - 120));
        panelSave.add(save);
        save.addActionListener(this);

        panelRek5.add(panelDel);
        panelDel.setLayout( new FlowLayout(FlowLayout.RIGHT,93,0));
        delete.setForeground(Color.WHITE);
        delete.setBackground(Config.primaryColor_harder);
        delete.setFont(Config.HEADER_SEMIBOLD[2]);
        delete.setPreferredSize(new Dimension((int)((frame.getWidth()-500)/2.7),(frame.getHeight() / 4) - 120));

        delete.addActionListener(this);

        panelDel.add(delete);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new EditEventPage(Config.createAndShowGUI());
    }

    private RoundedButton del , cal ;
    private JDialog dialog ;

    public void actionPerformed(ActionEvent ev) {
        if (ev.getSource() == delete) {
            dialog = Config.openFrame((int) (frame.getWidth() / 2), (int) (frame.getHeight() / 2));
            JPanel panelD = new JPanel();
            JPanel panelC = new JPanel();
            JPanel P = new JPanel();
            JPanel panel = new JPanel();
            JLabel header = new JLabel("ARE YOU SURE WANT TO DELETE");
            del = new RoundedButton("DELETE", 22);
            cal = new RoundedButton("CANCEL", 22);

            header.setForeground(Config.primaryColor_hard);

            header.setFont(Config.HEADER_SEMIBOLD[1]);
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            panel.add(Box.createVerticalStrut(50));

            panel.setBackground(null);
            panel.add(header);
            dialog.add(panel);

            P.setLayout(new GridLayout(1, 2));
            P.setBackground(null);
            P.add(panelC);
            P.add(panelD);

            panelD.setLayout(new FlowLayout(FlowLayout.RIGHT, 30, 0));
            del.setForeground(Color.WHITE);
            del.setBackground(Config.primaryColor_harder);
            del.setFont(Config.HEADER_SEMIBOLD[2]);

            del.setPreferredSize(new Dimension((int) ((frame.getWidth() - 500) / 3.5), (frame.getHeight() / 4) - 120));

            del.addActionListener(this);

            panelD.setBackground(null);
            panelD.add(del);

            panelC.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 0));
            cal.setForeground(Color.BLACK);
            cal.setBackground(new Color(255, 247, 237));
            cal.setFont(Config.HEADER_SEMIBOLD[2]);
            cal.setPreferredSize(new Dimension((int) ((frame.getWidth() - 500) / 3.5), (frame.getHeight() / 4) - 120));

            cal.addActionListener(this);

            panelC.setBackground(null);
            panelC.add(cal);

            dialog.add(P);
            dialog.setVisible(true);
        }else if (ev.getSource().equals(cal) || ev.getSource().equals(del)) {
            dialog.setVisible(false);
        }if (ev.getSource().equals(del) || ev.getSource().equals(cancel)) {
            frame.getContentPane().removeAll();
            frame.revalidate();
            frame.repaint();
            new AdminCalendarPage (frame);
        }
    else if (ev.getSource().equals(save)) {
            frame.getContentPane().removeAll();
            frame.revalidate();
            frame.repaint();
            new AdminCalendarPage (frame);
        }
    }
}
