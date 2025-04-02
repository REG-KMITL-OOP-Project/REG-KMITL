package dev.it22.kmitl.reg.ui.Class_Management;

import dev.it22.kmitl.reg.utils.Config;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class TeacherNameTable extends JPanel {
    private JTable name_table;
    private JScrollPane name_scroll;
    private String[] name_column;
    private String[][] name;

    public TeacherNameTable() {
        this("รายชื่ออาจารย์",new String[5], 900);
    }
    public TeacherNameTable(String[] name_data) {
        this("รายชื่ออาจารย์",name_data, 900);
    }
    public TeacherNameTable(String tableName, String[] name_data, int width) {
//        try{
//            UIManager.setLookAndFeel(new FlatLightLaf());
//        } catch (Exception e){
//            e.printStackTrace();
//        }

        name_column = new String[]{tableName};
        name = new String[name_data.length][1];
        for (int i = 0; i < name_data.length; i++) {
            name[i][0] = name_data[i];
        }

        DefaultTableModel model = new DefaultTableModel(name, name_column);
        name_table = new JTable(model);
        name_table.setEnabled(false);
        name_table.setRowHeight(48);
        name_table.setBorder(BorderFactory.createLineBorder(Config.bgColor_base));
        name_table.setGridColor(Config.bgColor_base);
        name_table.setBackground(Color.WHITE);
        name_table.setFont(Config.NORMAL_REGULAR);
        name_table.setForeground(Config.bgColor_harder);


        JTableHeader header = name_table.getTableHeader();
        header.setPreferredSize(new Dimension(width,30));
        header.setBackground(Config.primaryColor_hard);
        header.setForeground(Color.WHITE);
        header.setBorder(null);
        header.setFont(Config.HEADER_SEMIBOLD[3]);
        header.setResizingAllowed(false);
        header.setReorderingAllowed(false);


        DefaultTableCellRenderer Renderer2 = new DefaultTableCellRenderer();
        Renderer2.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < name_table.getColumnCount(); i++) {
            name_table.getColumnModel().getColumn(i).setCellRenderer(Renderer2);
        }
         name_table.getColumnModel().getColumn(0).setPreferredWidth(width);
        name_table.setShowVerticalLines(true);
        name_table.setShowHorizontalLines(true);

        name_scroll = new JScrollPane(name_table);
        name_scroll.setPreferredSize(new Dimension(width, (3 * 48) + 33));
        name_scroll.setBorder(null);
        name_scroll.setBackground(null);
        name_scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        name_scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        this.setLayout(new FlowLayout());
        this.add(name_scroll);
        this.setBackground(null);
        this.setBorder(null);
        this.setPreferredSize(new Dimension(width, (3 * 48) + 30));
    }

    public JTable getName_table() {
        return name_table;
    }
//    public static void main(String[] args) {
//
//        JFrame frame = new JFrame();
//        frame.setLayout(new FlowLayout(FlowLayout.CENTER));
//        frame.add(new teacherNameTable());
//        frame.pack();
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setVisible(true);
//    }
}
