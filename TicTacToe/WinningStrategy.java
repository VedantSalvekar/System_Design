import java.util.*;
 
interface WinningStrategy{
    boolean checkWinner(Board board, PlayingPiece piece);
}

class RowWin implements WinningStrategy{
    public boolean checkWinner(Board board, PlayingPiece piece){
        int size = board.getSize();

        for(int r = 0; r<size;r++){
            boolean fullRow = true;
            for(int c = 0; c<size;c++){
                PlayingPiece cell = board.getPiece(r, c);
                if(cell == null || cell.getType() != piece.getType()){
                    fullRow = false;
                    break;
                }
            }
            if(fullRow) return true;
        }
        return false;
    }
}

class ColumnWin implements WinningStrategy {
    public boolean checkWinner(Board board, PlayingPiece piece) {
        int size = board.getSize();
 
        for (int col = 0; col < size; col++) {
            boolean fullCol = true;
            for (int row = 0; row < size; row++) {
                PlayingPiece cell = board.getPiece(row, col);
                if (cell == null || cell.getType() != piece.getType()) {
                    fullCol = false;
                    break;
                }
            }
            if (fullCol) return true;
        }
        return false;
    }
}
 
class DiagonalWin implements WinningStrategy {
    public boolean checkWinner(Board board, PlayingPiece piece) {
        int size = board.getSize();
 
        // Top-left to bottom-right: row index == col index (0,0) (1,1) (2,2)...
        boolean mainDiagonal = true;
        for (int i = 0; i < size; i++) {
            PlayingPiece cell = board.getPiece(i, i);
            if (cell == null || cell.getType() != piece.getType()) {
                mainDiagonal = false;
                break;
            }
        }
        if (mainDiagonal) return true;
 
        // Top-right to bottom-left: col index = size - 1 - row index
        boolean antiDiagonal = true;
        for (int i = 0; i < size; i++) {
            PlayingPiece cell = board.getPiece(i, size - 1 - i);
            if (cell == null || cell.getType() != piece.getType()) {
                antiDiagonal = false;
                break;
            }
        }
        return antiDiagonal;
    }
}
 