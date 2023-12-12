import java.awt.*; 
import javax.swing.*;

/** PuzzleWriter displays the contents of a slide puzzle */ 
public class PuzzleWriter extends JPanel { 
	private SlidePuzzleBoard board; 
	private final int SIZE = 30; // 퍼즐 조각의 크기 
	
	public PuzzleWriter(SlidePuzzleBoard b) { 
		board = b;
		JFrame f = new JFrame();
		f.getContentPane().add(this);
		f.setLocation(700,150);
		f.setTitle("Slide Puzzle");
		f.setSize(SIZE*6, SIZE*6+28);
		f.setVisible(true);
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	public void paintComponent(Graphics g) { 
		g.setColor(Color.yellow);
		g.fillRect(0, 0, SIZE*6, SIZE*6); 
		PuzzlePiece[][] r = board.contents(); 
		for (int i = 0; i < 4; i = i + 1) {
			for (int j = 0; j < 4; j = j + 1) { 
				paintPiece(g, r[i][j], i, j); 
			}
		} 
	}

	private void paintPiece(Graphics g, PuzzlePiece p, int i, int j) { 
		int x = SIZE + (SIZE * j); 
		int y = SIZE + (SIZE * i);
		if (p != null) {
			g.setColor(Color.white);
			g.fillRect(x, y, SIZE, SIZE); 
			g.setColor(Color.black);
			g.drawRect(x, y, SIZE, SIZE);
			int face_value = p.faceValue();
			if (face_value < 10) 
				g.drawString(face_value + "", x+11, y+20);
			else
				g.drawString(face_value + "", x+7, y+20);
		} 
		else {
			g.setColor(Color.black);
			g.fillRect(x, y, SIZE, SIZE);
		} 
	}
	
	/** 프레임에 현재 퍼즐 보드 그림 */ 
	public void displayPuzzle() { 
		this.repaint(); 
	}

	public void printError(String s) { 
		JOptionPane.showMessageDialog(null, "오류: " + s ); 
	} 
}
