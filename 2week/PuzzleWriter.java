import javax.swing.*;
import java.awt.*;

//output view
public class PuzzleWriter extends JPanel {
    private final int SIZE;
    private SlidePuzzleBoard Pb;

    public PuzzleWriter(SlidePuzzleBoard puzzleBoard){
        Pb = puzzleBoard;
        SIZE = 300;
        JFrame f = new JFrame();
        f.setTitle("Slide Puzzle"); //보드 이름 정하기
        f.setSize(SIZE,SIZE+22);    //보드 크기 정하기
        f.getContentPane().add(this);
        f.setVisible(true);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public void paintComponent(Graphics g){
        g.setColor(Color.YELLOW);
        g.fillRect(0,0,SIZE,SIZE+22);
        g.setColor(Color.BLACK);
        int first = 0;
        int second = 0;
        //for문으로 2차운 배열의 보드 색깔별로 출력하기
        for (int i = SIZE/6; i <= SIZE/6*4; i += SIZE/6) {
            for (int j = SIZE / 6; j <= SIZE / 6 * 4; j += SIZE / 6) {
                if(Pb.board[first][second]==0){
                    g.setColor(Color.BLACK);
                }else{
                    g.setColor(Color.WHITE);
                }
                g.fillRect(j,i,SIZE/6,SIZE/6);
                g.setColor(Color.BLACK);
                String ch = Integer.toString(Pb.board[first][second]);
                g.drawRect(j, i, SIZE / 6, SIZE / 6);
                g.drawString(ch,j+25,i+25);
                second += 1;
            }
            second = 0;
            first += 1;
        }
    }
    public void displayPuzzle(){
        this.repaint();
    }
}

