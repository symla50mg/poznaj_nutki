import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;

class MenuWindow extends JFrame {
    //deklaracja komponentów
    JButton T1, T2, T3;
    JLabel LOGO;

    MenuWindow (String name){
        super (name);
        setResizable(false);
        setSize(1024,768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(185, 185, 185));
        setLayout(null);

        //tworzenie komponentów
        ImageIcon logo = new ImageIcon("src/images/logo.png");
        LOGO = new JLabel(logo);
        LOGO.setBounds(347, 100, 330, 170);
        //LOGO.setBorder(new LineBorder(Color.BLACK, 2, true));

        T1 = new JButton("ĆWICZ NUTY");
        T1.setBounds(357, 310, 310, 50);
        T1.setBackground(new Color(112, 112, 112));
        T1.setBorder(new LineBorder(Color.BLACK, 2, true));
        T1.setFont(new Font("Arial", Font.BOLD, 24));
        T1.setForeground(Color.BLACK);

        T2 = new JButton("ZAGRAJ PIOSENKĘ");
        T2.setBounds(357, 410, 310, 50);
        T2.setBackground(new Color(112, 112, 112));
        T2.setBorder(new LineBorder(Color.BLACK, 2, true));
        T2.setFont(new Font("Arial", Font.BOLD, 24));
        T2.setForeground(Color.BLACK);

        T3 = new JButton("GRAJ DOWOLNIE");
        T3.setBounds(357, 510, 310, 50);
        T3.setBackground(new Color(112, 112, 112));
        T3.setBorder(new LineBorder(Color.BLACK, 2, true));
        T3.setFont(new Font("Arial", Font.BOLD, 24));
        T3.setForeground(Color.BLACK);

        //dodawanie komponentów
        add(LOGO);
        add(T1);
        add(T2);
        add(T3);

        //obsługa zdarzeń
    }
}

public class Menu {
    public static void main(String[] args) {
        MenuWindow m = new MenuWindow("Poznaj Nutki");
        m.setVisible(true);
    }
}
