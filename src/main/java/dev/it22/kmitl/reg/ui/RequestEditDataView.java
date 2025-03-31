package dev.it22.kmitl.reg.ui;

import dev.it22.kmitl.reg.controller.auth.User;
import dev.it22.kmitl.reg.model.auth.Account;
import dev.it22.kmitl.reg.utils.Config;
import dev.it22.kmitl.reg.utils.RoundedButton;
import dev.it22.kmitl.reg.controller.request.UserRequestController;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;

public class RequestEditDataView {
    private final User user = new User();
    private final Account acc = user.getUserAccount();

    public RequestEditDataView(JFrame frame) {
        JLayeredPane layeredPane = frame.getLayeredPane();
        JDesktopPane desktopPane = new JDesktopPane();
        desktopPane.setOpaque(false);
        desktopPane.setBounds(0, 0, frame.getWidth(), frame.getHeight());
        JInternalFrame internalFrame = new JInternalFrame("", false, true, false, false);
        ((javax.swing.plaf.basic.BasicInternalFrameUI) internalFrame.getUI()).setNorthPane(null);
        internalFrame.setFrameIcon(null);
        internalFrame.setSize(500, 500);
        internalFrame.setLocation(100, 100);
        internalFrame.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        internalFrame.getContentPane().setLayout(new BorderLayout());
        internalFrame.setVisible(true);
        internalFrame.setLocation((desktopPane.getWidth() - internalFrame.getWidth()) / 2, (desktopPane.getHeight() - internalFrame.getHeight()) / 2);
        internalFrame.getContentPane().setBackground(Config.bgColor_hard);

        JPanel upperPanel = new JPanel(new BorderLayout());
        upperPanel.setBackground(Config.bgColor_hard);
        upperPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));

        JLabel titleLabel = new JLabel("ร้องขอเปลี่ยนข้อมูล");
        titleLabel.setFont(Config.HEADER_SEMIBOLD[1]);
        titleLabel.setForeground(Color.WHITE);
        upperPanel.add(titleLabel, BorderLayout.WEST);

        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnPanel.setBackground(null);
        RoundedButton closeBtn = new RoundedButton("", 20);
        closeBtn.setIcon(new ImageIcon(new ImageIcon("source/x.png").getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
        closeBtn.setPreferredSize(new Dimension(30, 30));
        closeBtn.setBackground(Config.primaryColor_base);
        closeBtn.addActionListener(e -> internalFrame.dispose());
        btnPanel.add(closeBtn);
        upperPanel.add(btnPanel, BorderLayout.EAST);
        internalFrame.getContentPane().add(upperPanel, BorderLayout.NORTH);

        JPanel lowerPanel = new JPanel();
        lowerPanel.setLayout(new BoxLayout(lowerPanel, BoxLayout.Y_AXIS));
        lowerPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));
        lowerPanel.setBackground(null);

        JPanel datP = new JPanel(new FlowLayout(FlowLayout.LEFT));
        datP.setBackground(null);
        datP.setPreferredSize(new Dimension(100, 30));
        JLabel dataL = new JLabel("ประเภทของข้อมูลที่ต้องการแก้ไข");
        dataL.setFont(Config.HEADER_SEMIBOLD[3]);
        dataL.setForeground(Color.WHITE);
        datP.add(dataL);
        lowerPanel.add(datP);

        UIManager.put("ComboBox.background", Config.bgColor_hard);
        UIManager.put("ComboBox.foreground", Color.WHITE);
        UIManager.put("ComboBox.selectionBackground", Config.bgColor_hard);
        UIManager.put("CheckBox.border", BorderFactory.createEmptyBorder(0, 10, 0, 10));
        String[] str = {"ที่อยู่", "ชื่อ", "นามสกุล"};
        JComboBox<String> comboBox = new JComboBox<>(str);
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
        lowerPanel.add(comboBox);

        JPanel txtP = new JPanel(new FlowLayout(FlowLayout.LEFT));
        txtP.setBackground(null);
        txtP.setPreferredSize(new Dimension(100, 30));
        JLabel txtL = new JLabel("แก้ไขเป็น");
        txtL.setFont(Config.HEADER_SEMIBOLD[3]);
        txtL.setForeground(Color.WHITE);
        txtP.add(txtL);
        lowerPanel.add(txtP);

        JTextArea txt = new JTextArea();
        txt.setFont(Config.HEADER_SEMIBOLD[3]);
        txt.setBackground(null);
        txt.setForeground(Color.WHITE);
        txt.setBorder(BorderFactory.createLineBorder(Config.primaryColor_base));
        txt.setLineWrap(true);
        lowerPanel.add(txt);

        JPanel btnP = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnP.setBackground(null);
        btnP.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 20));
        RoundedButton changeBtn = new RoundedButton("เปลี่ยน", 20);
        changeBtn.setFont(Config.HEADER_SEMIBOLD[3]);
        changeBtn.setForeground(Color.WHITE);
        changeBtn.setBackground(Config.primaryColor_base);
        changeBtn.setAlignmentX(Component.RIGHT_ALIGNMENT);
        changeBtn.addActionListener(e -> {
            String selectedField = "";
            switch (comboBox.getSelectedItem().toString()) {
                case "ที่อยู่" -> selectedField = "address";
                case "ชื่อ" -> selectedField = "fname";
                case "นามสกุล" -> selectedField = "lname";
            }
            String newValue = txt.getText().trim();
            if (newValue.isEmpty()) {
                JOptionPane.showMessageDialog(null, "กรุณากรอกข้อมูลใหม่!", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }

            String email = acc.getEmail();
            String oldValue = getOldValue(email, selectedField);

            sendRequest(email, selectedField, oldValue, newValue);
        });
        btnP.add(changeBtn);
        internalFrame.getContentPane().add(btnP, BorderLayout.SOUTH);

        internalFrame.getContentPane().add(lowerPanel, BorderLayout.CENTER);
        desktopPane.add(internalFrame);
        layeredPane.add(desktopPane, JLayeredPane.PALETTE_LAYER);
        frame.setVisible(true);
    }

    public void sendRequest(String email, String fieldName, String oldValue, String newValue) {
        UserRequestController userRequestController = new UserRequestController();
        boolean success = userRequestController.sendRequest(email, fieldName, oldValue, newValue);
        if (success) {
            JOptionPane.showMessageDialog(null, "Request sent successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Failed to send request.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public String getOldValue(String email, String fieldName) {
        UserRequestController userRequestController = new UserRequestController();
        return userRequestController.getOldValue(email, fieldName);
    }
}
