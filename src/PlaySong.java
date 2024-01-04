import enums.Notes;
import enums.Scenes;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class PlaySong extends JPanel implements ActionListener {
    //deklaracja komponentów
    JButton c, d, e, f, g, a, h, cis, dis, fis, gis, b, menu;
    JLabel img, text;
    AudioInputStream sound;
    Clip clip;
    List<JLabel> heartIcons = new ArrayList<>();

    // zmienne playsong
    int noteIndex = 0;
    Notes noteToPlay;
    int errorsCount = 0;
    Notes[] song = {
            Notes.NOTE_G, Notes.NOTE_E, Notes.NOTE_E,
            Notes.NOTE_F, Notes.NOTE_D, Notes.NOTE_D,
            Notes.NOTE_C, Notes.NOTE_E, Notes.NOTE_G,
            Notes.NOTE_G, Notes.NOTE_E, Notes.NOTE_E,
            Notes.NOTE_F, Notes.NOTE_D, Notes.NOTE_D,
            Notes.NOTE_C, Notes.NOTE_E, Notes.NOTE_C};
    PlaySong() {
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(1024, 768));
        setBackground(new Color(185, 185, 185));

        //tworzenie komponentów
        menu = new JButton("MENU");
        menu.addActionListener(this);
        menu.setActionCommand("MENU");
        menu.setBounds(60, 40, 120, 40);
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

        img = new JLabel();
        img.setBounds(332, 100, 360, 200);
        img.setBorder(new LineBorder(Color.BLACK, 2, true));
        ImageIcon icon = new ImageIcon(("src/images/song.png"));
        img.setIcon(icon);
        layeredPane.add(img, JLayeredPane.DEFAULT_LAYER);

        text = new JLabel(" Wlazł kotek na płotek ");
        text.setBounds(332, 55, 285, 40);
        text.setFont(new Font("Arial", Font.BOLD, 20));
        text.setForeground(Color.BLACK);
        layeredPane.add(text, JLayeredPane.DEFAULT_LAYER);

        for (int i = 0; i < 3; i++) {
            JLabel heartIcon = new JLabel(new ImageIcon("src/images/heart.png"));
            heartIcon.setBounds(800 + i * 70, 20, 60, 60);
            layeredPane.add(heartIcon, JLayeredPane.DEFAULT_LAYER);
            heartIcons.add(heartIcon);
        }

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
                checkNote(Notes.NOTE_C);
                break;
            case "d":
                checkNote(Notes.NOTE_D);
                break;
            case "e":
                checkNote(Notes.NOTE_E);
                break;
            case "f":
                checkNote(Notes.NOTE_F);
                break;
            case "g":
                checkNote(Notes.NOTE_G);
                break;
            case "a":
                checkNote(Notes.NOTE_A);
                break;
            case "h":
                checkNote(Notes.NOTE_H);
                break;
            case "cis":
                checkNote(Notes.NOTE_CIS);
                break;
            case "dis":
                checkNote(Notes.NOTE_DIS);
                break;
            case "fis":
                checkNote(Notes.NOTE_FIS);
                break;
            case "gis":
                checkNote(Notes.NOTE_GIS);
                break;
            case "b":
                checkNote(Notes.NOTE_B);
                break;

        }
    }

    void checkNote(Notes note){
        Utilities.playSound(note, clip, sound);
        if (noteIndex < song.length){
            noteToPlay=song[noteIndex];
            if(note == noteToPlay){
                noteIndex++;
            }
            else {
                errorsCount++;
                if (errorsCount <= heartIcons.size()) {
                    JLabel heartIcon = heartIcons.get(errorsCount - 1);
                    heartIcon.setVisible(false);
                }
                if(errorsCount==3){
                    showLossMessage();
                    resetPlaySong();
                }
            }
            if (noteIndex == song.length) {
                showWinMessage();
            }
        }
    }

    void resetPlaySong(){
        noteIndex = 0;
        errorsCount = 0;
        for (JLabel heartIcon : heartIcons) {
            heartIcon.setVisible(true);
        }
    }

    private void showLossMessage() {
        JOptionPane.showMessageDialog(this, "Zacznij od nowa.", "Przegrana!",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void showWinMessage() {
        int option = JOptionPane.showOptionDialog(
                this,
                "Gratulacje! Udało Ci się zagrać melodię.",
                "Wygrana!",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                new Object[]{"MENU"},
                "MENU");
        if (option == JOptionPane.OK_OPTION) {
            Window.SetScene(Scenes.MENU);
        }
    }
}