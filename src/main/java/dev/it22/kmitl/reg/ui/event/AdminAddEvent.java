package dev.it22.kmitl.reg.ui.event;

import dev.it22.kmitl.reg.utils.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AdminAddEvent extends EventPage implements ActionListener {
    private JPanel panelSave,panelDel;
    private RoundedButton save,upload;
    private JLabel addEvent;

    public AdminAddEvent (JFrame frame){
        super(frame);
        panelSave = new JPanel();
        panelDel = new JPanel();
        save = new RoundedButton("SAVE AS DRAFT",22);
        upload = new RoundedButton("UPLOAD", 22);
        addEvent = new JLabel("               ADD EVENT");
        regularFont = Config.NORMAL_REGULAR;
        innerFont = regularFont.deriveFont(15f);

        panelSave.setBackground(null);
        panelDel.setBackground(null);

        addEvent.setForeground(new Color(255,247,237));
        addEvent.setFont(Config.HEADER_SEMIBOLD[1]);
        addEvent.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        panelHead.add(addEvent,BorderLayout.NORTH);

        panelRek5.add(panelSave);
        panelSave.setLayout( new FlowLayout(FlowLayout.LEFT,93,0));
        save.setForeground(Color.BLACK);
        save.setBackground(Config.primaryColor_base);
        save.setFont(Config.HEADER_SEMIBOLD[2]);
        save.setPreferredSize(new Dimension((int)((frame.getWidth()-500)/2.7),(frame.getHeight() / 4) - 120));

        save.addActionListener(this);

        panelSave.add(save);

        panelRek5.add(panelDel);
        panelDel.setLayout( new FlowLayout(FlowLayout.RIGHT,93,0));
        upload.setForeground(Color.WHITE);
        upload.setBackground(Config.primaryColor_harder);
        upload.setFont(Config.HEADER_SEMIBOLD[2]);
        upload.setPreferredSize(new Dimension((int)((frame.getWidth()-500)/2.7),(frame.getHeight() / 4) - 120));

        upload.addActionListener(this);

        panelDel.add(upload);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new AdminAddEvent (Config.createAndShowGUI());
    }

    private RoundedButton del , cal ;
    private JDialog dialog ;

    public void actionPerformed(ActionEvent ev){
        if (ev.getSource() == upload) {
            dialog = Config.openFrame((int)(frame.getWidth()/2), (int) (frame.getHeight()/2 ));
            JPanel panelD = new JPanel();
            JPanel panelC = new JPanel();
            JPanel P = new JPanel();
            JPanel panel = new JPanel();
            JLabel header = new JLabel("ARE YOU SURE WANT TO DELETE");
            del = new RoundedButton("DELETE" , 22);
            cal = new RoundedButton("CANCEL" , 22);

            header.setForeground(Config.primaryColor_hard);
            header.setFont(Config.HEADER_SEMIBOLD[1]);
            panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
            panel.add(Box.createVerticalStrut(50));

            panel.setBackground(null);
            panel.add(header);
            dialog.add(panel);

            P.setLayout(new GridLayout(1,2));
            P.setBackground(null);
            P.add(panelC);
            P.add(panelD);

            panelD.setLayout( new FlowLayout(FlowLayout.RIGHT,30,0));
            del.setForeground(Color.WHITE);
            del.setBackground(Config.primaryColor_harder);
            del.setFont(Config.HEADER_SEMIBOLD[2]);
            del.setPreferredSize(new Dimension((int)((frame.getWidth()-500)/3.5),(frame.getHeight() / 4) - 120));

            del.addActionListener(this);

            panelD.setBackground(null);
            panelD.add(del);

            panelC.setLayout( new FlowLayout(FlowLayout.LEFT,30,0));
            cal.setForeground(Color.BLACK);
            cal.setBackground(new Color(255,247,237));
            cal.setFont(Config.HEADER_SEMIBOLD[2]);
            cal.setPreferredSize(new Dimension((int)((frame.getWidth()-500)/3.5),(frame.getHeight() / 4) - 120));

            cal.addActionListener(this);

            panelC.setBackground(null);
            panelC.add(cal);

            dialog.add(P);
            dialog.setVisible(true);
        }
        else if (ev.getSource() == cal) {
            dialog.setVisible(false);
        }

    }
}

