package dev.it22.kmitl.reg.ui.Class_Management.component;

import dev.it22.kmitl.reg.utils.Config;
import dev.it22.kmitl.reg.utils.RoundedButton;
import dev.it22.kmitl.reg.utils.RoundedTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class callData extends JPanel implements FocusListener, ActionListener {
    private RoundedButton showData;
    private RoundedTextField info;
    private boolean showInfo;
    private String text;
    private Color textcolor;

    public callData(String text,String buttonText){
        this(text,Config.bgColor_base,Config.primaryColor_base,buttonText,Color.white,Config.primaryColor_harder);
    }

    public callData(String text,Color textcolor,Color textBackcolor,String buttonText,Color buttoncolor,Color buttonBackcolor){

        info = new RoundedTextField(22);
        showInfo = true;
        info.setText(text);
        info.setForeground(textcolor);
        info.setBackground(textBackcolor);
        info.setFont(Config.NORMAL_REGULAR);
        info.setPreferredSize(new Dimension(300,30));
        info.addFocusListener(this);


        showData = new RoundedButton(buttonText,20);
        showData.setForeground(buttoncolor);
        showData.setBackground(buttonBackcolor);
        showData.setFont(Config.NORMAL_REGULAR);
        showData.addActionListener(this);

        this.text = text;
        this.textcolor = textcolor;

        this.setLayout(new FlowLayout());
        this.setBackground(null);
        this.add(info);
        this.add(showData);
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (e.getSource().equals(info) && showInfo){
            info.setText("");
            info.setForeground(this.textcolor);
            showInfo = false;
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (info.getText().isEmpty()) {
            showInfo = true;
            info.setText(this.text);
            info.setForeground(this.textcolor);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(showData)){
            showInfo = true;
            info.setText(this.text);
            info.setForeground(this.textcolor);
        }
    }
}
