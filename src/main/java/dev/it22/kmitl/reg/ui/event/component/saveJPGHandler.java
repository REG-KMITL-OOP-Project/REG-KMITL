package dev.it22.kmitl.reg.ui.event.component;

import dev.it22.kmitl.reg.utils.Config;

import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class saveJPGHandler implements ActionListener , MouseListener {
    private JPanel table;
    private JFrame frame;
    private JDialog success;
    public saveJPGHandler(JPanel panel, JFrame frame) {
        this.table = panel;
        this.frame = frame;

        success = Config.openFrame((int) (260), (int) (50));
        success.setResizable(false);
        success.getContentPane().setBackground(Config.primaryColor_hard);
        success.setSize(270, 40);
        success.setResizable(false);
        success.addMouseListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            BufferedImage image = new BufferedImage(table.getWidth(), table.getHeight(), BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = image.createGraphics();
            table.printAll(g2d);
            g2d.dispose();

            //test fileChooser
            try {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Save Image");
            fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("JPG Image", "jpg"));

            int userSelection = fileChooser.showSaveDialog(null);
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                if (!file.getName().toLowerCase().endsWith(".jpg")) {
                    file = new File(file.getAbsolutePath() + ".jpg");
                }
                ImageIO.write(image, "jpg", file);

                JLabel l = new JLabel("Image Saved Successfully", SwingConstants.CENTER);
                l.setBackground(Config.primaryColor_hard);
                l.setForeground(Color.WHITE);
                l.setFont(Config.HEADER_SEMIBOLD[2]);
                l.addMouseListener(this);

                success.add(l);
                success.addMouseListener(this);

                Timer timer = new Timer(1500, new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        success.setVisible(false);
                        success.dispose();
                    }
                });
                timer.setRepeats(false);
                timer.start();
                success.setLocation(frame.getX() + 500,frame.getY() + 600);
                success.setVisible(true);
            }
            else{
                JLabel l = new JLabel("Image Saved Unsuccessful", SwingConstants.CENTER);
                l.setBackground(Config.primaryColor_hard);
                l.setForeground(Color.WHITE);
                l.setFont(Config.HEADER_SEMIBOLD[2]);
                l.addMouseListener(this);

                success.add(l);
                success.addMouseListener(this);

                Timer timer = new Timer(1500, new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        success.setVisible(false);
                        success.dispose();
                    }
                });
                timer.setRepeats(false);
                timer.start();
                success.setLocation(frame.getX() + 500,frame.getY() + 600);
                success.setVisible(true);
            }

        }catch(Exception ex){
            JLabel l = new JLabel("Image Saved Unsuccessful", SwingConstants.CENTER);
            l.setBackground(Config.primaryColor_hard);
            l.setForeground(Color.WHITE);
            l.setFont(Config.HEADER_SEMIBOLD[2]);
            l.addMouseListener(this);

            success.add(l);
            success.addMouseListener(this);

            Timer timer = new Timer(1500, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    success.setVisible(false);
                    success.dispose();
                }
            });
            timer.setRepeats(false);
            timer.start();
            success.setLocation(frame.getX() + 500,frame.getY() + 600);
            success.setVisible(true);

        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        success.setVisible(false);
        success.dispose();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        success.setVisible(false);
        success.dispose();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
