import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.sound.sampled.*;
import javax.swing.border.LineBorder;

class GameWindow extends JFrame {
    //deklaracja komponentów
    JButton C, D, E, F, G, A, H, CIS, DIS, FIS, GIS, B;
    JButton SPR, PODP, MENU;
    JLabel IMG, TEXT;
    JTextField LET;

    GameWindow(String name){
        super(name);
        setResizable(false);
        setSize(1024,768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(185, 185, 185));

        // tworzenie warstw komponentów
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(1024, 768));

        //tworzenie komponentów
        MENU = new JButton("MENU");
        MENU.setBounds(60,40,120,40);
        MENU.setBackground(new Color(112, 112, 112));
        MENU.setBorder(new LineBorder(Color.BLACK, 2, true));
        MENU.setFont(new Font("Arial", Font.BOLD, 24));
        MENU.setForeground(Color.BLACK);
        layeredPane.add(MENU, JLayeredPane.DEFAULT_LAYER);

        SPR = new JButton("SPRAWDŹ");
        SPR.setBounds(267, 570, 230, 50);
        SPR.setBackground(new Color(112, 112, 112));
        SPR.setBorder(new LineBorder(Color.BLACK, 2, true));
        SPR.setFont(new Font("Arial", Font.BOLD, 24));
        SPR.setForeground(Color.BLACK);
        layeredPane.add(SPR, JLayeredPane.DEFAULT_LAYER);

        PODP = new JButton("PODPOWIEDŹ");
        PODP.setBounds(527, 570, 230, 50);
        PODP.setBackground(new Color(112, 112, 112));
        PODP.setBorder(new LineBorder(Color.BLACK, 2, true));
        PODP.setFont(new Font("Arial", Font.BOLD, 24));
        PODP.setForeground(Color.BLACK);
        layeredPane.add(PODP, JLayeredPane.DEFAULT_LAYER);

        TEXT = new JLabel(" Litera odpowiadająca nucie: ");
        TEXT.setBounds(317, 300, 285, 40);
        TEXT.setBackground(Color.WHITE);
        TEXT.setOpaque(true);
        TEXT.setBorder(new LineBorder(Color.BLACK, 2, true));
        TEXT.setFont(new Font("Arial", Font.BOLD, 20));
        TEXT.setForeground(Color.BLACK);
        layeredPane.add(TEXT, JLayeredPane.DEFAULT_LAYER);

        LET = new JTextField();
        LET.setBounds(637, 300, 70, 40);
        LET.setBorder(new LineBorder(Color.BLACK, 2, true));
        LET.setFont(new Font("Arial", Font.BOLD, 20));
        LET.setForeground(Color.BLACK);
        LET.setHorizontalAlignment(SwingConstants.CENTER);
        layeredPane.add(LET, JLayeredPane.DEFAULT_LAYER);

        ImageIcon C_image = new ImageIcon("src/images/C.png");
        IMG = new JLabel(C_image);
        IMG.setBounds(396, 100, 250, 170);
        IMG.setBorder(new LineBorder(Color.BLACK, 2, true));
        layeredPane.add(IMG, JLayeredPane.DEFAULT_LAYER);

        C = new JButton();
        C.setBounds(267, 360, 70, 200);
        C.setBackground(Color.WHITE);
        C.setBorder(new LineBorder(Color.BLACK, 1));
        layeredPane.add(C, JLayeredPane.DEFAULT_LAYER);

        D = new JButton();
        D.setBounds(337, 360, 70, 200);
        D.setBackground(Color.WHITE);
        D.setBorder(new LineBorder(Color.BLACK, 1));
        layeredPane.add(D, JLayeredPane.DEFAULT_LAYER);

        E = new JButton();
        E.setBounds(407, 360, 70, 200);
        E.setBackground(Color.WHITE);
        E.setBorder(new LineBorder(Color.BLACK, 1));
        layeredPane.add(E, JLayeredPane.DEFAULT_LAYER);

        F = new JButton();
        F.setBounds(477, 360, 70, 200);
        F.setBackground(Color.WHITE);
        F.setBorder(new LineBorder(Color.BLACK, 1));
        layeredPane.add(F, JLayeredPane.DEFAULT_LAYER);

        G = new JButton();
        G.setBounds(547, 360, 70, 200);
        G.setBackground(Color.WHITE);
        G.setBorder(new LineBorder(Color.BLACK, 1));
        layeredPane.add(G, JLayeredPane.DEFAULT_LAYER);

        A = new JButton();
        A.setBounds(617, 360, 70, 200);
        A.setBackground(Color.WHITE);
        A.setBorder(new LineBorder(Color.BLACK, 1));
        layeredPane.add(A, JLayeredPane.DEFAULT_LAYER);

        H = new JButton();
        H.setBounds(687, 360, 70, 200);
        H.setBackground(Color.WHITE);
        H.setBorder(new LineBorder(Color.BLACK, 1));
        layeredPane.add(H, JLayeredPane.DEFAULT_LAYER);

        CIS = new JButton();
        CIS.setBounds(305, 360, 60, 120);
        CIS.setBackground(Color.BLACK);
        layeredPane.add(CIS, JLayeredPane.PALETTE_LAYER);

        DIS = new JButton();
        DIS.setBounds(375, 360, 60, 120);
        DIS.setBackground(Color.BLACK);
        layeredPane.add(DIS, JLayeredPane.PALETTE_LAYER);

        FIS = new JButton();
        FIS.setBounds(515, 360, 60, 120);
        FIS.setBackground(Color.BLACK);
        layeredPane.add(FIS, JLayeredPane.PALETTE_LAYER);

        GIS = new JButton();
        GIS.setBounds(585, 360, 60, 120);
        GIS.setBackground(Color.BLACK);
        layeredPane.add(GIS, JLayeredPane.PALETTE_LAYER);

        B = new JButton();
        B.setBounds(655, 360, 60, 120);
        B.setBackground(Color.BLACK);
        layeredPane.add(B, JLayeredPane.PALETTE_LAYER);

        //dodawanie komponentów
        add(layeredPane);

        //obsługa zdarzeń
        MENU.addActionListener(new MN());
        C.addActionListener(new CP());
        D.addActionListener(new DP());
        E.addActionListener(new EP());
        F.addActionListener(new FP());
        G.addActionListener(new GP());
        A.addActionListener(new AP());
        H.addActionListener(new HP());
        CIS.addActionListener(new CISP());
        DIS.addActionListener(new DISP());
        FIS.addActionListener(new FISP());
        GIS.addActionListener(new GISP());
        B.addActionListener(new BP());
    }
}

class MN implements ActionListener {
    public void actionPerformed(ActionEvent ev) {
        MenuWindow menu = new MenuWindow("Poznaj Nutki");
        menu.setVisible(true);
    }
}
class CP implements ActionListener {
    public void actionPerformed(ActionEvent ev) {
        try {
            AudioInputStream C_sound = AudioSystem.getAudioInputStream(new File("src/sounds/C.wav"));
            Clip player = AudioSystem.getClip();
            player.open(C_sound);
            player.start();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
class DP implements ActionListener {
    public void actionPerformed(ActionEvent ev) {
        try {
            AudioInputStream D_sound = AudioSystem.getAudioInputStream(new File("src/sounds/D.wav"));
            Clip player = AudioSystem.getClip();
            player.open(D_sound);
            player.start();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
class EP implements ActionListener {
    public void actionPerformed(ActionEvent ev) {
        try {
            AudioInputStream D_sound = AudioSystem.getAudioInputStream(new File("src/sounds/E.wav"));
            Clip player = AudioSystem.getClip();
            player.open(D_sound);
            player.start();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
class FP implements ActionListener {
    public void actionPerformed(ActionEvent ev) {
        try {
            AudioInputStream F_sound = AudioSystem.getAudioInputStream(new File("src/sounds/F.wav"));
            Clip player = AudioSystem.getClip();
            player.open(F_sound);
            player.start();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
class GP implements ActionListener {
    public void actionPerformed(ActionEvent ev) {
        try {
            AudioInputStream G_sound = AudioSystem.getAudioInputStream(new File("src/sounds/G.wav"));
            Clip player = AudioSystem.getClip();
            player.open(G_sound);
            player.start();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
class AP implements ActionListener {
    public void actionPerformed(ActionEvent ev) {
        try {
            AudioInputStream A_sound = AudioSystem.getAudioInputStream(new File("src/sounds/A.wav"));
            Clip player = AudioSystem.getClip();
            player.open(A_sound);
            player.start();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
class HP implements ActionListener {
    public void actionPerformed(ActionEvent ev) {
        try {
            AudioInputStream H_sound = AudioSystem.getAudioInputStream(new File("src/sounds/H.wav"));
            Clip player = AudioSystem.getClip();
            player.open(H_sound);
            player.start();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
class CISP implements ActionListener {
    public void actionPerformed(ActionEvent ev) {
        try {
            AudioInputStream CIS_sound = AudioSystem.getAudioInputStream(new File("src/sounds/CIS.wav"));
            Clip player = AudioSystem.getClip();
            player.open(CIS_sound);
            player.start();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
class DISP implements ActionListener {
    public void actionPerformed(ActionEvent ev) {
        try {
            AudioInputStream DIS_sound = AudioSystem.getAudioInputStream(new File("src/sounds/DIS.wav"));
            Clip player = AudioSystem.getClip();
            player.open(DIS_sound);
            player.start();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
class FISP implements ActionListener {
    public void actionPerformed(ActionEvent ev) {
        try {
            AudioInputStream FIS_sound = AudioSystem.getAudioInputStream(new File("src/sounds/FIS.wav"));
            Clip player = AudioSystem.getClip();
            player.open(FIS_sound);
            player.start();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
class GISP implements ActionListener {
    public void actionPerformed(ActionEvent ev) {
        try {
            AudioInputStream GIS_sound = AudioSystem.getAudioInputStream(new File("src/sounds/GIS.wav"));
            Clip player = AudioSystem.getClip();
            player.open(GIS_sound);
            player.start();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
class BP implements ActionListener {
    public void actionPerformed(ActionEvent ev) {
        try {
            AudioInputStream B_sound = AudioSystem.getAudioInputStream(new File("src/sounds/B.wav"));
            Clip player = AudioSystem.getClip();
            player.open(B_sound);
            player.start();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

public class Interface {
    public static void main(String[] args) {
        GameWindow g = new GameWindow("Poznaj Nutki");
        g.setVisible(true);
    }
}

