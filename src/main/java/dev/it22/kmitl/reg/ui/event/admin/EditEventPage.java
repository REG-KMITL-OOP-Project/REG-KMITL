
package dev.it22.kmitl.reg.ui.event.admin;
import dev.it22.kmitl.reg.ui.event.calendar.EventPage;
import dev.it22.kmitl.reg.utils.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class EditEventPage extends EventPage implements ActionListener {
    private JPanel panelSave,panelDel,panelCan;
    private RoundedButtonWithColor delete,save,cancel;
    private JLabel editEvent;
    private ArrayList<String> list;

    private boolean oneRecord = false;
    public EditEventPage(JFrame frame, String name, String type){
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
        eventName.setForeground(Color.black);
        dateStart.setForeground(Color.black);
        dateEnd.setForeground(Color.black);
        description.setForeground(Color.black);

        panelSave = new JPanel();
        panelDel = new JPanel();
        panelCan = new JPanel();
        delete = new RoundedButtonWithColor("DELETE", 22, new Color(255, 247, 237), Config.primaryColor_harder);
        cancel = new RoundedButtonWithColor("CANCEL", 22,Color.BLACK,new Color(255, 247, 237));
        save = new RoundedButtonWithColor("SAVE CHANGE",22, new Color(255, 247, 237), Config.primaryColor_base);
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
        cancel.setPreferredSize(new Dimension((int)((frame.getWidth()-500)/2.7),(frame.getHeight() / 4) - 120));
        panelCan.add(cancel);
        cancel.addActionListener(this);

        panelRek5.add(panelSave);
        panelSave.setLayout(new FlowLayout(FlowLayout.CENTER, 93, 0));
        save.setPreferredSize(new Dimension((int) ((frame.getWidth() - 500) / 2.7), (frame.getHeight() / 4) - 120));
        panelSave.add(save);
        save.addActionListener(this);

        panelRek5.add(panelDel);
        panelDel.setLayout( new FlowLayout(FlowLayout.RIGHT,93,0));
        delete.setPreferredSize(new Dimension((int)((frame.getWidth()-500)/2.7),(frame.getHeight() / 4) - 120));
        panelDel.add(delete);
        delete.addActionListener(this);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //new EditEventPage(Config.createAndShowGUI());
    }

    private RoundedButtonWithColor del , cal ;
    private JDialog dialog ;

    public void actionPerformed(ActionEvent ev) {
        if (ev.getSource() == delete) {
            dialog = Config.openFrame((int) (frame.getWidth() / 2), (int) (frame.getHeight() / 2));
            JPanel panelD = new JPanel();
            JPanel panelC = new JPanel();
            JPanel panelButton = new JPanel();
            JPanel panelHeader = new JPanel();
            JPanel panelLayoutButton = new JPanel();
            JPanel panelLayoutlHeader = new JPanel();
            JLabel header = new JLabel("ARE YOU SURE WANT TO DELETE");
            del = new RoundedButtonWithColor("DELETE", 22,Color.WHITE,Config.primaryColor_harder);
            cal = new RoundedButtonWithColor("CANCEL", 22,Color.BLACK,new Color(255, 247, 237));

            panelC.setBackground(null);
            panelD.setBackground(null);
            panelHeader.setBackground(null);
            panelButton.setBackground(null);
            panelLayoutButton.setBackground(null);
            panelLayoutlHeader.setBackground(null);

            dialog.setLayout(new BorderLayout());
            panelLayoutlHeader.setLayout(new FlowLayout());
            panelLayoutlHeader.add(header);
            header.setForeground(Config.primaryColor_hard);
            header.setFont(Config.HEADER_SEMIBOLD[1]);
            panelHeader.setLayout(new BoxLayout(panelHeader, BoxLayout.Y_AXIS));
            panelHeader.add(Box.createVerticalStrut(75));
            panelHeader.add(panelLayoutlHeader);
            dialog.add(panelHeader,BorderLayout.NORTH);

            panelD.setLayout(new FlowLayout(FlowLayout.RIGHT, 30, 0));
            del.setPreferredSize(new Dimension((int) ((frame.getWidth() - 500) / 3.5), (frame.getHeight() / 4) - 120));
            panelD.add(del);
            del.addActionListener(this);

            panelC.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 0));
            cal.setPreferredSize(new Dimension((int) ((frame.getWidth() - 500) / 3.5), (frame.getHeight() / 4) - 120));
            panelC.add(cal);
            cal.addActionListener(this);

            panelButton.setLayout(new GridLayout(1, 2));
            panelButton.add(panelC);
            panelButton.add(panelD);
            panelLayoutButton.setLayout(new BoxLayout(panelLayoutButton, BoxLayout.Y_AXIS));
            panelLayoutButton.add(panelButton);
            panelLayoutButton.add(Box.createVerticalStrut(100));
            dialog.add(panelLayoutButton,BorderLayout.SOUTH);

            dialog.setVisible(true);
        }else if (ev.getSource().equals(cal) || ev.getSource().equals(del)) {
            dialog.setVisible(false);
        }if (ev.getSource().equals(del) || ev.getSource().equals(cancel)) {
            if (ev.getSource().equals(del)){
                if (oneRecord){
                    new EditDataEvent().deleteData((Integer.valueOf(list.get(4))));
                } else {
                    new EditDataEvent().deleteData((Integer.valueOf(list.get(4))),Integer.valueOf(list.get(6)));
                }
            }
            frame.getContentPane().removeAll();
            frame.revalidate();
            frame.repaint();
            new AdminCalendarPage(frame);
        }else if (ev.getSource().equals(save)) {
            if (eventName.getText().equals("   EVENT NAME") || dateStart.getText().equals("YYYY-MM-DD") || dateEnd.getText().equals("YYYY-MM-DD") || description.getText().equals(("   DESCRIPTION"))){
                new ErrorModal(frame, "กรุณากรอกข้อมูลให้ครบถ้วน");
            } else {
                if (dateStart.getText().equals(dateEnd.getText())){
                    new EditDataEvent().changeData((Integer.valueOf(list.get(4))),eventName.getText(),description.getText(),dateStart.getText(),((String) eventType.getSelectedItem()).strip());
                    if(!oneRecord){
                        new EditDataEvent().deleteData((Integer.valueOf(list.get(6))));
                    }
                }else{
                    if (oneRecord){
                        new EditDataEvent().changeData((Integer.valueOf(list.get(4))),eventName.getText(),description.getText(),dateStart.getText(),((String) eventType.getSelectedItem()).strip());
                        new AddDataEvent(eventName.getText(),description.getText(),dateEnd.getText(),((String) eventType.getSelectedItem()).strip());
                    }else {
                        new EditDataEvent().changeData((Integer.valueOf(list.get(4))), Integer.valueOf(list.get(6)), eventName.getText(), description.getText(), dateStart.getText(), dateEnd.getText(), ((String) eventType.getSelectedItem()).strip());
                    }
                }
                frame.getContentPane().removeAll();
                frame.revalidate();
                frame.repaint();
                new AdminCalendarPage (frame);
            }

        }
    }
}
