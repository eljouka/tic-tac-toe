public class Game {
    public Player[] players;
    private Board board;
    private Status status;
    
    public Game(Player p1, Player p2) {
        board = new Board();
        this.players = new Player[2];
        
        this.players[0] = p1;
        this.players[1] = p2;
        
        this.board.generateBoard();
        this.board.displayBoard();
    }
    
    public Status getStatus() {
        return this.status;
    }
    
    public Board getBoard() {
        return this.board;
    }
    
    public void setStatus(Status status) {
        this.status = status;
    }
    
    public boolean isEnd() {
        return (this.getStatus() == Status.P1WIN || this.getStatus() == Status.P2WIN || this.getStatus() == Status.DRAW);
    }
    
    
    
    
}
