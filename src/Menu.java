import enums.Scenes;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Klasa reprezentująca panel menu gry.
 * Dziedziczy po JPanel i implementuje interfejs ActionListener.
 */
public class Menu extends JPanel implements ActionListener {
    /**
     * Flaga wskazująca, czy samouczek został ukończony.
     */
    public Boolean isTutorialCompleted = false;
    //deklaracja komponentów
    JButton t1, t2, t3, options;
    JLabel logo;

    Menu() {
        setLayout(null);
        setBackground(new Color(185, 185, 185));

        //tworzenie komponentów
        ImageIcon log = new ImageIcon("src/images/logo.png");
        logo = new JLabel(log);
        logo.setBounds(347, 100, 330, 170);

        t1 = new JButton("ĆWICZ NUTY");
        t1.addActionListener(this);
        t1.setActionCommand("TUTORIAL");
        t1.setBounds(357, 310, 310, 50);
        t1.setBackground(new Color(112, 112, 112));
        t1.setBorder(new LineBorder(Color.BLACK, 2, true));
        t1.setFont(new Font("Arial", Font.BOLD, 24));
        t1.setForeground(Color.BLACK);

        t3 = new JButton("GRAJ DOWOLNIE");
        t3.addActionListener(this);
        t3.setActionCommand("ENDLESS_MODE");
        t3.setBounds(357, 510, 310, 50);
        t3.setBackground(new Color(112, 112, 112));
        t3.setBorder(new LineBorder(Color.BLACK, 2, true));
        t3.setFont(new Font("Arial", Font.BOLD, 24));
        t3.setForeground(Color.BLACK);

        options = new JButton("OPCJE");
        options.addActionListener(this);
        options.setActionCommand("OPTIONS");
        options.setBounds(357, 610, 310, 50);
        options.setBackground(new Color(112, 112, 112));
        options.setBorder(new LineBorder(Color.BLACK, 2, true));
        options.setFont(new Font("Arial", Font.BOLD, 24));
        options.setForeground(Color.BLACK);

        //dodawanie komponentów
        add(logo);
        add(t1);
        add(t3);
        add(options);
    }

    /**
     * Metoda obsługująca zdarzenia akcji w menu.
     * W zależności od wciśniętego przycisku, zmienia aktualną scenę gry.
     * @param e Obiekt zdarzenia akcji.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "MENU" -> Window.SetScene(Scenes.MENU);
            case "ENDLESS_MODE" -> Window.SetScene(Scenes.ENDLESS_MODE);
            case "TUTORIAL" -> Window.SetScene(Scenes.TUTORIAL);
            case "PLAY_SONG" -> Window.SetScene(Scenes.PLAY_SONG);
            case "OPTIONS" -> Window.SetScene(Scenes.OPTIONS);
        }
    }

    /**
     * Metoda sprawdzająca, czy samouczek został ukończony. Jeśli tak, dodaje
     * przycisk "ZAGRAJ PIOSENKĘ" do menu.
     */
    public void checkTutorial() {
        if (isTutorialCompleted) {
            if (t2 == null) {
                t2 = new JButton("ZAGRAJ PIOSENKĘ");
                t2.addActionListener(this);
                t2.setActionCommand("PLAY_SONG");
                t2.setBounds(357, 410, 310, 50);
                t2.setBackground(new Color(112, 112, 112));
                t2.setBorder(new LineBorder(Color.BLACK, 2, true));
                t2.setFont(new Font("Arial", Font.BOLD, 24));
                t2.setForeground(Color.BLACK);
                add(t2);
            }
        }
    }
}