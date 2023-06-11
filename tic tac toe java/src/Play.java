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
        
        String message;
        String defaultMessage = currPlayer.name + ", please make a move";
        
        int col;
        int row;
        int index = 0;
        int turnCounter = 0;
    
        while (!game.isEnd()) {
            turnCounter ++;
            message = defaultMessage;
            col = (new Scanner(System.in).nextInt()) - 1; // since row/col starts at 0
            row = (new Scanner(System.in).nextInt()) - 1;
            boolean didMove = game.getBoard().placeSym(col,row,currPlayer.sym);
            
            // game end conditions
            
            // win (horizontal, vertical, and diagonal)
            if
            (
                    // horizontal
                    ((game.getBoard().board[0][row].getSymbol() != null &&
                    game.getBoard().board[1][row].getSymbol() != null &&
                    game.getBoard().board[2][row].getSymbol() != null )
                            &&
                    (game.getBoard().board[0][row].getSymbol().equals(currPlayer.sym) &&
                    game.getBoard().board[1][row].getSymbol().equals(currPlayer.sym) &&
                    game.getBoard().board[2][row].getSymbol().equals(currPlayer.sym)))
                    
                    || // vertical
                    
                    ((game.getBoard().board[col][0].getSymbol() != null &&
                    game.getBoard().board[col][1].getSymbol() != null &&
                    game.getBoard().board[col][2].getSymbol() != null )
                            &&
                    (game.getBoard().board[col][0].getSymbol().equals(currPlayer.sym) &&
                    game.getBoard().board[col][1].getSymbol().equals(currPlayer.sym) &&
                    game.getBoard().board[col][2].getSymbol().equals(currPlayer.sym)))
        
                    || // diagonal

                    ((game.getBoard().board[0][2].getSymbol() != null &&
                    game.getBoard().board[1][1].getSymbol() != null &&
                    game.getBoard().board[2][0].getSymbol() != null )
                            &&
                    (game.getBoard().board[0][2].getSymbol().equals(currPlayer.sym) &&
                    game.getBoard().board[1][1].getSymbol().equals(currPlayer.sym) &&
                    game.getBoard().board[2][0].getSymbol().equals(currPlayer.sym)))
                    
                    || // diagonal
                    
                    ((game.getBoard().board[0][0].getSymbol() != null &&
                    game.getBoard().board[1][1].getSymbol() != null &&
                    game.getBoard().board[2][2].getSymbol() != null )
                            &&
                    (game.getBoard().board[0][0].getSymbol().equals(currPlayer.sym) &&
                    game.getBoard().board[1][1].getSymbol().equals(currPlayer.sym) &&
                    game.getBoard().board[2][2].getSymbol().equals(currPlayer.sym)))
                    
                )
                
            {
                if (currPlayer.num == 1) {
                    game.setStatus(Status.P1WIN);
                    message = "Congratulations " + player1.name + "! You won the game :)";
                }
                else {
                    game.setStatus(Status.P2WIN);
                    message = "Congratulations " + player2.name + "! You won the game :)";
                }
            }
            
            // draw
            else if (turnCounter == 9) {
                game.setStatus(Status.DRAW);
                message = "Looks like it's a draw :(";
            }
    
    
            else if (didMove) {
                index ++;
                if (index == game.players.length) index = 0;
                currPlayer = game.players[index];
            }
            
            game.getBoard().displayBoard();
            System.out.println(message);
        }
    }
}