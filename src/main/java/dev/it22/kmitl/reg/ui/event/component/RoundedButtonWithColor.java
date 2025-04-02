package dev.it22.kmitl.reg.ui.event.component;

import dev.it22.kmitl.reg.utils.Config;
import dev.it22.kmitl.reg.utils.RoundedButton;

import java.awt.*;

public class RoundedButtonWithColor extends RoundedButton {
    public RoundedButtonWithColor(String text, int radius, Color fgColor, Color bgColor) {
        super(text, radius);
        this.setForeground(fgColor);
        this.setBackground(bgColor);
        this.setFont(Config.HEADER_SEMIBOLD[2]);
    }
}
