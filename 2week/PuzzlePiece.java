public class PuzzlePiece {
    private int face_value; // 퍼즐 조각 위에 표시되는 값

    public int faceValue() { // 퍼즐 조각의 값 리턴
        return face_value;
    }

    public PuzzlePiece(int n) {
        face_value = n;
    }

}
