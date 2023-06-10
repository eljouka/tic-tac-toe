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
    
        while (!game.isEnd()) {
            System.out.println(currPlayer.name + ", please make a move");
            
            col = new Scanner(System.in).nextInt();
            row = new Scanner(System.in).nextInt();
            
            if (game.getBoard().placeSym(col,row,currPlayer.sym)) {
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