import java.util.*;
 
class Game{
    private Board board;
    private List<Player> players;
    private int currPlayerIdx;
    private List<WinningStrategy> strats;
    private GameState state;

    Game(int boardSize, List<Player> players){
        this.board = new Board(boardSize);
        this.players = players;
        this.currPlayerIdx = 0;
        this.strats = List.of(
            new RowWin(),
            new ColumnWin(),
            new DiagonalWin()
        );
        this.state = GameState.IN_PROGRESS;
    } 

    void startGame(Scanner scanner){
        while(state == GameState.IN_PROGRESS){
            board.printBoard();
            Player curr = players.get(currPlayerIdx);
            System.out.println(curr.getName() + "'s turn (" + curr.getPiece().getType() + "). Enter row col:");

            int row = scanner.nextInt();
            int col = scanner.nextInt();

            boolean placed = board.addPiece(row, col, curr.getPiece());
            if(!placed){
                System.out.println("Invalid move, try again");
                continue;
            }
            if(checkWin(curr)){
                state = (curr.getPiece().getType() == PieceType.X)
                    ? GameState.X_WON
                    : GameState.O_WON;
                System.out.println(curr.getName() + "wins!");
                break;
            }
            if(isBoardFull()){
                state = GameState.DRAW;
                System.out.println("It's a draw!");
                break;
            }
            switchTurn();
        }
        board.printBoard();
    }

    boolean checkWin(Player player){
        for(WinningStrategy s : strats){
            if(s.checkWinner(board, player.getPiece())){
                return true;
            }
        }
        return false;
    }
    private boolean isBoardFull(){
        int size = board.getSize();
        for(int r = 0; r<size;r++){
            for(int c = 0; c<size;c++){
                if(board.isCellEmpty(r,c))return false;
            }
        }
        return true;
    }
    void switchTurn(){
        currPlayerIdx = (currPlayerIdx+1)%players.size();
    }
}