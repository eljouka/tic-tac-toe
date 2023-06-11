public class Board {
    public Tile[][] board;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\033[1;30m";
    public static final String ANSI_WHITE = "\033[1;97m";
    
    public Board() {
        this.board = new Tile[3][3];
        this.board = generateBoard();
    }
    // i : rows
    // j : cols
    
    public boolean placeSym(int col, int row, String sym) {
        boolean didMove = true;
        try {
            if (board[col][row].getSymbol() == null) {
                board[col][row].setSymbol(sym);
                System.out.println("**** making a move");
                
            }
            else {
                System.out.println("Oops, please choose an unoccupied space");
                didMove = false;
            }
        }
        
        catch(Exception ArrayIndexOutOfBoundsException) {
            System.out.println("Oops, you drew outside the board, try again!");
            didMove = false;
        }
        return didMove;
    }
    public Tile[][] generateBoard() {
        for (int i = 2; i >= 0; i--) {
            for (int j = 0; j <= 2; j++) {
                board[j][i] = new Tile(j,i);
            }
            
        }
        
        return board;
    }
    
    
    // winning board
   public void displayBoard(int row1, int col1, int row2, int col2, int row3, int col3) {
       System.out.println("");
       for (int i = 2; i >= 0; i--) {
           System.out.print((i+1) + "  ");
        
           for (int j = 0; j <= 2; j++) {
               String sym;
               
               if (board[j][i].getSymbol() == null) {
                   System.out.print("   ");
               }
               else {
                   if ((i == row1 && j == col1) || (i == row2 && j == col2) || (i == row3 && j == col3)) {
                       sym = "☺";
                   }
                   else if (board[j][i].getSymbol().equals("X")) sym = "X";
                   else sym = "O";
                   System.out.print(" " + sym);
               }
           }
           System.out.println("");
        
       }
       System.out.println("\t1  2  3");
   }
   
   public void displayBoard() {
        displayBoard(1000,1000,1000, 1000, 1000, 1000);
   }
   
}
