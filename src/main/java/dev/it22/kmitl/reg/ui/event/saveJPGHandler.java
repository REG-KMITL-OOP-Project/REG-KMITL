package dev.it22.kmitl.reg.ui.event;

import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class saveJPGHandler implements ActionListener {
    private JPanel table;
    private String filename;
    public saveJPGHandler(String filename, JPanel panel) {
        this.table = panel;
        this.filename = filename;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            BufferedImage image = new BufferedImage(table.getWidth(), table.getHeight(), BufferedImage.TYPE_INT_RGB);
            table.printAll(image.createGraphics());
            //test saving
//            ImageIO.write(image, "jpg", new File(filename + ".jpg"));
//            System.out.println("Image saved successfully: " + "table");

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
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
