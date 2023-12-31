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
    
        Player currPlayer = player1;
        String message = currPlayer.name + ", please make a move";
        
        Game game = new Game(player1, player2);
    
    
        int col;
        int row;
        int index = 0;
        int turnCounter = 0;
        
        
        while (!game.isEnd()) {
            
            if (turnCounter == 0) {
                System.out.println("Here's the board. " + currPlayer.name + ", please make the first move.");
                game.getBoard().displayBoard();
            }
            
            else System.out.println(message);
            
            turnCounter ++;
            col = (new Scanner(System.in).nextInt()) - 1; // since row/col starts at 0
            row = (new Scanner(System.in).nextInt()) - 1;
            boolean didMove = game.getBoard().placeSym(col,row,currPlayer.sym);
            
            // game end conditions
            
            // win (horizontal, vertical, and diagonal)
            int winrow1 = 4; //initialise out of bounds
            int wincol1 = 4;
            int winrow2 = 4;
            int wincol2 = 4;
            int winrow3 = 4;
            int wincol3 = 4;
            
            if // horizontal
            (
                    
                    ((game.getBoard().board[0][row].getSymbol() != null &&
                    game.getBoard().board[1][row].getSymbol() != null &&
                    game.getBoard().board[2][row].getSymbol() != null )
                            &&
                    (game.getBoard().board[0][row].getSymbol().equals(currPlayer.sym) &&
                    game.getBoard().board[1][row].getSymbol().equals(currPlayer.sym) &&
                    game.getBoard().board[2][row].getSymbol().equals(currPlayer.sym)))
            ) {
                winrow1 = row;
                winrow2 = row;
                winrow3 = row;
                wincol1 = 0;
                wincol2 = 1;
                wincol3 = 2;
    
                game.setStatus(Status.WIN);
            }
            else if ( // vertical
                    
                    ((game.getBoard().board[col][0].getSymbol() != null &&
                    game.getBoard().board[col][1].getSymbol() != null &&
                    game.getBoard().board[col][2].getSymbol() != null )
                            &&
                    (game.getBoard().board[col][0].getSymbol().equals(currPlayer.sym) &&
                    game.getBoard().board[col][1].getSymbol().equals(currPlayer.sym) &&
                    game.getBoard().board[col][2].getSymbol().equals(currPlayer.sym)))
            ) {
                winrow1 = 0;
                winrow2 = 1;
                winrow3 = 2;
                wincol1 = col;
                wincol2 = col;
                wincol3 = col;
    
                game.setStatus(Status.WIN);
            }
            else if ( // diagonal

                    ((game.getBoard().board[0][2].getSymbol() != null &&
                    game.getBoard().board[1][1].getSymbol() != null &&
                    game.getBoard().board[2][0].getSymbol() != null )
                            &&
                    (game.getBoard().board[0][2].getSymbol().equals(currPlayer.sym) &&
                    game.getBoard().board[1][1].getSymbol().equals(currPlayer.sym) &&
                    game.getBoard().board[2][0].getSymbol().equals(currPlayer.sym)))
            ) {
                winrow1 = 0;
                winrow2 = 1;
                winrow3 = 2;
                wincol1 = 2;
                wincol2 = 1;
                wincol3 = 0;
    
                game.setStatus(Status.WIN);
            }
            else if ( // diagonal
                    
                    ((game.getBoard().board[0][0].getSymbol() != null &&
                    game.getBoard().board[1][1].getSymbol() != null &&
                    game.getBoard().board[2][2].getSymbol() != null )
                            &&
                    (game.getBoard().board[0][0].getSymbol().equals(currPlayer.sym) &&
                    game.getBoard().board[1][1].getSymbol().equals(currPlayer.sym) &&
                    game.getBoard().board[2][2].getSymbol().equals(currPlayer.sym)))
                    
                )
            {
                winrow1 = 0;
                winrow2 = 1;
                winrow3 = 2;
                wincol1 = 0;
                wincol2 = 1;
                wincol3 = 2;
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
                message = currPlayer.name + ", please make a move";
                System.out.println("Cool! Here's the board so far");
            }
            
            if (!game.isEnd()) game.getBoard().displayBoard();
            else {
                game.getBoard().displayBoard(winrow1,wincol1,winrow2,wincol2,winrow3,wincol3);
                System.out.println("Congratulations " + currPlayer.name + "! You won the game :)");
                
    
            }
            
        }
    }
}