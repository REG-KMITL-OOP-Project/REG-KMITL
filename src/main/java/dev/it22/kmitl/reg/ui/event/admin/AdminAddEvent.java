package dev.it22.kmitl.reg.ui.event.admin;

import dev.it22.kmitl.reg.ui.event.calendar.EventPage;
import dev.it22.kmitl.reg.utils.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AdminAddEvent extends EventPage implements ActionListener {
    private JPanel panelSave,panelDel;
    private RoundedButton cancel,upload;
    private JLabel addEvent;

    public AdminAddEvent (JFrame frame){
        super(frame);
        panelSave = new JPanel();
        panelDel = new JPanel();
        cancel = new RoundedButton("CANCEL",22);
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
        cancel.setForeground(Color.BLACK);
        cancel.setBackground(new Color(255,247,237));
        cancel.setFont(Config.HEADER_SEMIBOLD[2]);
        cancel.setPreferredSize(new Dimension((int)((frame.getWidth()-500)/2.7),(frame.getHeight() / 4) - 120));

        cancel.addActionListener(this);

        panelSave.add(cancel);

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

//    public static void main(String[] args) {
//        new AdminAddEvent (Config.createAndShowGUI());
//    }

    private RoundedButton yes , no ;
    private JDialog dialog ;

    public void actionPerformed(ActionEvent ev){
        if (ev.getSource() == cancel) {

            if (!(eventName.getText().equals("   EVENT NAME") && dateStart.getText().equals("YYYY-MM-DD") && dateEnd.getText().equals("YYYY-MM-DD") && description.getText().equals(("   DESCRIPTION")))){
                dialog = Config.openFrame((int) (frame.getWidth() / 2), (int) (frame.getHeight() / 2));
                JPanel panelD = new JPanel();
                JPanel panelC = new JPanel();
                JPanel panelButton = new JPanel();
                JPanel panelHeader = new JPanel();
                JPanel panelLayoutButton = new JPanel();
                JPanel panelLayoutlHeader = new JPanel();
                JLabel header = new JLabel("ARE YOU SURE WANT TO CANCEL");
                yes = new RoundedButtonWithColor("YES", 22,Color.WHITE,Config.primaryColor_harder);
                no = new RoundedButtonWithColor("NO", 22,Color.BLACK,new Color(255, 247, 237));

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
                yes.setPreferredSize(new Dimension((int) ((frame.getWidth() - 500) / 3.5), (frame.getHeight() / 4) - 120));
                panelD.add(yes);
                yes.addActionListener(this);

                panelC.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 0));
                no.setPreferredSize(new Dimension((int) ((frame.getWidth() - 500) / 3.5), (frame.getHeight() / 4) - 120));
                panelC.add(no);
                no.addActionListener(this);

                panelButton.setLayout(new GridLayout(1, 2));
                panelButton.add(panelC);
                panelButton.add(panelD);
                panelLayoutButton.setLayout(new BoxLayout(panelLayoutButton, BoxLayout.Y_AXIS));
                panelLayoutButton.add(panelButton);
                panelLayoutButton.add(Box.createVerticalStrut(100));
                dialog.add(panelLayoutButton,BorderLayout.SOUTH);

                dialog.setVisible(true);
            }
            else{
                frame.getContentPane().removeAll();
                frame.revalidate();
                frame.repaint();
                new AdminCalendarPage (frame);
            }
        }else if (ev.getSource().equals(no)) {
            dialog.setVisible(false);
        }else if (ev.getSource().equals(yes) || ev.getSource().equals(upload)){
            if(ev.getSource().equals(upload)){
                if (eventName.getText().equals("   EVENT NAME") || dateStart.getText().equals("YYYY-MM-DD") || dateEnd.getText().equals("YYYY-MM-DD") || description.getText().equals(("   DESCRIPTION"))){
                    new ErrorModal(frame, "กรุณากรอกข้อมูลให้ครบถ้วน");
                    return;
                }
                else{

                    if (dateStart.getText().equals(dateEnd.getText())){
                        new AddDataEvent(eventName.getText(), description.getText(), dateStart.getText(), ((String) eventType.getSelectedItem()).strip());
                    }else {
                        new AddDataEvent(eventName.getText(), description.getText(), dateStart.getText(), ((String) eventType.getSelectedItem()).strip());
                        new AddDataEvent(eventName.getText(), description.getText(), dateEnd.getText(), ((String) eventType.getSelectedItem()).strip());
                    }
                }
            }
            frame.getContentPane().removeAll();
            frame.revalidate();
            frame.repaint();
            new AdminCalendarPage (frame);

            if (ev.getSource().equals(yes)) {
                dialog.setVisible(false);
            }
        }

    }
}

