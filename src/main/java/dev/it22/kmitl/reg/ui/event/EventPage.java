package dev.it22.kmitl.reg.ui.event;

import dev.it22.kmitl.reg.utils.Config;
import dev.it22.kmitl.reg.utils.CustomCombobox;
import dev.it22.kmitl.reg.utils.RoundedTextArea;
import dev.it22.kmitl.reg.utils.RoundedTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class EventPage implements FocusListener {
    protected JFrame frame;
    protected JPanel panelBig,panelRek1,panelRek2,panelRek3,panelRek4,panelRek5,panelHead;
    protected JLabel to,;
    protected RoundedTextField eventName,dateStart,dateEnd;
    protected RoundedTextArea description;
    protected JComboBox eventType;
    protected Font innerFont, regularFont;
    protected boolean showEventName , showDateStart, showDateEnd, showDescription;

    public EventPage(JFrame frame){
        this.frame = frame;
        panelBig = new JPanel();
        panelRek1 = new JPanel();
        panelRek2 = new JPanel();
        panelRek3 = new JPanel();
        panelRek4 = new JPanel();
        panelRek5 = new JPanel();
        panelHead = new JPanel();
        to = new JLabel("TO");
        eventName = new RoundedTextField(22);
        dateStart = new RoundedTextField(22);
        dateEnd = new RoundedTextField(22);
        description = new RoundedTextArea(22);
        eventType = new JComboBox();
        regularFont = Config.NORMAL_REGULAR;
        innerFont = regularFont.deriveFont(15f);

        panelHead.setBackground(null);
        panelRek1.setBackground(null);
        panelRek2.setBackground(null);
        panelRek3.setBackground(null);
        panelRek4.setBackground(null);
        panelRek5.setBackground(null);
        panelBig.setBackground(null);


        frame.add(panelHead);
        panelHead.setLayout( new BorderLayout());
        panelHead.add(panelBig);
        panelBig.setLayout(new BoxLayout(panelBig, BoxLayout.Y_AXIS));
        panelBig.add(Box.createVerticalStrut(10));

        panelBig.add(panelRek1);
        showEventName = true;
        eventName.setText("   EVENT NAME");
        eventName.setFont(innerFont);
        eventName.setForeground(Color.GRAY);
        eventName.setPreferredSize(new Dimension((int)(frame.getWidth() / 1.2),(frame.getHeight() / 4) - 120));

        eventName.addFocusListener(this);


        panelRek1.add(eventName);

        panelBig.add(panelRek2);
        showDescription = true;
        description.setText("   DESCRIPTION");
        description.setPreferredSize(new Dimension((int)(frame.getWidth() / 1.2),(frame.getHeight() / 4)));
        description.setFont(innerFont);
        description.setForeground(Color.GRAY);

        description.addFocusListener(this);
        panelRek2.add(description);

        panelBig.add(panelRek3);
        panelRek3.setLayout( new FlowLayout(FlowLayout.CENTER, 190, 0));
        panelRek3.add(dateStart);
        dateStart.setHorizontalAlignment(SwingConstants.CENTER);
        showDateStart = true;
        dateStart.setText("DD/MM/YY");
        dateStart.setPreferredSize(new Dimension((int)((frame.getWidth()-500)/3.4),(frame.getHeight() / 4) - 120));
        dateStart.setFont(innerFont);
        dateStart.setForeground(Color.GRAY);

        dateStart.addFocusListener(this);

        panelRek3.add(to);
        to.setOpaque(true);
        to.setBackground(null);
        to.setFont(Config.HEADER_SEMIBOLD[2]);
        to.setForeground(Color.WHITE);
        to.setPreferredSize(new Dimension((int)((frame.getWidth()-500)/3.4),(frame.getHeight() / 4) - 120));
        to.setHorizontalAlignment(SwingConstants.CENTER);
        panelRek3.add(dateEnd);
        dateEnd.setHorizontalAlignment(SwingConstants.CENTER);
        showDateEnd = true;
        dateEnd.setText("DD/MM/YY");
        dateEnd.setPreferredSize(new Dimension((int)((frame.getWidth()-500)/3.4),(frame.getHeight() / 4) - 120));
        dateEnd.setFont(innerFont);
        dateEnd.setForeground(Color.GRAY);

        dateEnd.addFocusListener(this);

        panelBig.add(panelRek4);
        eventType.addItem("   อื่นๆ");
        eventType.addItem("   เปิด-ปิด ภาคการศึกษา");
        eventType.addItem("   สอบ");
        eventType.addItem("   ชำระเงิน");
        eventType.addItem("   ลงทะเบียน");
        eventType.addItem("   ประเมินอาจารย์");
        eventType.setRenderer(new CustomCombobox());
        eventType.setMaximumRowCount(3);
        eventType.setFont(Config.NORMAL_REGULAR);
        eventType.setFont(innerFont);
        eventType.setPreferredSize(new Dimension((int)(frame.getWidth() / 1.2),(frame.getHeight() / 4) - 120));
        panelRek4.add(eventType);

        panelBig.add(panelRek5);
        panelRek5.setLayout(new GridLayout(1,2));
    }

    public void focusGained(FocusEvent fg){
        if (fg.getSource().equals(eventName) && showEventName){
            eventName.setText("");
            eventName.setForeground(Color.BLACK);
            showEventName = false;

        }else if(fg.getSource().equals(description) && showDescription){
            description.setText("");
            description.setForeground(Color.BLACK);
            showDescription = false;

        }else if (fg.getSource().equals(dateStart) && showDateStart){
            dateStart.setText("");
            dateStart.setForeground(Color.BLACK);
            showDateStart = false;

        }else if (fg.getSource().equals(dateEnd) && showDateEnd) {
            dateEnd.setText("");
            dateEnd.setForeground(Color.BLACK);
            showDateEnd = false;
        }
    }

    public void focusLost(FocusEvent e){
        if (eventName.getText().isEmpty()) {
            showEventName = true;
            eventName.setText("   EVENT NAME");
            eventName.setForeground(Color.GRAY);
        }

        if(description.getText().isEmpty()){
            showDescription = true;
            description.setText("   DESCRIPTION");
            description.setForeground(Color.GRAY);
        }

        if (dateStart.getText().isEmpty()) {
            showDateStart = true;
            dateStart.setText("DD/MM/YY");
            dateStart.setForeground(Color.GRAY);

        }if (dateEnd.getText().isEmpty()) {
            showDateEnd = true;
            dateEnd.setText("DD/MM/YY");
            dateEnd.setForeground(Color.GRAY);
        }
    }
}
