import javax.swing.*;

public class PuzzleController {

    private SlidePuzzleBoard board;
    private PuzzleWriter writer;

    public PuzzleController(SlidePuzzleBoard b, PuzzleWriter w){
        board = b;
        writer = w;
    }

    public void play() {
        while (true) {
            writer.displayPuzzleBoard(); //
            String input = JOptionPane.showInputDialog("움직일 퍼즐 조각 번호를 선택하세요.");
            int n = Integer.parseInt(input);
            if (! board.move(n))
                writer.printError("움직일 수 없습니다.");
        }
    }
}
