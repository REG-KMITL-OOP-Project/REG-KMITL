package dev.it22.kmitl.reg.ui.transcript;

import dev.it22.kmitl.reg.controller.auth.User;
import dev.it22.kmitl.reg.model.auth.Account;
import dev.it22.kmitl.reg.utils.Config;
import dev.it22.kmitl.reg.utils.HeaderCellRendererNoBottomLine;
import dev.it22.kmitl.reg.utils.RoundedButton;
import dev.it22.kmitl.reg.utils.TableCellRendererNoBottomLine;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

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
    private ArrayList<ArrayList<String>> subject;
    private ArrayList<ArrayList<String>> subjectNumberList;
    private ArrayList<ArrayList<String>> creditsList;
    private ArrayList<ArrayList<String>> gradeList;

    public TranscriptView(JFrame frame) {

        UIManager.put("TableHeader.hoverBackground", Color.white);
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
        transcriptPanel.setPreferredSize(new Dimension((int) (frame.getHeight()/1.368316831683168/1.414285714285714), (int)(frame.getHeight()/1.368316831683168) ));
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
        download.setPreferredSize(new Dimension((int) (frame.getHeight()/1.368316831683168/1.414285714285714),frame.getHeight()/12));

        textPanel1.add(transcHeader);
        textPanel1.setPreferredSize(new Dimension(frame.getWidth(),frame.getHeight()/17));
        textPanel2.add(transcSubHeader);
        frame.getContentPane().add(mainPanel);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void setData(String name, String dateOB, String dateOA, String degree, String major, String studentID, String[] semester, ArrayList<ArrayList<String>> subject, ArrayList<ArrayList<String>> subjectNumberList, ArrayList<ArrayList<String>> creditsList, ArrayList<ArrayList<String>> gradeList ){
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
        JPanel flowThreeParent = new JPanel();
        JPanel flowFourParent = new JPanel();

        inParent.add(header);
        header.setFont(Config.HEADER_SEMIBOLD[3]);
        header.setPreferredSize(new Dimension(parentPanel.getPreferredSize().width, header.getPreferredSize().height));

        studentName.setFont(normal);

        inParent.setBackground(null);
        flowZeroParent.setBackground(null);
        flowOneParent.setBackground(null);
        flowTwoParent.setBackground(null);
        flowThreeParent.setBackground(null);
        flowFourParent.setBackground(null);

        flowZeroParent.setLayout(new FlowLayout(FlowLayout.LEFT,10,0));
        flowZeroParent.add(studentName);
        studentName.setPreferredSize(new Dimension(studentName.getPreferredSize().width+10, studentName.getPreferredSize().height));
        flowZeroParent.setPreferredSize(new Dimension(flowZeroParent.getPreferredSize().width, flowZeroParent.getPreferredSize().height));

        flowOneParent.setLayout(new FlowLayout(FlowLayout.LEFT,10,0));
        dateOb.setFont(normal);
        studentIDLabel.setFont(normal);
        flowOneParent.add(dateOb);
        flowOneParent.add(studentIDLabel);
        dateOb.setPreferredSize(new Dimension(parentPanel.getPreferredSize().width/2, dateOb.getPreferredSize().height));
        studentIDLabel.setPreferredSize(new Dimension(studentIDLabel.getPreferredSize().width, studentIDLabel.getPreferredSize().height));
        flowOneParent.setPreferredSize(new Dimension(flowOneParent.getPreferredSize().width, flowOneParent.getPreferredSize().height));

        flowTwoParent.setLayout(new FlowLayout(FlowLayout.LEFT,10,0));
        dateOa.setFont(normal);
        dateOG.setFont(normal);
        flowTwoParent.add(dateOa);
        flowTwoParent.add(dateOG);
        dateOa.setPreferredSize(new Dimension((int) (parentPanel.getPreferredSize().width/2), dateOa.getPreferredSize().height));
        dateOG.setPreferredSize(new Dimension(dateOG.getPreferredSize().width, dateOa.getPreferredSize().height));
        flowTwoParent.setPreferredSize(new Dimension(parentPanel.getPreferredSize().width,  flowTwoParent.getPreferredSize().height));

        flowThreeParent.setLayout(new FlowLayout(FlowLayout.LEFT,10,0));
        degreeLabel.setFont(normal);
        flowThreeParent.add(degreeLabel);
        degreeLabel.setPreferredSize(new Dimension((int) (parentPanel.getPreferredSize().width/2), degreeLabel.getPreferredSize().height));
        flowThreeParent.setPreferredSize(new Dimension(parentPanel.getPreferredSize().width,  flowThreeParent.getPreferredSize().height));


        flowFourParent.setLayout(new FlowLayout(FlowLayout.LEFT,10,0));
        majorLabel.setFont(normal);
        flowFourParent.add(majorLabel);
        majorLabel.setPreferredSize(new Dimension((int) (parentPanel.getPreferredSize().width/2), majorLabel.getPreferredSize().height));
        flowFourParent.setPreferredSize(new Dimension(parentPanel.getPreferredSize().width,  flowFourParent.getPreferredSize().height));

        //flowThreeParent.setPreferredSize(new Dimension(parentPanel.getPreferredSize().width,  (int) ( frame.getHeight()/1.5)));

        parentPanel.add(inParent);
        parentPanel.add(flowZeroParent);
        parentPanel.add(flowOneParent);
        parentPanel.add(flowTwoParent);
        parentPanel.add(flowThreeParent);
        parentPanel.add(flowFourParent);

        String[] columnNames = {"COURSE TITLE", "CREDIT", "GRADE", "COURSE TITLE", "CREDIT", "GRADE"};

        int allCredit = 0;
        ArrayList<String> gpsList =  new ArrayList<>();
        for (int i = 0; i < creditsList.size(); i++) {
            double gps1 = 0.0;
            double credit1 = 0.0;
            for (int k = 0; k < creditsList.get(i).size(); k++) {
                credit1 += Double.parseDouble(creditsList.get(i).get(k));
                allCredit += Integer.parseInt(creditsList.get(i).get(k));
                double j = 0;
                if (gradeList.get(i).get(k).equals("A")){
                    j = 4;
                }
                else if (gradeList.get(i).get(k).equals("B+")){
                    j = 3.5;
                }
                else if (gradeList.get(i).get(k).equals("B")){
                    j = 3;
                }
                else if (gradeList.get(i).get(k).equals("C+")){
                    j = 2.5;
                }
                else if (gradeList.get(i).get(k).equals("C")){
                    j = 2;
                }
                else if (gradeList.get(i).get(k).equals("D+")){
                    j = 1.5;
                }
                else if (gradeList.get(i).get(k).equals("D")){
                    j = 1;
                }
                else if (gradeList.get(i).get(k).equals("F")){
                    j = 0;
                }
                gps1 += j * Double.parseDouble(creditsList.get(i).get(k));
            }
            gps1 = gps1 / credit1;
            gpsList.add(String.format("%.2f", gps1));
        }

        ArrayList<String> gpaList = new ArrayList<>();
        double gps1 = 0.0;
        for (int i = 0; i < gpsList.size(); i++) {
            gps1 += Double.parseDouble(gpsList.get(i));
            gpaList.add(String.format("%.2f",gps1 / (i + 1)));
        }

        Object[][] data = {
                {"                           "+semester[0], "", "", "","",""},
                {subjectNumberList.get(0).get(0) + " " + subject.get(0).get(0), creditsList.get(0).get(0), gradeList.get(0).get(0), "", "", ""},
                {subjectNumberList.get(0).get(1) + " " + subject.get(0).get(1), creditsList.get(0).get(1), gradeList.get(0).get(1), "", "", ""},
                {subjectNumberList.get(0).get(2) + " " + subject.get(0).get(2), creditsList.get(0).get(2), gradeList.get(0).get(2), "", "", ""},
                {subjectNumberList.get(0).get(3) + " " + subject.get(0).get(3), creditsList.get(0).get(3), gradeList.get(0).get(3), "", "", ""},
                {"                             GPS : " + gpsList.get(0) + "                 GPA : " + gpaList.get(0), "", "", "", "", ""},
                {"","","", "","",""},
                {"                         "+semester[1], "", "", "","",""},
                {subjectNumberList.get(1).get(0) + " " + subject.get(1).get(0), creditsList.get(1).get(0), gradeList.get(1).get(0), "", "", ""},
                {subjectNumberList.get(1).get(1) + " " +subject.get(1).get(1), creditsList.get(1).get(1), gradeList.get(1).get(1), "", "", ""},
                {subjectNumberList.get(1).get(2) + " " +subject.get(1).get(2), creditsList.get(1).get(2), gradeList.get(1).get(2), "", "", ""},
                {subjectNumberList.get(1).get(3) + " " +subject.get(1).get(3), creditsList.get(1).get(3), gradeList.get(1).get(3), "", "", ""},
                {"                            GPS : " + gpsList.get(1) + "                  GPA : " + gpaList.get(1), "", "", "", "", ""},
                {"","","", "","",""},
                {"                  Total  number of credit earned:  "+ allCredit , "", "", "", "", ""},
                {"                          Cumulative GPA:  "+ gpaList.getLast() , "", "", "", "", ""},
        };

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(model);

        table.setDefaultRenderer(Object.class, new TableCellRendererNoBottomLine());
        table.setEnabled(false);
        table.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        table.setRowHeight(15);

        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setBackground(Color.WHITE);
        table.getTableHeader().setBorder(BorderFactory.createMatteBorder(1, 1, 0, 1, Color.BLACK));
        //table.getTableHeader().setPreferredSize(new Dimension(table.getTableHeader().getPreferredSize().width, (int)(table.getPreferredSize().height/2.6)));


        for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setResizable(false);
            table.getColumnModel().getColumn(i).setHeaderRenderer(new HeaderCellRendererNoBottomLine());
            if (i == 0 || i == 3) {
                table.getColumnModel().getColumn(i).setPreferredWidth((int)((parentPanel.getPreferredSize().width)/1.3));
            }else {
                table.getColumnModel().getColumn(i).setPreferredWidth((int)(((parentPanel.getPreferredSize().width)/12)));
            }

        }

        String[] a = {" ", "", "", "", "", ""};
        model.addRow(a);
        a[0] = "----------------------------- Transcript Closed -----------------------------";
        model.addRow(a);
        a[0] = "Checked by   ______________________________________________";
        model.addRow(a);
        a[0] = "                                              (Xx Xxxxxxxxx Xxxxxxxxxxxxx)";
        model.addRow(a);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(0, 11, 20, 12));
        parentPanel.add(scrollPane);
        parentPanel.setBackground(Color.WHITE);
    }
}
