package dev.it22.kmitl.reg.ui.event;
import dev.it22.kmitl.reg.utils.Config;
import dev.it22.kmitl.reg.utils.CustomCombobox;
import dev.it22.kmitl.reg.utils.RoundedButton;

import java.awt.*;
import javax.swing.*;

public class AddNewCatagory {
    private JFrame frame;
    private JLabel creat;
    private  JTextField name;
    private  JComboBox chooseColor;
    private RoundedButton save,delete;
    private JPanel head,body,btn,blank1,allbody,panelDelete,panelSave;
    //private Font innerFont, regularFont;
    private String colorNames[] = {" red", " orange", " yellow"," green", " pink"};
    private Color color[] = {Color.RED,Color.ORANGE,Color.YELLOW,Color.GREEN,Color.PINK};



    public AddNewCatagory(JFrame frame) {
        this.frame = frame;
        creat = new JLabel("              CREAT NEW CATEGORY");
        name = new JTextField("CATEGARY NAME");
        chooseColor = new JComboBox(colorNames);
        save = new RoundedButton("SAVE",22);
        delete = new RoundedButton("DELETE", 22);
        head = new JPanel();
        body = new JPanel();
        btn = new JPanel();
        blank1 = new JPanel();
        //innerFont = regularFont.deriveFont(15f);
        allbody = new JPanel();
        panelDelete = new JPanel();
        panelSave = new JPanel();

        head.setBackground(null);
        body.setBackground(null);
        blank1.setBackground(null);
        allbody.setBackground(null);
        btn.setBackground(null);
        panelSave.setBackground(null);
        panelDelete.setBackground(null);


        //layout-header
        head.setLayout( new BorderLayout());
        head.add(creat,BorderLayout.NORTH);
        creat.setForeground(new Color(255,247,237)); //font color
        creat.setFont(Config.HEADER_SEMIBOLD[1]); //font size
        head.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0)); //creat distance between us
        frame.add(head, BorderLayout.NORTH);


        //body
        allbody.setLayout(new BoxLayout(allbody, BoxLayout.Y_AXIS));
        allbody.add(Box.createVerticalStrut(10));
        //name.setFont(innerFont);
        name.setForeground(Color.GRAY);
        name.setPreferredSize(new Dimension((int)(frame.getWidth() / 1.2),(frame.getHeight() / 4) - 120));

        //choose-color
        chooseColor.setRenderer(new CustomCombobox());
        chooseColor.setMaximumRowCount(3);
        chooseColor.setFont(Config.NORMAL_REGULAR);
        //color.setFont(innerFont);
        chooseColor.setPreferredSize(new Dimension((int)(frame.getWidth() / 1.2),(frame.getHeight() / 4) - 120));


        //layout-body
        body.setLayout(new GridLayout(4,1));
        body.setPreferredSize(new Dimension((int)(frame.getWidth() / 1.2),(frame.getHeight() / 4) - 120));
        body.add(name);
        body.add(blank1);
        body.add(chooseColor);
        body.setBorder(BorderFactory.createEmptyBorder(30, 85, 10, 85));
        allbody.add(body);

        //button-save delete
        allbody.add(btn);
        btn.setLayout(new GridLayout(1, 2));
        btn.add(panelSave);
        panelSave.setLayout( new FlowLayout(FlowLayout.LEFT,85,0));
        save.setForeground(Color.BLACK);
        save.setBackground(new Color(255,247,237));
        save.setFont(Config.HEADER_SEMIBOLD[2]);
        save.setPreferredSize(new Dimension((int)((frame.getWidth()-500)/2.7),(frame.getHeight() / 4) - 120));
        panelSave.add(save);

        btn.add(panelDelete);
        panelDelete.setLayout( new FlowLayout(FlowLayout.RIGHT,85,0));
        delete.setForeground(Color.WHITE);
        delete.setBackground(Config.primaryColor_harder);
        delete.setFont(Config.HEADER_SEMIBOLD[2]);
        delete.setPreferredSize(new Dimension((int)((frame.getWidth()-500)/2.7),(frame.getHeight() / 4) - 120));
        panelDelete.add(delete);

        btn.add(panelSave);
        btn.add(panelDelete);
        frame.add(allbody, BorderLayout.CENTER);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new AddNewCatagory(Config.createAndShowGUI());
    }
}
