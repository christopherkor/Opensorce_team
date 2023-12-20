import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PuzzleFrame extends JFrame {

    private SlidePuzzleBoard board;
    private PuzzleButton[][] button_board;
    private JLabel timerLabel; // 시간을 표시할 라벨
    private Timer timer; // 시간을 측정할 타이머
    private int elapsedSeconds = 0; // 지난 시간 (초)


    public PuzzleFrame(SlidePuzzleBoard b) {
        board = b;
        button_board = new PuzzleButton[4][4];
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        JPanel p1 = new JPanel(new FlowLayout());
        p1.add(new StartButton(board,this));
        JPanel p2 = new JPanel(new GridLayout(4,4));
        for (int row = 0; row < 4; row++)
            for (int col = 0; col < 4; col++) {
                button_board[row][col] = new PuzzleButton(board,this);
                p2.add(button_board[row][col]);
            }
        cp.add(p1,BorderLayout.NORTH);
        cp.add(p2,BorderLayout.CENTER);
        update();
        setTitle("Slide Puzzle");
        setSize(250,300);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        timerLabel = new JLabel("00:00:00");
        p1.add(timerLabel); // StartButton 옆에 라벨 추가

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elapsedSeconds++;
                int hours = elapsedSeconds / 3600;
                int minutes = (elapsedSeconds % 3600) / 60;
                int seconds = elapsedSeconds % 60;
                timerLabel.setText(String.format("%02d:%02d:%02d", hours, minutes, seconds));
            }
        });
    }

    public void update() {
        for (int row = 0; row < 4; row++)
            for (int col = 0; col < 4; col++) {
                PuzzlePiece pp = board.getPuzzlePiece(row, col);
                if (pp != null) {
                    String n = Integer.toString(pp.faceValue());
                    button_board[row][col].setText(n);
                }
                else
                    button_board[row][col].setText("");
            }
    }

    public void startTimer() {
        elapsedSeconds = 0;
        timer.start();
    }

    public void finish() {
        button_board[3][3].setText("Done");
        timer.stop();
        int hours = elapsedSeconds / 3600;
        int minutes = (elapsedSeconds % 3600) / 60;
        int seconds = elapsedSeconds % 60;
        String time = String.format("소요시간 : %02d:%02d:%02d", hours, minutes, seconds);
        JOptionPane.showMessageDialog(this, time, "메시지", JOptionPane.INFORMATION_MESSAGE);
    }


}
