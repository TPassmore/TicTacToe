package tictactoe;

public class Player {
    private boolean gameWon;
    private Symbol character;
    public Player(Symbol character) {
        gameWon = false;
        this.character = character;
    }
    public void won(boolean gameWon) {this.gameWon = gameWon;}
    public boolean isWinner() {return gameWon;}
    public Symbol getSymbol() {return character;}
}
