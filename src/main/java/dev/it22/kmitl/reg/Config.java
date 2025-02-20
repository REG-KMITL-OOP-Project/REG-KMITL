package dev.it22.kmitl.reg;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
public class Config {
    public static final Color bgColor_base = new Color(63,63,71);
    public static final Color bgColor_hard = new Color(37,37,37);
    public static final Color bgColor_harder = new Color(24,24,27);
    public static final Color primaryColor_base = new Color(255,137,5);
    public static final Color primaryColor_hard = new Color(255,105,0);
    public static final Color primaryColor_harder = new Color(245,73,0);
    public static Font HEADER_1;
    public static Font HEADER_2;
    public static Font HEADER_3;
    public static Font HEADER_4;
    public static Font NORMAL;
    static {
        try {
            NORMAL = Font.createFont(Font.TRUETYPE_FONT, new File("source/Noto_Sans_Thai_Looped/NotoSansThaiLooped-Medium.ttf")).deriveFont(Font.BOLD, 12);
            HEADER_1 = Font.createFont(Font.TRUETYPE_FONT, new File("source/Noto_Sans_Thai_Looped/NotoSansThaiLooped-SemiBold.ttf")).deriveFont(Font.BOLD, 27);
            HEADER_2 = Font.createFont(Font.TRUETYPE_FONT, new File("source/Noto_Sans_Thai_Looped/NotoSansThaiLooped-SemiBold.ttf")).deriveFont(Font.BOLD, 24);
            HEADER_3 = Font.createFont(Font.TRUETYPE_FONT, new File("source/Noto_Sans_Thai_Looped/NotoSansThaiLooped-SemiBold.ttf")).deriveFont(Font.BOLD, 18);
            HEADER_4 = Font.createFont(Font.TRUETYPE_FONT, new File("source/Noto_Sans_Thai_Looped/NotoSansThaiLooped-SemiBold.ttf")).deriveFont(Font.BOLD, 15);
        } catch (Exception e) {
            e.printStackTrace();
            NORMAL = new Font("Noto Sans Thai Looped",Font.PLAIN,12);
            HEADER_1 = new Font("Noto Sans Thai Looped",Font.BOLD,27);
            HEADER_2 = new Font("Noto Sans Thai Looped",Font.BOLD,24);
            HEADER_3 = new Font("Noto Sans Thai Looped",Font.BOLD,18);
            HEADER_4 = new Font("Noto Sans Thai Looped",Font.BOLD,15);
        }
    }

    public static JFrame createAndShowGUI() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("REG-KMITL");
        frame.getContentPane().setBackground(bgColor_base);
        frame.setResizable(false);
        frame.setSize(new Dimension(screenSize.width * 4/5,screenSize.height *4/5));
        frame.setIconImage(new ImageIcon("source/Logo.png").getImage());
        frame.setLocation(screenSize.width/9,screenSize.height/9);
        frame.setVisible(true);
        System.out.println(screenSize);
        return frame;
    }
    public static JPanel createLogoAndTitle() {

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        topPanel.setBackground(null);
        topPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        topPanel.setBorder(BorderFactory.createEmptyBorder(35, 50, 0, 0));

        JTextArea title = new JTextArea(" KING MONGKUT'S INSTITUTE \n OF TECHNOLOGY LADKRABANG");
        title.setEditable(false);
        title.setBackground(null);
        title.setForeground(Color.WHITE);
        title.setFont(Config.HEADER_4);

        ImageIcon logo = new ImageIcon(new ImageIcon("source/Logo.png").getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH));
        JLabel regLabel = new JLabel(logo);

        topPanel.add(regLabel);
        topPanel.add(title);

        return topPanel;
    }

}
