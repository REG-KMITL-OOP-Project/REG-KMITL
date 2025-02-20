package dev.it22.kmitl.reg;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedButton extends JButton {
    private int radius;

    public RoundedButton(String text, int radius) {
        super(text);
        this.radius = radius;
        setContentAreaFilled(false); // No default background
        setFocusPainted(false); // No focus border
        setBorderPainted(false); // Remove default border
        setOpaque(false); // Ensure transparency
        setHorizontalTextPosition(SwingConstants.CENTER); // Center text & icon
        setVerticalTextPosition(SwingConstants.BOTTOM);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw the button background
        if (getModel().isPressed()) {
            g2.setColor(getBackground().darker()); // Darker shade when pressed
//        } else if (getModel().isRollover()) {
//            g2.setColor(getBackground().brighter()); // Brighter shade when hovered
        } else {
            g2.setColor(getBackground()); // Normal background color
        }

        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);

        super.paintComponent(g2); // Paint text and icon
        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(getForeground());
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);

        g2.dispose();
    }

    @Override
    public boolean contains(int x, int y) {
        return new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), radius, radius).contains(x, y);
    }
}

