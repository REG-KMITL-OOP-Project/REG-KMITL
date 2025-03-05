package dev.it22.kmitl.reg.utils;
import java.awt.*;
import java.io.File;
import javax.swing.*;
public class Config {
    public static final Color bgColor_base = new Color(63,63,71);
    public static final Color bgColor_hard = new Color(37,37,37);
    public static final Color bgColor_harder = new Color(24,24,27);
    public static final Color primaryColor_base = new Color(255,137,5);
    public static final Color primaryColor_hard = new Color(255,105,0);
    public static final Color primaryColor_harder = new Color(245,73,0);
    public static Font HEADER_REGULAR[];
    public static Font HEADER_SEMIBOLD[];
    public static Font NORMAL_REGULAR;
    public static Font NORMAL_LIGHT;
    public static int size[] = {27,24,18,15};
    static {
        HEADER_REGULAR = new Font[4];
        HEADER_SEMIBOLD = new Font[4];
        try {
            for (int i = 0; i < HEADER_REGULAR.length; i++) {
                HEADER_REGULAR[i] = Font.createFont(Font.TRUETYPE_FONT, new File("source/Noto_Sans_Thai/NotoSansThai-Regular.ttf")).deriveFont(Font.PLAIN, size[i]);
                HEADER_SEMIBOLD[i] = Font.createFont(Font.TRUETYPE_FONT, new File("source/Noto_Sans_Thai/NotoSansThai-SemiBold.ttf")).deriveFont(Font.PLAIN, size[i]);
            }
            NORMAL_REGULAR = Font.createFont(Font.TRUETYPE_FONT, new File("source/Noto_Sans_Thai_Looped/NotoSansThaiLooped-Regular.ttf")).deriveFont(Font.PLAIN, 12);
            NORMAL_LIGHT = Font.createFont(Font.TRUETYPE_FONT, new File("source/Noto_Sans_Thai_Looped/NotoSansThaiLooped-Light.ttf")).deriveFont(Font.PLAIN, 12);
        } catch (Exception e) {
            e.printStackTrace();
            for (int i = 0; i < HEADER_REGULAR.length; i++) {
                HEADER_REGULAR[i] = new Font("Arial", Font.PLAIN, size[i]);
                HEADER_SEMIBOLD[i] = new Font("Arial", Font.BOLD, size[i]);
            }
            NORMAL_REGULAR = new Font("Arial", Font.BOLD, 12);
            NORMAL_LIGHT = new Font("Arial", Font.PLAIN, 12);
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
        System.out.println(screenSize);
        return frame;
    }
    public static JPanel createLogoAndTitle(Font font,int squareSize) {

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        topPanel.setBackground(null);
        topPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        topPanel.setBorder(BorderFactory.createEmptyBorder(35, 50, 0, 0));

        JTextArea title = new JTextArea(" KING MONGKUT'S INSTITUTE \n OF TECHNOLOGY LADKRABANG");
        title.setEditable(false);
        title.setBackground(null);
        title.setForeground(Color.WHITE);
        title.setFont(font);

        ImageIcon logo = new ImageIcon(new ImageIcon("source/Logo.png").getImage().getScaledInstance(squareSize,squareSize,Image.SCALE_SMOOTH));
        JLabel regLabel = new JLabel(logo);

        topPanel.add(regLabel);
        topPanel.add(title);

        return topPanel;
    }
    public static void openFrame() {
        JDialog dialog = new JDialog();
        dialog.setLayout(new FlowLayout());
        dialog.setTitle("");
        dialog.setUndecorated(true);
        dialog.setSize(300, 150);
        dialog.setLocationRelativeTo(null);
        dialog.setModal(true);
        dialog.setVisible(true);
    }
}
