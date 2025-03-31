package dev.it22.kmitl.reg.utils;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.io.File;

public class HeaderCellRendererNoBottomLine extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelect, boolean isFocus, int row, int column){
        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelect, isFocus, row, column);
        if(!(column == table.getColumnModel().getColumnCount()-1)){
            label.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.BLACK));
            label.setHorizontalAlignment(SwingConstants.CENTER);
        }else {
            label.setHorizontalAlignment(SwingConstants.LEFT);
        }

        Font normal = new Font(Font.MONOSPACED, Font.PLAIN, 10);
        try {
            normal = Font.createFont(Font.TRUETYPE_FONT, new File("source/Noto_Sans_Thai_Looped/NotoSansThaiLooped-Regular.ttf")).deriveFont(Font.PLAIN, 10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        label.setFont(normal);

        return label;
    }
}
