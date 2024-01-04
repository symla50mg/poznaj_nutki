import enums.Scenes;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Options extends JPanel implements ActionListener {
    private JSlider volumeSlider;
    public Options() {
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


        JLabel optionsLabel = new JLabel("Zmień głośność");
        optionsLabel.setBounds(357, 160, 310, 50);
        optionsLabel.setFont(new Font("Arial", Font.BOLD, 24));
        optionsLabel.setForeground(Color.BLACK);
        layeredPane.add(optionsLabel, JLayeredPane.DEFAULT_LAYER);

        volumeSlider = new JSlider(JSlider.HORIZONTAL, -80, 0, 0); // Adjust the range as needed
        volumeSlider.setMajorTickSpacing(30);
        volumeSlider.setMinorTickSpacing(15);
        volumeSlider.setPaintTicks(true);
        volumeSlider.setPaintLabels(false);
        volumeSlider.setBounds(357, 210, 310, 50);
        volumeSlider.setBackground(new Color(112, 112, 112));
        volumeSlider.setBorder(new LineBorder(Color.BLACK, 2, true));
        volumeSlider.setFont(new Font("Arial", Font.BOLD, 24));
        volumeSlider.setForeground(Color.BLACK);
        layeredPane.add(volumeSlider, JLayeredPane.DEFAULT_LAYER);

        volumeSlider.addChangeListener(e -> Window.updateVolume(volumeSlider.getValue()));

        add(layeredPane);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "MENU":
                Window.SetScene(Scenes.MENU);
                break;
        }
    }
}