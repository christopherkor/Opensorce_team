import javax.swing.*;
import java.awt.*;

public class PuzzleFrame extends JFrame {
    private SlidePuzzleBoard board;
    private PuzzleButton[][] button_board;
    private StartButton startButton;
    private TimeChecker time;
    PuzzleFrame(SlidePuzzleBoard b){
        board = b;
        button_board = new PuzzleButton[4][4];
        JLabel time_label = new JLabel();
        time = new TimeChecker(time_label, board);
        startButton = new StartButton(board, this, time);
        Container cp = getContentPane();

        cp.setLayout(new BorderLayout());

        JPanel p1 = new JPanel(new FlowLayout());
        p1.add(startButton);
        p1.add(time_label);
        cp.add(p1, BorderLayout.NORTH);

        JPanel p2 = new JPanel(new GridLayout(4,4));
        for (int row = 0; row < 4; row++)
            for (int col = 0; col < 4; col++) {
                button_board[row][col] = new PuzzleButton(board,this);
                p2.add(button_board[row][col]);
            }
        cp.add(p2, BorderLayout.CENTER);
        update();
        setTitle("Slide Puzzle");
        setSize(250,300);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public void update() {
        PuzzlePiece pp;
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                pp = board.getPuzzlePiece(row, col);
                if (pp != null)
                    button_board[row][col].setText(Integer.toString(pp.face()));
                else
                    button_board[row][col].setText("");
            }
        }
    }
    public void finish(){
        button_board[3][3].setText("Done");
        time.game_run =false;
        time.run();
    }
}
