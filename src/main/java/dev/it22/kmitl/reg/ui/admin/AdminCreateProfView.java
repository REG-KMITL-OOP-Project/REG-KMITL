package dev.it22.kmitl.reg.ui.admin;

import dev.it22.kmitl.reg.utils.Config;
import dev.it22.kmitl.reg.utils.RoundedButton;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AdminCreateProfView {
    JFrame frame;
    JPanel upperPanel, lowerPanel, northPanel;
    JPanel panel[][] , pan[];
    JLabel label[][];
    String name[][];
    JTextField txtF[][];
    JTextArea txtA;
    JLabel title,title2;
    RoundedButton btn, backBtn;
    public AdminCreateProfView(JFrame frame) {
        this.frame = frame;
        frame.setLayout(new BorderLayout());

        northPanel = new JPanel(new BorderLayout());
        northPanel.setBackground(null);
        northPanel.setBorder(new EmptyBorder(45, 50, 20, 50));

        upperPanel = new JPanel();
        upperPanel.setLayout(new BoxLayout(upperPanel, BoxLayout.Y_AXIS));
        upperPanel.setBackground(null);
        northPanel.add(upperPanel, BorderLayout.WEST);

        JPanel btnPanelback = new JPanel();
        btnPanelback.setBackground(null);
        btnPanelback.setBorder(new EmptyBorder(0, 20, 0, 0));
        backBtn = new RoundedButton("",20);
        backBtn.setBackground(Config.primaryColor_base);
        backBtn.setIcon(new ImageIcon(new ImageIcon("source/undo.png").getImage().getScaledInstance(45,45,Image.SCALE_SMOOTH)));
        backBtn.setPreferredSize(new Dimension(50,50));
        backBtn.addActionListener(e -> {
            frame.getContentPane().removeAll();
            frame.revalidate();
            frame.repaint();
            new AdminCreateUserPortal(frame);
        });
        btnPanelback.add(backBtn);
        northPanel.add(btnPanelback, BorderLayout.EAST);

        title = new JLabel("สร้างบัญชีผู้ใช้");
        title.setFont(Config.HEADER_SEMIBOLD[0]);
        title.setForeground(Color.WHITE);
        upperPanel.add(title);

        title2 = new JLabel("อาจารย์");
        title2.setFont(Config.HEADER_SEMIBOLD[1]);
        title2.setForeground(Config.primaryColor_base);
        upperPanel.add(title2);

        JPanel panel1 = new JPanel(new BorderLayout());
        panel1.setBackground(null);
        panel1.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
        lowerPanel = new JPanel(new GridLayout(1, 3,20,20));
        lowerPanel.setBorder(new EmptyBorder(10, 20, 20, 20));
        lowerPanel.setBackground(Config.bgColor_hard);

        pan = new JPanel[3];

        panel = new JPanel[3][];
        panel[0] = new JPanel[4];
        panel[1] = new JPanel[4];
        panel[2] = new JPanel[3];

        label = new JLabel[3][];
        label[0] = new JLabel[4];
        label[1] = new JLabel[4];
        label[2] = new JLabel[1];

        txtF = new JTextField[3][];
        txtF[0] = new JTextField[4];
        txtF[1] = new JTextField[4];
        txtF[2] = new JTextField[1];

        name = new String[3][];
        name[0] = new String[]{"e-mail", "Username", "Password","รหัสอาจารย์"};
        name[1] = new String[]{"คำนำหน้า", "ชื่อ", "นามสกุล","คณะ"};
        name[2] = new String[]{"เบอร์โทรศัพท์","ที่อยู่"};

        for(int i = 0; i < 3; i++){
            pan[i] = new JPanel(new GridLayout(4, 1, 20, 15));
            pan[i].setPreferredSize(new Dimension(frame.getWidth()/4, frame.getHeight()/4));
            pan[i].setBackground(null);
            for(int j = 0; j < label[i].length; j++){
                panel[i][j] = new JPanel();
                panel[i][j].setLayout(new BoxLayout(panel[i][j], BoxLayout.Y_AXIS));
                panel[i][j].setBackground(null);
                panel[i][j].setBorder(new EmptyBorder(5, 5, 5, 5));

                label[i][j] = new JLabel(name[i][j]);
                label[i][j].setForeground(Color.WHITE);
                label[i][j].setFont(Config.HEADER_REGULAR[3]);
                label[i][j].setAlignmentX(Component.LEFT_ALIGNMENT);
                label[i][j].setBackground(null);
                panel[i][j].add(label[i][j]);

                txtF[i][j] = new JTextField();
                txtF[i][j].setBackground(null);
                txtF[i][j].setForeground(Color.WHITE);
                txtF[i][j].setFont(Config.HEADER_REGULAR[3]);
                txtF[i][j].setAlignmentX(Component.LEFT_ALIGNMENT);
                txtF[i][j].setBorder(BorderFactory.createLineBorder(Config.primaryColor_base));
                panel[i][j].add(txtF[i][j]);
                
                pan[i].add(panel[i][j]);
            }
            lowerPanel.add(pan[i]);
        }
        panel1.add(lowerPanel,BorderLayout.CENTER);

        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnPanel.setBackground(null);
        btnPanel.setBorder(new EmptyBorder(5, 5, 30, 50));
        btn = new RoundedButton("สร้างบัญชี",20);
        btn.setFont(Config.HEADER_SEMIBOLD[3]);
        btn.setBackground(Config.primaryColor_base);
        btn.setPreferredSize(new Dimension(100, 40));
        btnPanel.add(btn);

        frame.add(northPanel, BorderLayout.NORTH);
        frame.add(btnPanel, BorderLayout.SOUTH);
        frame.add(panel1, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
