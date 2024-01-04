import enums.Notes;
import enums.Scenes;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Objects;
import java.util.ArrayList;
import java.util.Collections;

public class Tutorial extends JPanel implements ActionListener {
    //deklaracja komponentów
    JButton c, d, e, f, g, a, h, cis, dis, fis, gis, b, podp, menu;
    JLabel img, text;
    JTextField let;
    AudioInputStream sound;
    Clip clip;
    List<Notes> availableNotes;

    // zmienne tutorialowe
    int noteIndex = 0;
    int NotesLeft = 12;
    Notes noteToPlay;

    Tutorial(){
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(1024, 768));
        setBackground(new Color(185, 185, 185));

        availableNotes = new ArrayList<>(List.of(Notes.values()));

        //tworzenie komponentów
        menu = new JButton("MENU");
        menu.addActionListener(this);
        menu.setActionCommand("MENU");
        menu.setBounds(60,40,120,40);
        menu.setBackground(new Color(112, 112, 112));
        menu.setBorder(new LineBorder(Color.BLACK, 2, true));
        menu.setFont(new Font("Arial", Font.BOLD, 24));
        menu.setForeground(Color.BLACK);
        layeredPane.add(menu, JLayeredPane.DEFAULT_LAYER);

        podp = new JButton("PODPOWIEDŹ");
        podp.addActionListener(this);
        podp.setActionCommand("podp");
        podp.setBounds(397, 570, 230, 50);
        podp.setBackground(new Color(112, 112, 112));
        podp.setBorder(new LineBorder(Color.BLACK, 2, true));
        podp.setFont(new Font("Arial", Font.BOLD, 24));
        podp.setForeground(Color.BLACK);
        layeredPane.add(podp, JLayeredPane.DEFAULT_LAYER);

        text = new JLabel(" Litera odpowiadająca nucie: ");
        text.setBounds(317, 300, 285, 40);
        text.setBackground(Color.WHITE);
        text.setOpaque(true);
        text.setBorder(new LineBorder(Color.BLACK, 2, true));
        text.setFont(new Font("Arial", Font.BOLD, 20));
        text.setForeground(Color.BLACK);
        layeredPane.add(text, JLayeredPane.DEFAULT_LAYER);

        let = new JTextField(2);
        let.setBounds(637, 300, 70, 40);
        let.setBorder(new LineBorder(Color.BLACK, 2, true));
        let.setFont(new Font("Arial", Font.BOLD, 20));
        let.setForeground(Color.BLACK);
        let.setHorizontalAlignment(SwingConstants.CENTER);
        PlainDocument doc = (PlainDocument) let.getDocument();
        doc.setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                    throws BadLocationException {
                int newLength = fb.getDocument().getLength() - length + text.length();
                if (newLength <= 2) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });
        layeredPane.add(let, JLayeredPane.DEFAULT_LAYER);

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
        img.setBounds(396, 100, 250, 170);
        img.setBorder(new LineBorder(Color.BLACK, 2, true));
        layeredPane.add(img, JLayeredPane.DEFAULT_LAYER);
        img.setIcon(randomizeNote());

        //dodawanie komponentów
        add(layeredPane);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "podp":
                let.setText(Utilities.getNoteLetter(noteToPlay));
                break;
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

    //funkcja sprawdzająca poprawność wciśniętego przycisku/wpisanej litery
    void checkNote(Notes note){
        Utilities.playSound(note, clip, sound);
        if(note == noteToPlay && Objects.equals(let.getText(), Utilities.getNoteLetter(noteToPlay))){
            noteIndex++;
            if (noteIndex >= NotesLeft){
                Window.menuScene.isTutorialCompleted = true;
                showMessage();
                return;
            }
            img.setIcon(randomizeNote());
            let.setText("");
        }
    }

    void resetTutorial() {
        availableNotes = new ArrayList<>(List.of(Notes.values()));
        noteIndex = 0;
        img.setIcon(randomizeNote());
        let.setText("");
    }

    //losowe wyświetalanie nut
    ImageIcon randomizeNote() {
        if (availableNotes.isEmpty()) {
            availableNotes = new ArrayList<>(List.of(Notes.values()));
        }
        Collections.shuffle(availableNotes);
        Notes randomNote = availableNotes.remove(0);
        noteToPlay = randomNote;
        return new ImageIcon(Utilities.getImagePath(randomNote));
    }

    //komunikat po skończonej grze
    private void showMessage() {
        int option = JOptionPane.showOptionDialog(
                this,
                "Gratulacje! Udało Ci ukończyć samouczek.",
                "Samouczek",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                new Object[]{"MENU", "OD NOWA"},
                "OD NOWA");
        if (option == JOptionPane.YES_OPTION) {
            Window.SetScene(Scenes.MENU);
        }else if (option == JOptionPane.NO_OPTION) {
            resetTutorial();
        }
    }
}