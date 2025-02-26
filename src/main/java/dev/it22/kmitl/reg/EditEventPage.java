package dev.it22.kmitl.reg;
import dev.it22.kmitl.reg.utils.Config;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EditEventPage {
    private  JFrame frame;
    private JPanel panelBig,panelRek1,panelRek2,panelRek3,panelRek4,panelRek5,panelEdit;
    private JButton save,delete;
    private JLabel editEvent,to;
    private JTextField eventName,dateStart,dateEnd;
    private JTextArea description;
    private JComboBox eventType;

    public EditEventPage(JFrame frame){
        this.frame = frame;
        panelBig = new JPanel();
        panelRek1 = new JPanel();
        panelRek2 = new JPanel();
        panelRek3 = new JPanel();
        panelRek4 = new JPanel();
        panelRek5 = new JPanel();
        panelEdit = new JPanel();
        save = new JButton("SAVE CHANGE");
        delete = new JButton("DELETE");
        editEvent = new JLabel("EDIT EVENT");
        to = new JLabel("To");
        eventName = new JTextField(25);
        dateStart = new JTextField(6);
        dateEnd = new JTextField(6);
        description = new JTextArea(2,25);
        eventType = new JComboBox();

        panelEdit.setBackground(null);
        panelRek1.setBackground(null);
        panelRek2.setBackground(null);
        panelRek3.setBackground(null);
        panelRek4.setBackground(null);
        panelRek5.setBackground(null);
        panelEdit.setBackground(null);
        panelBig.setBackground(null);

        frame.add(panelEdit);
        panelEdit.setLayout( new BorderLayout());
            editEvent.setForeground(new Color(255,247,237));
            editEvent.setFont(Config.HEADER_SEMIBOLD[1]);;
        panelEdit.add(editEvent,BorderLayout.NORTH);
        panelEdit.add(panelBig,BorderLayout.WEST);
        panelBig.setLayout( new GridLayout(5,1));

        panelBig.add(panelRek1);
            eventName.setText("Event Name");
            eventName.setForeground(Color.GRAY);
        panelRek1.add(eventName);

        panelBig.add(panelRek2);
            description.setText("DESCRIPTION");
            description.setForeground(Color.GRAY);
        panelRek2.add(description);

        panelBig.add(panelRek3);
        panelRek3.setLayout( new FlowLayout());
        panelRek3.add(dateStart);
            dateStart.setText("DD/MM/YY");
            dateStart.setForeground(Color.GRAY);
        panelRek3.add(to);
            to.setForeground(Color.WHITE);
        panelRek3.add(dateEnd);
            dateEnd.setText("DD/MM/YY");
            dateEnd.setForeground(Color.GRAY);

        panelBig.add(panelRek4);
        eventType.addItem("CHOOSE CATEGORY");
        panelRek4.add(eventType);

        panelBig.add(panelRek5);
        panelRek5.setLayout( new FlowLayout());
        save.setForeground(Color.BLACK);
        save.setBackground(new Color(255,247,237));
        save.setPreferredSize(new Dimension((frame.getWidth()-500)/6,(frame.getHeight() / 4) - 120));
        panelRek5.add(save);
        delete.setForeground(Color.WHITE);
        delete.setBackground( new Color(245,73,0));
        delete.setPreferredSize(new Dimension((frame.getWidth()-500)/6,(frame.getHeight() / 4) - 120));
        panelRek5.add(delete);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new EditEventPage(Config.createAndShowGUI());
    }
}
