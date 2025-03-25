package dev.it22.kmitl.reg.ui.event;

import dev.it22.kmitl.reg.utils.Config;
import javax.swing.*;
import java.awt.*;

public class changeColorCheckbox implements Icon {
    private final Icon orgIcon = UIManager.getIcon("CheckBox.icon");
    private Color color;

    public changeColorCheckbox(Color color){
        this.color = color;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.translate(x, y); //วางตำแหน่งไว้หน้าข้อความ
        orgIcon.paintIcon(c, g2, 0, 0);
        if (c instanceof AbstractButton) {
            AbstractButton b = (AbstractButton) c;
            ButtonModel model = b.getModel();
            g2.setColor(color); //สีพื้นหลังช่อง
            g2.fillRect(-1, -1, getIconWidth()+2 , getIconHeight() +1); //ขยับตำแหน่งให้บังช่อง
            if (model.isSelected()) {
                //วาดติ๊กถูก
                g2.setColor(Color.white); //สีติ๊กถูก
                g2.drawLine(9, 3, 9, 3);
                g2.drawLine(8, 4, 9, 4);
                g2.drawLine(7, 5, 9, 5);
                g2.drawLine(6, 6, 8, 6);
                g2.drawLine(3, 7, 7, 7);
                g2.drawLine(4, 8, 6, 8);
                g2.drawLine(5, 9, 5, 9);
                g2.drawLine(3, 5, 3, 5);
                g2.drawLine(3, 6, 4, 6);
            }
        }
        g2.dispose();
    }

    @Override
    public int getIconWidth() {
        return orgIcon.getIconWidth();
    }

    @Override
    public int getIconHeight() {
        return orgIcon.getIconHeight();
    }
}
