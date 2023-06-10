public class Main {
    public static void main(String[] args) {
        Board myboard = new Board();
        myboard.displayBoard();
        
        myboard.placeSym(4,1,"X");
    
        myboard.displayBoard();
    
    }
}