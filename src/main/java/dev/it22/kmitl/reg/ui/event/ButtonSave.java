package dev.it22.kmitl.reg.ui.event;

import dev.it22.kmitl.reg.utils.Config;
import dev.it22.kmitl.reg.utils.RoundedButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonSave extends RoundedButton {
    public ButtonSave(String text,int radius) {
        super(text, radius);
        this.setForeground(new Color(255, 247, 237));
        this.setBackground(Config.primaryColor_base);
        this.setFont(Config.HEADER_SEMIBOLD[2]);
    }
}
