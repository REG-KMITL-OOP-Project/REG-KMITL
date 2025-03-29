package dev.it22.kmitl.reg.ui.transcript;

import dev.it22.kmitl.reg.controller.auth.User;
import dev.it22.kmitl.reg.model.auth.Account;
import dev.it22.kmitl.reg.utils.Config;
import dev.it22.kmitl.reg.utils.RoundedButton;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class TranscriptView {
    private JFrame frame;
    private JPanel mainPanel, transcriptPanel, centerPanel, topLeftPanel, topMidPanel, topRightPanel, topPanel, bottomPanel, textPanel1, textPanel2, unVisiblePanel1, buttonPanel;
    private JLabel transcHeader, transcSubHeader;
    private JButton homeButton;
    private RoundedButton download;
    private ImageIcon homeIcon;

    private String name ,
            dateOB ,
            dateOA,
            degree,
            major,
            studentID,
            dateOG = "N/A";

    private String []semester;
    private String [][] subject;
    private String[][] subjectNumberList;
    private int[][] creditsList;
    private String[][] gradeList;

    public TranscriptView(JFrame frame) {
        this.frame = frame;

        transcHeader = new JLabel("Transcript", SwingConstants.CENTER);
        transcHeader.setFont(Config.HEADER_SEMIBOLD[0]);
        transcHeader.setForeground(Config.primaryColor_hard);

        transcSubHeader = new JLabel("ทรานสคริปต์จำลอง (Unofficial Transcript)");
        transcSubHeader.setFont(Config.HEADER_SEMIBOLD[3]);
        transcSubHeader.setForeground(new Color(255, 255, 255));

        mainPanel = new JPanel();
        transcriptPanel = new JPanel();
        topPanel = new JPanel();
        topLeftPanel = new JPanel();
        topMidPanel = new JPanel();
        topRightPanel = new JPanel();
        centerPanel = new JPanel();
        bottomPanel = new JPanel();
        textPanel1 = new JPanel();
        textPanel2 = new JPanel();
        unVisiblePanel1 = new JPanel();
        buttonPanel = new JPanel();
        homeIcon = new ImageIcon(new ImageIcon("source/icon_schedule/icon_home_re.png").getImage().getScaledInstance(frame.getWidth()/30, frame.getWidth()/30, Image.SCALE_SMOOTH));
        download = new RoundedButton("DOWNLOAD", 20);
        homeButton = new JButton(homeIcon);

        mainPanel.setBackground(null);
        topPanel.setBackground(null);
        topLeftPanel.setBackground(null);
        topMidPanel.setBackground(null);
        topRightPanel.setBackground(null);
        centerPanel.setBackground(null);
        bottomPanel.setBackground(null);
        textPanel1.setBackground(null);
        textPanel2.setBackground(null);
        unVisiblePanel1.setBackground(null);
        buttonPanel.setBackground(null);
    }

    public RoundedButton getDownloadButton() {
        return download;
    }
    public JButton getHomeButton() {return homeButton;}
    public JFrame getFrame() {return frame;}

    public void generateView() {

        homeButton.setBackground(null);
        homeButton.setBounds(10,10,frame.getWidth()/30, frame.getWidth()/30);
        homeButton.setBorderPainted(false);
        homeButton.setFocusPainted(false);

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(topPanel);
        mainPanel.add(centerPanel);
        mainPanel.add(bottomPanel);

        topPanel.setLayout(new GridLayout(1,3));
        topPanel.add(topLeftPanel);
        topPanel.add(topMidPanel);
        topPanel.add(topRightPanel);
        topLeftPanel.setLayout(null);
        topLeftPanel.add(homeButton);
        topMidPanel.setLayout(new BoxLayout(topMidPanel, BoxLayout.Y_AXIS));
        topMidPanel.add(Box.createVerticalStrut(5));
        topMidPanel.add(textPanel1);
        topMidPanel.add(textPanel2);

        centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        transcriptPanel.setPreferredSize(new Dimension((int) (frame.getHeight()/1.368316831683168), (int)(frame.getHeight()/1.368316831683168) ));
        transcriptPanel.setSize(new Dimension((int) (frame.getHeight()/1.368316831683168), (int)(frame.getHeight()/1.368316831683168) ));
        centerPanel.add(transcriptPanel);

        generateTranscript(transcriptPanel);

        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
        bottomPanel.setSize(frame.getWidth()/30, frame.getWidth()/30);
        bottomPanel.add(unVisiblePanel1);
        bottomPanel.add(buttonPanel);
        unVisiblePanel1.setPreferredSize(new Dimension(frame.getWidth(),frame.getHeight()/300));

        buttonPanel.add(download);
        buttonPanel.setPreferredSize(new Dimension((frame.getWidth()),frame.getHeight()/10));
        download.setBackground(Config.primaryColor_hard);
        download.setForeground(new Color(255, 255, 255));
        download.setFont(Config.HEADER_SEMIBOLD[2]);
        download.setPreferredSize(new Dimension((int) (frame.getHeight()/1.368316831683168),frame.getHeight()/12));

        textPanel1.add(transcHeader);
        textPanel1.setPreferredSize(new Dimension(frame.getWidth(),frame.getHeight()/17));
        textPanel2.add(transcSubHeader);
        frame.getContentPane().add(mainPanel);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void setData(String name,String dateOB,String dateOA,String degree, String major, String studentID, String[] semester, String [][] subject, String[][] subjectNumberList, int[][] creditsList, String[][] gradeList ){
        this.name=name;
        this.dateOB=dateOB;
        this.dateOA=dateOA;
        this.degree=degree;
        this.major=major;
        this.studentID=studentID;
        this.semester=semester;
        this.subject=subject;
        this.subjectNumberList=subjectNumberList;
        this.creditsList=creditsList;
        this.gradeList=gradeList;
    }

    public void generateTranscript(JPanel parentPanel){
        Font normal = new Font(Font.MONOSPACED, Font.PLAIN, 10);
        try {
            normal = Font.createFont(Font.TRUETYPE_FONT, new File("source/Noto_Sans_Thai_Looped/NotoSansThaiLooped-Regular.ttf")).deriveFont(Font.PLAIN, 10);
        } catch (Exception e) {
            e.printStackTrace();
        }

        parentPanel.setLayout(new BoxLayout(parentPanel, BoxLayout.Y_AXIS));
        parentPanel.setAlignmentY(Component.TOP_ALIGNMENT);
        JLabel header = new JLabel("Unofficial Transcript", SwingConstants.CENTER);
        JLabel studentName = new JLabel("Name   " +name, SwingConstants.LEFT);
        JLabel dateOb = new JLabel("Date of Birth   " + dateOB);
        JLabel dateOa = new JLabel("Date of Admission   " +dateOA);
        JLabel degreeLabel = new JLabel("Degree   " + degree);
        JLabel majorLabel = new JLabel("Major   " + major);
        JLabel studentIDLabel = new JLabel("Student ID   " +studentID);
        JLabel dateOG = new JLabel("Date of Graduation   N/A");
        JPanel inParent = new JPanel();
        JPanel centerInParent = new JPanel();
        JPanel flowZeroParent = new JPanel();
        JPanel flowOneParent = new JPanel();
        JPanel flowTwoParent = new JPanel();

        System.out.println(dateOB);
        inParent.add(header);
        header.setFont(Config.HEADER_SEMIBOLD[3]);
        header.setPreferredSize(new Dimension(parentPanel.getPreferredSize().width, header.getPreferredSize().height));

        studentName.setFont(normal);

        flowZeroParent.setLayout(new FlowLayout(FlowLayout.LEFT));
        flowZeroParent.add(studentName);
        studentName.setPreferredSize(new Dimension(studentName.getPreferredSize().width+10, studentName.getPreferredSize().height));
        flowZeroParent.setPreferredSize(new Dimension(flowZeroParent.getPreferredSize().width, flowZeroParent.getPreferredSize().height-7));

        flowOneParent.setLayout(new FlowLayout(FlowLayout.LEFT));
        dateOb.setFont(normal);
        studentIDLabel.setFont(normal);
        flowOneParent.add(dateOb);
        flowOneParent.add(studentIDLabel);
        dateOb.setPreferredSize(new Dimension(parentPanel.getPreferredSize().width/2, dateOb.getPreferredSize().height));
        studentIDLabel.setPreferredSize(new Dimension(studentIDLabel.getPreferredSize().width, studentIDLabel.getPreferredSize().height));
        flowOneParent.setPreferredSize(new Dimension(flowOneParent.getPreferredSize().width, flowOneParent.getPreferredSize().height-5));

        flowTwoParent.setLayout(new FlowLayout(FlowLayout.LEFT));
        dateOa.setFont(normal);
        dateOG.setFont(normal);
        flowTwoParent.add(dateOa);
        flowTwoParent.add(dateOG);
        flowTwoParent.setBackground(Config.primaryColor_hard);
        dateOa.setPreferredSize(new Dimension((int) (parentPanel.getPreferredSize().width/2), dateOa.getPreferredSize().height));
        dateOG.setPreferredSize(new Dimension(dateOG.getPreferredSize().width, dateOa.getPreferredSize().height));
        flowTwoParent.setPreferredSize(new Dimension(parentPanel.getPreferredSize().width,  (int) ( frame.getHeight()/1.5)));

        parentPanel.add(inParent);
        parentPanel.add(flowZeroParent);
        parentPanel.add(flowOneParent);
        parentPanel.add(flowTwoParent);

        // กำหนดหัวคอลัมน์
        String[] columnNames = {"COURSE TITLE", "CREDIT", "GRADE", "COURSE TITLE", "CREDIT", "GRADE"};

        // สร้างข้อมูลตัวอย่าง
        Object[][] data = {
                {"Math", 3, "A", "Science", 4, "B+"},
                {"History", 2, "B", "English", 3, "A-"},
                {"Physics", 4, "C+", "Chemistry", 4, "B"}
        };

        // สร้าง JTable พร้อมโมเดลข้อมูล
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(model);

        // ใส่ JTable ลงใน JScrollPane เพื่อให้เลื่อนดูได้
        JScrollPane scrollPane = new JScrollPane(table);

        parentPanel.add(scrollPane);
    }
}
