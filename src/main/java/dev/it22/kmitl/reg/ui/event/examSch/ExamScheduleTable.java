package dev.it22.kmitl.reg.ui.event.examSch;

import dev.it22.kmitl.reg.utils.Config;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.awt.*;

public class ExamScheduleTable extends JPanel {

    private Font innerFont, regularFont;
    private JTable examSchedule;
    private JScrollPane scrollPane;
    private String columnNames[] = {"วัน/เดือน/ปี","เวลา", "รหัสวิชา","วิชา","ประเภท","ห้องสอบ"};
    private Object testData[][] = {
            {"DD/MM/YY","09.30-18.00","060111222","OOP","ทฤษฎี","L123"},
            {"DD/MM/YY","09.30-18.00","060111222","OOP","ปฏิบัติ","L123"},
            {"DD/MM/YY","09.30-18.00","060111222","OOP","ปฏิบัติ","L123"},
            {"DD/MM/YY","09.30-18.00","060111222","OOP","ปฏิบัติ","L123"},
            {"DD/MM/YY","09.30-18.00","060111222","OOP","ปฏิบัติ","L123"},
            {"DD/MM/YY","09.30-18.00","060111222","OOP","practical","L123"},
            {"DD/MM/YY","09.30-18.00","060111222","OOP","practical","L123"}
    };


    public ExamScheduleTable(){
        regularFont = Config.NORMAL_REGULAR;
        innerFont = regularFont.deriveFont(15f);

        //All about JTable
        DefaultTableModel model = new DefaultTableModel(testData, columnNames);
        examSchedule = new JTable(model);
        examSchedule.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        examSchedule.setGridColor(Config.bgColor_hard);
        examSchedule.setShowGrid(true);
        examSchedule.setRowHeight(40);
        examSchedule.setBorder(BorderFactory.createLineBorder(Config.bgColor_hard));
        examSchedule.setFont(innerFont);

        //header
        JTableHeader header = examSchedule.getTableHeader();
        header.setBackground(Config.primaryColor_hard);
        header.setForeground(Color.WHITE);
        header.setFont(Config.HEADER_SEMIBOLD[3]);
        header.setPreferredSize(new Dimension(500,40));
        header.setBorder(BorderFactory.createMatteBorder(1, 1, 0, 1, Config.bgColor_hard));

        //ปิดไม่ให้แก้ขนาด & เลื่อนตารางไปมา
        header.setReorderingAllowed(false);
        header.setResizingAllowed(false);

        //จัดข้อความให้อยู่ตรงกลาง
        DefaultTableCellRenderer Renderer = new DefaultTableCellRenderer();
        Renderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < examSchedule.getColumnCount(); i++) {
            examSchedule.getColumnModel().getColumn(i).setCellRenderer(Renderer);
        }

        //เปลี่ยนขนาดช่อง
        TableColumn day = examSchedule.getColumnModel().getColumn(0);
        day.setPreferredWidth(225);

        TableColumn time = examSchedule.getColumnModel().getColumn(1);
        time.setPreferredWidth(225);

        TableColumn id = examSchedule.getColumnModel().getColumn(2);
        id.setPreferredWidth(185);

        TableColumn subject = examSchedule.getColumnModel().getColumn(3);
        subject.setPreferredWidth(225);

        TableColumn examType = examSchedule.getColumnModel().getColumn(4);
        examType.setPreferredWidth(146);

        TableColumn room = examSchedule.getColumnModel().getColumn(5);
        room.setPreferredWidth(146);

        // กำหนดขนาดที่แน่นอน
        examSchedule.setPreferredScrollableViewportSize(new Dimension(
                examSchedule.getPreferredSize().width, examSchedule.getRowHeight() * examSchedule.getRowCount()));


        scrollPane = new JScrollPane(examSchedule);
        examSchedule.setBackground(null);
        scrollPane.setBackground(null);


        this.setLayout(new FlowLayout());
        this.add(scrollPane);
        this.setBackground(null);
    }
}
