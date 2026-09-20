import java.util.*;
 
class Board{
    private int size;
    private PlayingPiece[][] grid;

    Board(int size){
        this.size = size;
        this.grid = new PlayingPiece[size][size];
    }
    int getSize(){
        return size;
    }
    boolean isCellEmpty(int row, int col){
        return grid[row][col] == null;
    }
    boolean addPiece(int row, int col, PlayingPiece piece){
        if(row<0||col<0||row>=size||col>=size) return false;
        if(!isCellEmpty(row,col))return false;
        grid[row][col] = piece;
        return true;
    }
    PlayingPiece getPiece(int row, int col){
        return grid[row][col];
    }
    void printBoard(){
        for(int i = 0; i<size;i++){
            StringBuilder row = new StringBuilder();
            for(int j = 0; j<size; j++){
                PlayingPiece p = grid[i][j];
                row.append(p==null? "-" : p.getType()).append(" ");
            }
            System.out.println(row.toString().trim());
        }
    }
}