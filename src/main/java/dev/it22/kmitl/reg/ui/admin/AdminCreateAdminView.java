package dev.it22.kmitl.reg.ui.admin;

import dev.it22.kmitl.reg.controller.user.AdminCreateUser;
import dev.it22.kmitl.reg.utils.Config;
import dev.it22.kmitl.reg.utils.ErrorModal;
import dev.it22.kmitl.reg.utils.RoundedButton;
import dev.it22.kmitl.reg.utils.SuccessModal;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminCreateAdminView {
    JFrame frame;
    JPanel upperPanel, lowerPanel, northPanel;
    JPanel panel[][] , pan[];
    JLabel label[][];
    JComboBox<String> comboBox;
    String name[][];
    JTextField txtF[][];
    JTextArea txtA;
    JLabel title,title2;
    RoundedButton btn, backBtn;
    public AdminCreateAdminView(JFrame frame) {
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

        title2 = new JLabel("เจ้าหน้าที่");
        title2.setFont(Config.HEADER_SEMIBOLD[1]);
        title2.setForeground(Config.primaryColor_base);
        upperPanel.add(title2);

        JPanel panel1 = new JPanel(new BorderLayout());
        panel1.setBackground(null);
        panel1.setBorder(BorderFactory.createEmptyBorder(40, 50, 40, 50));
        lowerPanel = new JPanel(new GridLayout(1, 3,20,20));
        lowerPanel.setBorder(new EmptyBorder(30, 20, 40, 20));
        lowerPanel.setBackground(Config.bgColor_hard);

        pan = new JPanel[3];

        panel = new JPanel[2][];
        panel[0] = new JPanel[3];
        panel[1] = new JPanel[3];

        label = new JLabel[2][];
        label[0] = new JLabel[3];
        label[1] = new JLabel[3];

        txtF = new JTextField[2][];
        txtF[0] = new JTextField[3];
        txtF[1] = new JTextField[3];

        name = new String[2][];
        name[0] = new String[]{"e-mail", "Username", "Password"};
        name[1] = new String[]{"คำนำหน้า", "ชื่อ", "นามสกุล"};

        for(int i = 0; i < 2; i++){
            pan[i] = new JPanel(new GridLayout(3, 1, 20, 15));
            pan[i].setPreferredSize(new Dimension(frame.getWidth()/4, frame.getHeight()/4));
            pan[i].setBackground(null);
                for (int j = 0; j < label[i].length; j++) {
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

                    if ((i == 1 & j == 0) || (i == 1 & j == 3)) {
                        UIManager.put("ComboBox.background", Config.bgColor_hard);
                        UIManager.put("ComboBox.foreground", Color.WHITE);
                        UIManager.put("ComboBox.selectionBackground", Config.bgColor_base);
                        UIManager.put("ComboBox.selectionForeground", Config.primaryColor_hard);
                        UIManager.put("CheckBox.border", BorderFactory.createEmptyBorder(0, 10, 0, 10));

                        String[] str = new String[]{"นาย", "นางสาว", "นาง"};

                        comboBox = new JComboBox<>(str);
                        comboBox.setUI(new BasicComboBoxUI() {
                            @Override
                            protected JButton createArrowButton() {
                                JButton button = new JButton("▼");
                                button.setBackground(null); // เปลี่ยนสีปุ่มเป็นสีแดง
                                button.setForeground(Config.primaryColor_base); // เปลี่ยนสีตัวอักษรเป็นสีขาว
                                button.setBorder(null);
                                return button;
                            }
                        });
                        comboBox.setFont(Config.HEADER_SEMIBOLD[3]);
                        comboBox.setBorder(BorderFactory.createLineBorder(Config.primaryColor_base));
                        comboBox.setAlignmentX(Component.LEFT_ALIGNMENT);
                        comboBox.setForeground(Color.WHITE);
                        panel[i][j].add(comboBox);
                    }else {
                        txtF[i][j] = new JTextField();
                        txtF[i][j].setBackground(null);
                        txtF[i][j].setForeground(Color.WHITE);
                        txtF[i][j].setFont(Config.HEADER_REGULAR[3]);
                        txtF[i][j].setAlignmentX(Component.LEFT_ALIGNMENT);
                        txtF[i][j].setBorder(BorderFactory.createLineBorder(Config.primaryColor_base));
                        panel[i][j].add(txtF[i][j]);
                    }
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
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String email = txtF[0][0].getText();
                    String username = txtF[0][1].getText();
                    String password = txtF[0][2].getText();

                    int prefix;
                    try {
                        prefix = Integer.parseInt(txtF[1][0].getText());
                    } catch (NumberFormatException ex) {
                        prefix = 1;
                    }

                    String fname = txtF[1][1].getText();
                    String lname = txtF[1][2].getText();

                    if (email.isEmpty() || username.isEmpty() || password.isEmpty() ||
                            fname.isEmpty() || lname.isEmpty()) {
                        throw new Exception("กรุณากรอกข้อมูลให้ครบถ้วน");
                    }

                    new AdminCreateUser().createAdmin(email, username, password, prefix,
                            fname, lname);

                    new SuccessModal(frame, "สร้างบัญชีผู้ใช้สำเร็จ");

                } catch (Exception ex) {
                    new ErrorModal(frame, ex.getMessage());
                }
            }
        });
        btnPanel.add(btn);

        frame.add(northPanel, BorderLayout.NORTH);
        frame.add(btnPanel, BorderLayout.SOUTH);
        frame.add(panel1, BorderLayout.CENTER);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        JFrame frame = new  Config().createAndShowGUI();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        new AdminCreateAdminView(frame);
    }
}
