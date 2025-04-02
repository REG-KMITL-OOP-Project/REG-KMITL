
package dev.it22.kmitl.reg.ui.event.calendar;
import dev.it22.kmitl.reg.ui.event.admin.EditDataEvent;
import dev.it22.kmitl.reg.utils.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class descriptionPage extends EventPage implements ActionListener {
    private JPanel panelCan;
    private RoundedButtonWithColor back;
    private JLabel editEvent;
    private ArrayList<String> list;
    private boolean oneRecord = false;
    public descriptionPage(JFrame frame, String name, String type){
        super(frame);
        list = new EditDataEvent().getData(name,type);
        System.out.println(list);
        eventName.setText(list.get(0));
        dateStart.setText(list.get(2));

        try{
            dateEnd.setText(list.get(5));
        }catch (Exception ex){
            oneRecord = true;
            dateEnd.setText(list.get(2));
        }
        description.setText(list.get(1));
        eventType.setSelectedItem(("   ")+(list.get(3)));
        showEventName = false; showDateStart = false; showDateEnd = false; showDescription = false;
        eventName.setForeground(Config.bgColor_base);
        dateStart.setForeground(Config.bgColor_base);
        dateEnd.setForeground(Config.bgColor_base);
        description.setForeground(Config.bgColor_base);

        panelCan = new JPanel();
        panelCan.setBackground(null);
        back = new RoundedButtonWithColor("BACK", 22,Color.BLACK,Config.primaryColor_base);
        editEvent = new JLabel("             รายละเอียด");

        editEvent.setForeground(Config.primaryColor_hard);
        editEvent.setFont(Config.HEADER_SEMIBOLD[0]);
        editEvent.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        panelHead.add(editEvent,BorderLayout.NORTH);

        panelRek5.add(panelCan);
        panelCan.setLayout( new FlowLayout(FlowLayout.CENTER,93,0));
        back.setPreferredSize(new Dimension((int)((frame.getWidth()-500)/2.7),(frame.getHeight() / 4) - 120));
        panelCan.add(back);
        back.addActionListener(this);

        eventName.setEditable(false);
        dateStart.setEditable(false);
        description.setEditable(false);
        dateEnd.setEditable(false);
        eventType.setEnabled(false);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

//    public static void main(String[] args) {
//        new descriptionPage(Config.createAndShowGUI(),"วันเปิดภาคเรียน", "ภาคการศึกษาที่ 1");
//    }


    public void actionPerformed(ActionEvent ev) {
        if (ev.getSource().equals(back)) {
            frame.getContentPane().removeAll();
            frame.revalidate();
            frame.repaint();
            new CalendarPage(frame);
        }
    }
}
