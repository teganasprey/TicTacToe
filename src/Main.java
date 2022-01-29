import javax.swing.JFrame;
import java.awt.*;
import java.util.*;

public class Main
{

    public static void main(String[] args)
    {
        JFrame frame = new JFrame();

        frame.setBounds(0, 0, 910, 1200);
        frame.setSize(new Dimension(910, 1200));
        frame.getContentPane().setSize(910, 1200);
        frame.setTitle("Tic Tac Toe! by Tegan Asprey");
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        TicTacToeGame game = new TicTacToeGame();
        frame.add(game);
        frame.setVisible(true);
    }

}