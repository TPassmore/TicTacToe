package tictactoe;

public enum Symbol {
    CROSS('X'),
    NAUGHT('O'),
    SPACE('_');

    public final char val;
    Symbol(char val) {
        this.val = val;
    }

    public char getState() {
        return val;
    }

}
