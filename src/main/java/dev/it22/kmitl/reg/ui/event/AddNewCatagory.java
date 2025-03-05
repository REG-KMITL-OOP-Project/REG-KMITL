package dev.it22.kmitl.reg.ui.event;
import dev.it22.kmitl.reg.utils.Config;
import dev.it22.kmitl.reg.utils.CustomCombobox;

import java.awt.*;
import javax.swing.*;

public class AddNewCatagory {
    private JFrame frame;
    private JLabel creat;
    private  JTextField name;
    private  JComboBox color;
    private JButton save,delete;
    private JPanel head,body,btn,blank1,blank2;
    //private Font innerFont, regularFont;
    private String color_s[] = {"red", "green", "pink"};


    public AddNewCatagory(JFrame frame) {
        this.frame = frame;
        creat = new JLabel("              CREAT NEW CATEGORY");
        name = new JTextField("CATEGARY NAME");
        color = new JComboBox(color_s);
        save = new JButton("SAVE");
        delete = new JButton("DELETE");
        head = new JPanel();
        body = new JPanel();
        btn = new JPanel();
        blank1 = new JPanel();
        blank2 = new JPanel();
        //innerFont = regularFont.deriveFont(15f);


        //header
        head.setLayout( new BorderLayout());
        head.setBackground(null);
        head.add(creat,BorderLayout.NORTH);
        creat.setForeground(new Color(255,247,237)); //font color
        creat.setFont(Config.HEADER_SEMIBOLD[1]); //font size
        head.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0)); //creat distance between us
        frame.add(head, BorderLayout.NORTH);

        //body
        //name.setFont(innerFont);
        name.setForeground(Color.GRAY);
        name.setPreferredSize(new Dimension((int)(frame.getWidth() / 1.2),(frame.getHeight() / 4) - 120));

        color.addItem("   CHOOSE CATEGORY");
        //eventType.addItem("   CHOOSE CATEGORY");
        //eventType.addItem("   CHOOSE CATEGORY");
        //eventType.addItem("   CHOOSE CATEGORY");
        //eventType.addItem("   CHOOSE CATEGORY");
        color.setRenderer(new CustomCombobox());
        color.setMaximumRowCount(3);
        color.setFont(Config.NORMAL_REGULAR);
        //color.setFont(innerFont);
        color.setPreferredSize(new Dimension((int)(frame.getWidth() / 1.2),(frame.getHeight() / 4) - 120));


        body.setLayout(new GridLayout(3,1));
        body.setBackground(null);
        body.add(name);
        blank1.setBackground(null);
        body.add(blank1);
        body.add(color);
        frame.add(body, BorderLayout.CENTER);



        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }



    public static void main(String[] args) {
        new AddNewCatagory(Config.createAndShowGUI());
    }
}
