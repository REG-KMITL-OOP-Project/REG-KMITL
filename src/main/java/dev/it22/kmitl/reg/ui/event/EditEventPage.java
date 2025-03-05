
package dev.it22.kmitl.reg.ui.event;
import dev.it22.kmitl.reg.utils.Config;
import dev.it22.kmitl.reg.utils.CustomCombobox;
import dev.it22.kmitl.reg.utils.RoundedButton;

import java.awt.*;
import javax.swing.*;

public class EditEventPage {
    private  JFrame frame;
    private JPanel panelBig,panelRek1,panelRek2,panelRek3,panelRek4,panelRek5,panelEdit,panelSave,panelDel;
    private RoundedButton save,delete;
    private JLabel editEvent,to;
    private JTextField eventName,dateStart,dateEnd;
    private JTextArea description;
    private JComboBox eventType;
    private Font innerFont, regularFont;

    public EditEventPage(JFrame frame){
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
        delete = new RoundedButton("DELETE", 22);
        editEvent = new JLabel("              EDIT EVENT");
        to = new JLabel("TO");
        eventName = new JTextField();
        dateStart = new JTextField();
        dateEnd = new JTextField();
        description = new JTextArea(2,25);
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
            eventName.setText("Event Name");
            eventName.setFont(innerFont);
            eventName.setForeground(Color.GRAY);
            eventName.setPreferredSize(new Dimension((int)(frame.getWidth() / 1.2),(frame.getHeight() / 4) - 120));
        panelRek1.add(eventName);

        panelBig.add(panelRek2);
            description.setText("Description");
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
        panelSave.add(save);

        panelRek5.add(panelDel);
        panelDel.setLayout( new FlowLayout(FlowLayout.RIGHT,93,0));
        delete.setForeground(Color.WHITE);
        delete.setBackground(Config.primaryColor_harder);
        delete.setFont(Config.HEADER_SEMIBOLD[2]);
        delete.setPreferredSize(new Dimension((int)((frame.getWidth()-500)/2.7),(frame.getHeight() / 4) - 120));
        panelDel.add(delete);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new EditEventPage(Config.createAndShowGUI());
    }
}
