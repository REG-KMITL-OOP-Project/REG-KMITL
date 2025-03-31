package dev.it22.kmitl.reg.ui.event.examSch;

import dev.it22.kmitl.reg.ui.event.classSch.classData;
import dev.it22.kmitl.reg.utils.Config;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.sql.SQLException;

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

    private examTableData aaa;


    public ExamScheduleTable(JFrame frame){
        try{
            aaa = new examTableData();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        regularFont = Config.NORMAL_REGULAR;
        innerFont = regularFont.deriveFont(15f);

        //All about JTable
        DefaultTableModel model = new DefaultTableModel(aaa.getData(), columnNames);
        examSchedule = new JTable(model);
        examSchedule.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        examSchedule.setGridColor(Config.bgColor_hard);
        examSchedule.setShowGrid(true);
        examSchedule.setRowHeight(frame.getWidth() / (frame.getWidth()/40));
        examSchedule.setBorder(BorderFactory.createLineBorder(Config.bgColor_hard));
        examSchedule.setFont(innerFont);

        //header
        JTableHeader header = examSchedule.getTableHeader();
        header.setBackground(Config.primaryColor_hard);
        header.setForeground(Color.WHITE);
        header.setFont(Config.HEADER_SEMIBOLD[3]);
        header.setPreferredSize(new Dimension(frame.getWidth() / (frame.getWidth()/500), frame.getHeight() / (frame.getHeight() /40)));
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
        day.setPreferredWidth(frame.getWidth() / 6);
        //day.setPreferredWidth(200);

        TableColumn time = examSchedule.getColumnModel().getColumn(1);
        time.setPreferredWidth(frame.getWidth() / 7);
        //time.setPreferredWidth(190);

        TableColumn id = examSchedule.getColumnModel().getColumn(2);
        id.setPreferredWidth(frame.getWidth() / 8);
        //id.setPreferredWidth(175);

        TableColumn subject = examSchedule.getColumnModel().getColumn(3);
        subject.setPreferredWidth((frame.getWidth() / 3) - (frame.getWidth() / 31));
        //subject.setPreferredWidth(295);

        TableColumn examType = examSchedule.getColumnModel().getColumn(4);
        examType.setPreferredWidth(frame.getWidth() / 10);
        //examType.setPreferredWidth(146);

        TableColumn room = examSchedule.getColumnModel().getColumn(5);
        room.setPreferredWidth(frame.getWidth() / 10);
        //room.setPreferredWidth(146);

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
