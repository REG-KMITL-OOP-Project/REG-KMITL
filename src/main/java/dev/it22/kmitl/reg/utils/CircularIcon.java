package dev.it22.kmitl.reg.utils;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
public class CircularIcon extends JPanel {
    private Image image;

    public CircularIcon(String imagePath) {
        try {
            BufferedImage originalImage = ImageIO.read(new File(imagePath));
            image = createCircular(200,originalImage);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to load image", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private Image createCircular(int size,BufferedImage originalImage) {
        BufferedImage output = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = output.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setComposite(AlphaComposite.Clear);
        g2.setColor(null);
        g2.fillRect(0, 0, size, size);
        g2.setComposite(AlphaComposite.SrcOver);

        Ellipse2D circle = new Ellipse2D.Double(0, 0, size, size);
        g2.setClip(circle);

        g2.drawImage(originalImage, 0, 0, size, size, null);
        g2.dispose();

        return output;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, 125, 0,null, this);
        }
    }
    public Image getImage() {
        return image;
    }
}
