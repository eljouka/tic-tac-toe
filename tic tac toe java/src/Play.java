import java.util.Scanner;

public class Play {
    
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to Tic-Tac-Toe! This is a 2-player game.");
        System.out.println("Player 1, what is your name?");
        String player1Name = new Scanner(System.in).nextLine();
        System.out.println("Player 2, what is your name?");
        String player2Name = new Scanner(System.in).nextLine();
        
        
        Player player1 = new Player(player1Name, "X",1);
        Player player2 = new Player(player2Name, "O",2);
        
        Game game = new Game(player1, player2);
        
        Player currPlayer = player1;
        
        int col;
        int row;
        int index = 0;
        int turnCounter = 0;
    
        while (!game.isEnd()) {
            turnCounter ++;
            System.out.println(currPlayer.name + ", please make a move");
            
            col = new Scanner(System.in).nextInt();
            row = new Scanner(System.in).nextInt();
            boolean didMove = game.getBoard().placeSym(col,row,currPlayer.sym);
            
            // game end conditions
            
            // draw
            if (turnCounter == 9) {
                game.setStatus(Status.DRAW);
                System.out.println("Looks like it's a draw :(");
            }
            
            // win (horizontal and vertical)
            if
            (
                    ((game.getBoard().board[0][row].getSymbol() != null &&
                    game.getBoard().board[1][row].getSymbol() != null &&
                    game.getBoard().board[2][row].getSymbol() != null )
                            &&
                    (game.getBoard().board[0][row].getSymbol().equals(currPlayer.sym) &&
                    game.getBoard().board[1][row].getSymbol().equals(currPlayer.sym) &&
                    game.getBoard().board[2][row].getSymbol().equals(currPlayer.sym)))
                    
                    ||
                    
                    ((game.getBoard().board[col][0].getSymbol() != null &&
                    game.getBoard().board[col][1].getSymbol() != null &&
                    game.getBoard().board[col][2].getSymbol() != null )
                            &&
                    (game.getBoard().board[col][0].getSymbol().equals(currPlayer.sym) &&
                    game.getBoard().board[col][1].getSymbol().equals(currPlayer.sym) &&
                    game.getBoard().board[col][2].getSymbol().equals(currPlayer.sym)))
                )
                
            {
                if (currPlayer.num == 1)
                    game.setStatus(Status.P1WIN);
                else game.setStatus(Status.P2WIN);
            }
    
    
            if (didMove) {
                index ++;
                if (index == game.players.length) index = 0;
                currPlayer = game.players[index];
        
                System.out.println("**** changing current");
            }
            game.getBoard().displayBoard();
            
        }
        
        if (game.getStatus() == Status.P1WIN) {
            System.out.println("Congratulations " + player1.name + "! You won the game :)");
        }
        else {
            System.out.println("Congratulations " + player2.name + "! You won the game :)");
        }
    }
}