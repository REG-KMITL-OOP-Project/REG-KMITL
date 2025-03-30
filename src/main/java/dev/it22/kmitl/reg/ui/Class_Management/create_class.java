package dev.it22.kmitl.reg.ui.Class_Management;
import dev.it22.kmitl.reg.utils.Config;
import dev.it22.kmitl.reg.utils.RoundedButton;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class create_class implements ActionListener{
    private JFrame frame;
    private JButton home;
    private JPanel ICON,setposition,lowerPanel,tableButton,Buttonpanel,keeptext,setpositext;
    private JTable table;
    private JLabel text;
    private JScrollPane scrollPane;
    private DefaultTableModel tableModel;
    private RoundedButton enter_classButton,create_classButton;
    private String columnNames[] = {"รหัสวิชา","ชื่อวิชา","กลุ่มเรียน","อาจารย์ผู้สอน"};

    public create_class(JFrame frame){
        this.frame = frame;
        //Icon home
        ImageIcon homeIcon = new ImageIcon(new ImageIcon("source/icon_schedule/icon_home.png").getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH));
        home = new JButton(homeIcon);
        home.setBorderPainted(false);
        home.setContentAreaFilled(false);
        home.setFocusPainted(false);
        home.addActionListener(this);

        ImageIcon logo = new ImageIcon(new ImageIcon("source/Logo.png").getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH));
        JLabel regLabel = new JLabel(logo);
        ICON = new JPanel();
        ICON.setLayout(new FlowLayout());
        ICON.add(home);
        ICON.add(regLabel);
        ICON.setBackground(null);

        //SETPOSITION HOME BUTTON
        setposition = new JPanel();
        setposition.setLayout(new BorderLayout());
        setposition.add(ICON, BorderLayout.WEST);
        setposition.setBackground(null);

        //สร้างข้อความบอกหน้า
        text = new JLabel("สร้างชั้นเรียน");
        text.setFont(Config.HEADER_SEMIBOLD[2]);
        text.setForeground(Color.ORANGE);

        //เก็บข้อความไว้
        keeptext = new JPanel();
        keeptext.setLayout(new FlowLayout());
        keeptext.add(text);
        keeptext.setBackground(null);

        //สร้างปุ่มและตั้งค่าฟอนและสี
        enter_classButton = new RoundedButton("เข้าชั้นเรียน",22);
        enter_classButton.setFont(Config.HEADER_SEMIBOLD[2]);
        enter_classButton.setForeground(Color.BLACK);
        enter_classButton.setBackground(Config.primaryColor_base);
        enter_classButton.setEnabled(false);  // ปุ่มจะถูกปิดใช้งานเมื่อไม่มีแถวที่เลือก
        enter_classButton.addActionListener(this);

        create_classButton = new RoundedButton("สร้างชั้นเรียน",22);
        create_classButton.setFont(Config.HEADER_SEMIBOLD[2]);
        create_classButton.setForeground(Color.BLACK);
        create_classButton.setBackground(Config.primaryColor_base);
        create_classButton.addActionListener(this);

        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        table = new JTable(tableModel);
        table.setBackground(Config.bgColor_hard);
        table.setForeground(Color.WHITE);
        JTableHeader header = table.getTableHeader();
        table.setRowHeight(40);
        header.setFont(Config.HEADER_SEMIBOLD[2]);
        table.getTableHeader().setReorderingAllowed(false);
        table .getTableHeader().setResizingAllowed(false);


        Buttonpanel = new JPanel();
        Buttonpanel.setLayout(new FlowLayout());
        Buttonpanel.add(enter_classButton);
        Buttonpanel.add(create_classButton);
        Buttonpanel.setBackground(null);

        scrollPane = new JScrollPane(table);
        lowerPanel = new JPanel();
        lowerPanel.setLayout(new FlowLayout());
        lowerPanel.add(scrollPane);
        lowerPanel.setBackground(null);

        tableButton = new JPanel();
        tableButton.setLayout(new BorderLayout());
        tableButton.add(lowerPanel,BorderLayout.CENTER);
        tableButton.add(Buttonpanel,BorderLayout.SOUTH);
        tableButton.setBackground(null);

        setpositext = new JPanel();
        setpositext.setLayout(new BorderLayout());
        setpositext.add(keeptext,BorderLayout.NORTH);
        setpositext.add(tableButton,BorderLayout.CENTER);
        setpositext.setBackground(null);

        frame.setLayout(new BorderLayout());
        frame.add(setposition,BorderLayout.NORTH);
        frame.add(setpositext,BorderLayout.CENTER);
        frame.setBackground(null);
        frame.setSize(1000,700);
        frame.setVisible(true);

        // Set Row Selection Listener
        table.getSelectionModel().addListSelectionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                enter_classButton.setEnabled(true);
            } else {
                enter_classButton.setEnabled(false);
            }
        });

    }
    public static void main(String[] args) {
    new create_class(Config.createAndShowGUI());
}

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(enter_classButton)){
            frame.getContentPane().removeAll();
            frame.revalidate();
            frame.repaint();
            new View_subject(frame);
        }else if(e.getSource().equals(create_classButton)){
            frame.getContentPane().removeAll();
            frame.revalidate();
            frame.repaint();
            new AdminAddClassroom(frame);
        }
    }
}
