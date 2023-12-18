public class SlidePuzzleBoard {
    private PuzzlePiece[][] board;
    private int empty_row;
    private int empty_col;

    public SlidePuzzleBoard(){
        int number = 15;
        board = new PuzzlePiece[4][4];
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                board[i][j] = new PuzzlePiece(number);
                number --;
            }
        }
        empty_row = 3;
        empty_col = 3;
        board[empty_row][empty_col] = null;
    }

    public PuzzlePiece getPuzzlePiece(int row, int col){
        return board[row][col];
    }

    public boolean move(int w){
        int row, col;
        if (found(w, empty_row+1 , empty_col)){
            row = empty_row+1;
            col = empty_col;
        }
        else if(found(w, empty_row, empty_col+1)){
            row = empty_row;
            col = empty_col+1;
        }
        else if (found(w, empty_row-1, empty_col)) {
            row = empty_row-1;
            col = empty_col;
        }
        else if (found(w, empty_row, empty_col-1)) {
            row = empty_row;
            col = empty_col-1;
        } else {
            return false;
        }
        board[empty_row][empty_col] = board[row][col];
        board[row][col] = null;
        empty_row = row;
        empty_col = col;
        return true;
    }

    public boolean found(int v, int row, int col) {
        if (row >= 0 && row <= 3 && col >= 0 && col <= 3) {
            PuzzlePiece piece = board[row][col];
            return piece.faceValue() == v;
        }
        else
            return false;
    }

}
