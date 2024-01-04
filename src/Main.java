/**
 * Klasa główna programu, zawierająca metodę main.
 */
public class Main {
    /**
     * Metoda główna programu, rozpoczyna jego wykonanie.
     * Tworzy obiekt klasy Window i ustawia jego widoczność.
     * @param args Argumenty przekazane do programu.
     */
    public static void main(String[] args) {
        Window m = new Window(1024, 768);
        m.setVisible(true);
    }
}