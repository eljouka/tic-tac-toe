public class Tile {
    private String symbol;
    private int row;
    private int col;
    
    public Tile(int row, int col) {
        this.row = row;
        this.col = col;
        this.symbol = null;
    }
    
    public void setSymbol(String sym) {
        this.symbol = sym;
    }
    
    public void setRow(int row) {
        this.row = row;
    }
    
    public void setCol(int col) {
        this.col = col;
    }
    
    public String getSymbol() {
        return this.symbol;
    }
    
    public int getRow() {
        return this.row;
    }
    
    public int getCol() {
        return this.col;
    }
}
