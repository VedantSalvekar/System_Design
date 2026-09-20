import java.util.*;
 
class Player{
    private String name;
    private PlayingPiece piece;

    Player(String name, PlayingPiece piece){
        this.name = name;
        this.piece = piece;
    }
    String getName(){return name;}
    PlayingPiece getPiece(){return piece;}
}