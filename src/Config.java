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
    public static Font HEADER_1;
    public static Font HEADER_2;
    public static Font HEADER_3;
    public static Font HEADER_4;
    public static Font NORMAL;
    static {
        try {
            NORMAL = Font.createFont(Font.TRUETYPE_FONT, new File("source/Noto_Sans_Thai_Looped/NotoSansThaiLooped-Medium.ttf")).deriveFont(Font.PLAIN, 12);
            HEADER_1 = Font.createFont(Font.TRUETYPE_FONT, new File("source/Noto_Sans_Thai_Looped/NotoSansThaiLooped-Bold.ttf")).deriveFont(Font.PLAIN, 27);
            HEADER_2 = Font.createFont(Font.TRUETYPE_FONT, new File("source/Noto_Sans_Thai_Looped/NotoSansThaiLooped-Bold.ttf")).deriveFont(Font.PLAIN, 24);
            HEADER_3 = Font.createFont(Font.TRUETYPE_FONT, new File("source/Noto_Sans_Thai_Looped/NotoSansThaiLooped-Bold.ttf")).deriveFont(Font.PLAIN, 18);
            HEADER_4 = Font.createFont(Font.TRUETYPE_FONT, new File("source/Noto_Sans_Thai_Looped/NotoSansThaiLooped-Bold.ttf")).deriveFont(Font.PLAIN, 15);
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
        frame.setSize(screenSize);
        frame.setIconImage(new ImageIcon("source/Logo.png").getImage());
        frame.setVisible(true);
        return frame;
    }
}
