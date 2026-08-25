import javax.swing.*;

public class Main extends JFrame{
    public Main() {
        setTitle("Japanese Flashcards");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300,200);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args){
        new Main();
    }

}
