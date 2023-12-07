import enums.Scenes;

import javax.swing.*;
import java.awt.*;

class Window extends JFrame{
    EndlessMode endlessModeScene = new EndlessMode();
    Tutorial tutorialScene = new Tutorial();
    public static Menu menuScene = new Menu();
    public static CardLayout cardLayout = new CardLayout();
    public static JPanel cardPanel = new JPanel(cardLayout);

    Window(int width, int height){
        super("Poznaj Nutki");
        setResizable(false);
        setSize(width,height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardPanel.add(menuScene, "MENU");
        cardPanel.add(endlessModeScene, "ENDLESS_MODE");
        cardPanel.add(tutorialScene, "TUTORIAL");

        getContentPane().add(cardPanel, BorderLayout.CENTER);
    }

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
                break;
        }
    }
}
