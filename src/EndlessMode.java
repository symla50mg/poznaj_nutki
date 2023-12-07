import enums.Notes;
import enums.Scenes;
import org.w3c.dom.Text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.sound.sampled.*;
import javax.swing.border.LineBorder;

class EndlessMode extends JPanel implements ActionListener {
    //deklaracja komponentów
    JButton c, d, e, f, g, a, h, cis, dis, fis, gis, b;
    AudioInputStream sound;
    Clip clip;

    EndlessMode(){
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(1024, 768));
        setBackground(new Color(185, 185, 185));

        //tworzenie komponentów
        JButton menu = new JButton("MENU");
        menu.addActionListener(this);
        menu.setActionCommand("MENU");
        menu.setBounds(60,40,120,40);
        menu.setBackground(new Color(112, 112, 112));
        menu.setBorder(new LineBorder(Color.BLACK, 2, true));
        menu.setFont(new Font("Arial", Font.BOLD, 24));
        menu.setForeground(Color.BLACK);
        layeredPane.add(menu, JLayeredPane.DEFAULT_LAYER);

        c = new JButton();
        c.addActionListener(this);
        c.setActionCommand("c");
        c.setBounds(267, 360, 70, 200);
        c.setBackground(Color.WHITE);
        c.setBorder(new LineBorder(Color.BLACK, 1));
        layeredPane.add(c, JLayeredPane.DEFAULT_LAYER);

        d = new JButton();
        d.addActionListener(this);
        d.setActionCommand("d");
        d.setBounds(337, 360, 70, 200);
        d.setBackground(Color.WHITE);
        d.setBorder(new LineBorder(Color.BLACK, 1));
        layeredPane.add(d, JLayeredPane.DEFAULT_LAYER);

        e = new JButton();
        e.addActionListener(this);
        e.setActionCommand("e");
        e.setBounds(407, 360, 70, 200);
        e.setBackground(Color.WHITE);
        e.setBorder(new LineBorder(Color.BLACK, 1));
        layeredPane.add(e, JLayeredPane.DEFAULT_LAYER);

        f = new JButton();
        f.addActionListener(this);
        f.setActionCommand("f");
        f.setBounds(477, 360, 70, 200);
        f.setBackground(Color.WHITE);
        f.setBorder(new LineBorder(Color.BLACK, 1));
        layeredPane.add(f, JLayeredPane.DEFAULT_LAYER);

        g = new JButton();
        g.addActionListener(this);
        g.setActionCommand("g");
        g.setBounds(547, 360, 70, 200);
        g.setBackground(Color.WHITE);
        g.setBorder(new LineBorder(Color.BLACK, 1));
        layeredPane.add(g, JLayeredPane.DEFAULT_LAYER);

        a = new JButton();
        a.addActionListener(this);
        a.setActionCommand("a");
        a.setBounds(617, 360, 70, 200);
        a.setBackground(Color.WHITE);
        a.setBorder(new LineBorder(Color.BLACK, 1));
        layeredPane.add(a, JLayeredPane.DEFAULT_LAYER);

        h = new JButton();
        h.addActionListener(this);
        h.setActionCommand("h");
        h.setBounds(687, 360, 70, 200);
        h.setBackground(Color.WHITE);
        h.setBorder(new LineBorder(Color.BLACK, 1));
        layeredPane.add(h, JLayeredPane.DEFAULT_LAYER);

        cis = new JButton();
        cis.addActionListener(this);
        cis.setActionCommand("cis");
        cis.setBounds(305, 360, 60, 120);
        cis.setBackground(Color.BLACK);
        layeredPane.add(cis, JLayeredPane.PALETTE_LAYER);

        dis = new JButton();
        dis.addActionListener(this);
        dis.setActionCommand("dis");
        dis.setBounds(375, 360, 60, 120);
        dis.setBackground(Color.BLACK);
        layeredPane.add(dis, JLayeredPane.PALETTE_LAYER);

        fis = new JButton();
        fis.addActionListener(this);
        fis.setActionCommand("fis");
        fis.setBounds(515, 360, 60, 120);
        fis.setBackground(Color.BLACK);
        layeredPane.add(fis, JLayeredPane.PALETTE_LAYER);

        gis = new JButton();
        gis.addActionListener(this);
        gis.setActionCommand("gis");
        gis.setBounds(585, 360, 60, 120);
        gis.setBackground(Color.BLACK);
        layeredPane.add(gis, JLayeredPane.PALETTE_LAYER);

        b = new JButton();
        b.addActionListener(this);
        b.setActionCommand("b");
        b.setBounds(655, 360, 60, 120);
        b.setBackground(Color.BLACK);
        layeredPane.add(b, JLayeredPane.PALETTE_LAYER);

        //dodawanie komponentów
        add(layeredPane);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "MENU":
                Window.SetScene(Scenes.MENU);
                break;
            case "c":
                Utilities.playSound(Notes.NOTE_C, clip, sound);
                break;
            case "d":
                Utilities.playSound(Notes.NOTE_D, clip, sound);
                break;
            case "e":
                Utilities.playSound(Notes.NOTE_E, clip, sound);
                break;
            case "f":
                Utilities.playSound(Notes.NOTE_F, clip, sound);
                break;
            case "g":
                Utilities.playSound(Notes.NOTE_G, clip, sound);
                break;
            case "a":
                Utilities.playSound(Notes.NOTE_A, clip, sound);
                break;
            case "h":
                Utilities.playSound(Notes.NOTE_H, clip, sound);
                break;
            case "cis":
                Utilities.playSound(Notes.NOTE_CIS, clip, sound);
                break;
            case "dis":
                Utilities.playSound(Notes.NOTE_DIS, clip, sound);
                break;
            case "fis":
                Utilities.playSound(Notes.NOTE_FIS, clip, sound);
                break;
            case "gis":
                Utilities.playSound(Notes.NOTE_GIS, clip, sound);
                break;
            case "b":
                Utilities.playSound(Notes.NOTE_B, clip, sound);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + e.getActionCommand());
        }
    }
}



