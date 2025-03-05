package dev.it22.kmitl.reg.ui.event;

import dev.it22.kmitl.reg.utils.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AdminAddEvent implements ActionListener {
    private  JFrame frame;
    private JPanel panelBig,panelRek1,panelRek2,panelRek3,panelRek4,panelRek5,panelEdit,panelSave,panelDel;
    private RoundedButton save,upload;
    private JLabel editEvent,to;
    private RoundedTextField eventName,dateStart,dateEnd;
    private RoundedTextArea description;
    private JComboBox eventType;
    private Font innerFont, regularFont;

    public AdminAddEvent (JFrame frame){
        this.frame = frame;
        panelBig = new JPanel();
        panelRek1 = new JPanel();
        panelRek2 = new JPanel();
        panelRek3 = new JPanel();
        panelRek4 = new JPanel();
        panelRek5 = new JPanel();
        panelEdit = new JPanel();
        panelSave = new JPanel();
        panelDel = new JPanel();
        save = new RoundedButton("SAVE CHANGE",22);
        upload = new RoundedButton("UPLOAD", 22);
        editEvent = new JLabel("              EDIT EVENT");
        to = new JLabel("TO");
        eventName = new RoundedTextField(22);
        dateStart = new RoundedTextField(22);
        dateEnd = new RoundedTextField(22);
        description = new RoundedTextArea(22);
        eventType = new JComboBox();
        regularFont = Config.NORMAL_REGULAR;
        innerFont = regularFont.deriveFont(15f);

        panelEdit.setBackground(null);
        panelRek1.setBackground(null);
        panelRek2.setBackground(null);
        panelRek3.setBackground(null);
        panelRek4.setBackground(null);
        panelRek5.setBackground(null);
        panelEdit.setBackground(null);
        panelBig.setBackground(null);
        panelSave.setBackground(null);
        panelDel.setBackground(null);

        frame.add(panelEdit);
        panelEdit.setLayout( new BorderLayout());
        editEvent.setForeground(new Color(255,247,237));
        editEvent.setFont(Config.HEADER_SEMIBOLD[1]);
        editEvent.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        panelEdit.add(editEvent,BorderLayout.NORTH);
        panelEdit.add(panelBig);
        panelBig.setLayout(new BoxLayout(panelBig, BoxLayout.Y_AXIS));
        panelBig.add(Box.createVerticalStrut(10));

        panelBig.add(panelRek1);
        eventName.setText("   EVENT NAME");
        eventName.setFont(innerFont);
        eventName.setForeground(Color.GRAY);
        eventName.setPreferredSize(new Dimension((int)(frame.getWidth() / 1.2),(frame.getHeight() / 4) - 120));
        panelRek1.add(eventName);

        panelBig.add(panelRek2);
        description.setText("   DESCRIPTION");
        description.setPreferredSize(new Dimension((int)(frame.getWidth() / 1.2),(frame.getHeight() / 4)));
        description.setFont(innerFont);
        description.setForeground(Color.GRAY);
        panelRek2.add(description);

        panelBig.add(panelRek3);
        panelRek3.setLayout( new FlowLayout(FlowLayout.CENTER, 190, 0));
        panelRek3.add(dateStart);
        dateStart.setHorizontalAlignment(SwingConstants.CENTER);
        dateStart.setText("DD/MM/YY");
        dateStart.setPreferredSize(new Dimension((int)((frame.getWidth()-500)/3.4),(frame.getHeight() / 4) - 120));
        dateStart.setFont(innerFont);
        dateStart.setForeground(Color.GRAY);
        panelRek3.add(to);
        to.setOpaque(true);
        to.setBackground(Config.primaryColor_hard);
        to.setFont(Config.HEADER_SEMIBOLD[3]);
        to.setForeground(Color.WHITE);
        to.setPreferredSize(new Dimension((int)((frame.getWidth()-500)/3.4),(frame.getHeight() / 4) - 120));
        to.setHorizontalAlignment(SwingConstants.CENTER);
        panelRek3.add(dateEnd);
        dateEnd.setHorizontalAlignment(SwingConstants.CENTER);
        dateEnd.setText("DD/MM/YY");
        dateEnd.setPreferredSize(new Dimension((int)((frame.getWidth()-500)/3.4),(frame.getHeight() / 4) - 120));
        dateEnd.setFont(innerFont);
        dateEnd.setForeground(Color.GRAY);

        panelBig.add(panelRek4);
        eventType.addItem("   CHOOSE CATEGORY");
        eventType.addItem("   CHOOSE CATEGORY");
        eventType.addItem("   CHOOSE CATEGORY");
        eventType.addItem("   CHOOSE CATEGORY");
        eventType.addItem("   CHOOSE CATEGORY");
        eventType.setRenderer(new CustomCombobox());
        eventType.setMaximumRowCount(3);
        eventType.setFont(Config.NORMAL_REGULAR);
        eventType.setFont(innerFont);
        eventType.setPreferredSize(new Dimension((int)(frame.getWidth() / 1.2),(frame.getHeight() / 4) - 120));
        panelRek4.add(eventType);

        panelBig.add(panelRek5);
        panelRek5.setLayout(new GridLayout(1,2));
        panelRek5.add(panelSave);
        panelSave.setLayout( new FlowLayout(FlowLayout.LEFT,93,0));
        save.setForeground(Color.BLACK);
        save.setBackground(new Color(255,247,237));
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

    private JButton del , cal ;
    private JDialog dialog ;

    public void actionPerformed(ActionEvent ev){
        if (ev.getSource() == upload) {
            dialog = Config.openFrame((int)(frame.getWidth()/2), (int) (frame.getHeight()/2 ));
            JPanel panelD = new JPanel();
            JPanel panelC = new JPanel();
            JPanel P = new JPanel();
            JPanel panel = new JPanel();
            JLabel header = new JLabel("ARE YOU SURE WANT TO DELETE");
            del = new JButton("DELETE");
            cal = new JButton("CANCEL");

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
