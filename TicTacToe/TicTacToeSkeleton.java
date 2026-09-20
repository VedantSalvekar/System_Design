import java.util.*;
 

public class TicTacToeSkeleton{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        System.out.println("Enter board size (n for n x n):");
        int size = s.nextInt();

        Player p1 = new Player("Player1", new PlayingPiece(PieceType.X));
        Player p2 = new Player("Player2", new PlayingPiece(PieceType.O));

        Game g = new Game(size, List.of(p1,p2));
        g.startGame(s);
    }
}