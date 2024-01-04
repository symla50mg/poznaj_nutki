import enums.Scenes;

import javax.swing.*;
import java.awt.*;

/**
 * Klasa reprezentująca główne okno aplikacji.
 */
public class Window extends JFrame{
    public static EndlessMode endlessModeScene = new EndlessMode(); // public static
    public static Tutorial tutorialScene = new Tutorial();
    public static PlaySong songScene = new PlaySong();
    public static Options optionsScene = new Options();   // public static
    public static Menu menuScene = new Menu();
    public static CardLayout cardLayout = new CardLayout();
    public static JPanel cardPanel = new JPanel(cardLayout);

    public static float volume = 0.0f;

    Window(int width, int height){
        super("Poznaj Nutki");
        setResizable(false);
        setSize(width,height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardPanel.add(menuScene, "MENU");
        cardPanel.add(endlessModeScene, "ENDLESS_MODE");
        cardPanel.add(tutorialScene, "TUTORIAL");
        cardPanel.add(songScene, "PLAY_SONG");
        cardPanel.add(optionsScene, "OPTIONS");

        getContentPane().add(cardPanel, BorderLayout.CENTER);
    }

    /**
     * Metoda zmieniająca aktualnie widoczną scenę.
     *
     * @param scene Wybrana scena.
     */
    public static void SetScene(Scenes scene){
        switch (scene){
            case MENU:
                menuScene.checkTutorial();
                cardLayout.show(cardPanel, "MENU");
                break;
            case ENDLESS_MODE:
                cardLayout.show(cardPanel, "ENDLESS_MODE");
                break;
            case TUTORIAL:
                cardLayout.show(cardPanel, "TUTORIAL");
                tutorialScene.resetTutorial();
                break;
            case PLAY_SONG:
                cardLayout.show(cardPanel, "PLAY_SONG");
                songScene.resetPlaySong();
                break;
            case OPTIONS:
                cardLayout.show(cardPanel, "OPTIONS");
                break;
        }
    }


    /**
     * Metoda aktualizująca poziom głośności.
     *
     * @param sliderValue Wartość zsuwaka głośności.
     */
    public static void updateVolume(int sliderValue) {
        volume = (float) sliderValue;
        System.out.print(sliderValue+"\n");
        System.out.print(volume);
    }
}