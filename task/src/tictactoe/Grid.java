package tictactoe;

public class Grid {
    private gridTile[][] symbolGrid = new gridTile[3][3];

    public Grid(String grid) {
        // Initialise grid
        symbolGrid = new gridTile[4][4];
        // Iterate through grid, assigning status from input
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                char currentChar = grid.charAt((3 * (i-1)) + (j-1));
                switch (currentChar) {
                    case 'X':
                        symbolGrid[i][j] = new gridTile(Symbol.CROSS, false);
                        break;
                    case 'O':
                        symbolGrid[i][j] = new gridTile(Symbol.NAUGHT, false);
                        break;
                    case '_':
                        symbolGrid[i][j] = new gridTile(Symbol.SPACE, true);
                        break;
                }
            }
        }
    }
    public boolean isCellFree(int row, int column){
        if (!symbolGrid[row][column].isEditable()) {
            System.out.println("This cell is occupied! Choose another one!");
            return false;
        }
        return true;
    }
    public boolean takeMove(int row, int column, Symbol status) {
        symbolGrid[row][column].setStatus(status);
        symbolGrid[row][column].setEditable(false);
        switch(status) {
            case NAUGHT:
                return analyseGrid() == GameState.OWIN;
            case CROSS:
                return analyseGrid() == GameState.XWIN;
        }
        return true;
    }
    public void displayGrid() {
        System.out.println("---------");
        for (int i = 1; i < 4; i++) {
            System.out.print("| ");
            for (int j = 1; j < 4; j++) {

                System.out.print(symbolGrid[i][j].getCharValue() + " ");
            }
            System.out.print("|\n");
        }
        System.out.println("---------");
    }

    public GameState analyseGrid() {
        boolean X_WIN = false, O_WIN = false;

        if ((symbolGrid[1][1].getStatus() == Symbol.CROSS && symbolGrid[1][2].getStatus() == Symbol.CROSS && symbolGrid[1][3].getStatus() == Symbol.CROSS) ||
                (symbolGrid[1][1].getStatus() == Symbol.CROSS && symbolGrid[2][1].getStatus() == Symbol.CROSS && symbolGrid[3][1].getStatus() == Symbol.CROSS) ||
                (symbolGrid[1][1].getStatus() == Symbol.CROSS && symbolGrid[2][2].getStatus() == Symbol.CROSS && symbolGrid[3][3].getStatus() == Symbol.CROSS) ||
            (symbolGrid[3][1].getStatus() == Symbol.CROSS && symbolGrid[2][2].getStatus() == Symbol.CROSS && symbolGrid[1][3].getStatus() == Symbol.CROSS) ||
                (symbolGrid[3][3].getStatus() == Symbol.CROSS && symbolGrid[2][3].getStatus() == Symbol.CROSS && symbolGrid[1][3].getStatus() == Symbol.CROSS) ||
        (symbolGrid[3][3].getStatus() == Symbol.CROSS && symbolGrid[3][2].getStatus() == Symbol.CROSS && symbolGrid[3][1].getStatus() == Symbol.CROSS) ||
                (symbolGrid[1][2].getStatus() == Symbol.CROSS && symbolGrid[2][2].getStatus() == Symbol.CROSS && symbolGrid[3][2].getStatus() == Symbol.CROSS) ||
                (symbolGrid[2][1].getStatus() == Symbol.CROSS && symbolGrid[2][2].getStatus() == Symbol.CROSS && symbolGrid[2][3].getStatus() == Symbol.CROSS)) {
            X_WIN = true;
   }
        else if ((symbolGrid[1][1].getStatus() == Symbol.NAUGHT && symbolGrid[1][2].getStatus() == Symbol.NAUGHT && symbolGrid[1][3].getStatus() == Symbol.NAUGHT) ||
                (symbolGrid[1][1].getStatus() == Symbol.NAUGHT && symbolGrid[2][1].getStatus() == Symbol.NAUGHT && symbolGrid[3][1].getStatus() == Symbol.NAUGHT) ||
                (symbolGrid[1][1].getStatus() == Symbol.NAUGHT && symbolGrid[2][2].getStatus() == Symbol.NAUGHT && symbolGrid[3][3].getStatus() == Symbol.NAUGHT) ||
                (symbolGrid[3][1].getStatus() == Symbol.NAUGHT && symbolGrid[2][2].getStatus() == Symbol.NAUGHT && symbolGrid[1][3].getStatus() == Symbol.NAUGHT) ||
                (symbolGrid[3][3].getStatus() == Symbol.NAUGHT && symbolGrid[2][3].getStatus() == Symbol.NAUGHT && symbolGrid[1][3].getStatus() == Symbol.NAUGHT) ||
                (symbolGrid[3][3].getStatus() == Symbol.NAUGHT && symbolGrid[3][2].getStatus() == Symbol.NAUGHT && symbolGrid[3][1].getStatus() == Symbol.NAUGHT) ||
                (symbolGrid[1][2].getStatus() == Symbol.NAUGHT && symbolGrid[2][2].getStatus() == Symbol.NAUGHT && symbolGrid[3][2].getStatus() == Symbol.NAUGHT) ||
                (symbolGrid[2][1].getStatus() == Symbol.NAUGHT && symbolGrid[2][2].getStatus() == Symbol.NAUGHT && symbolGrid[2][3].getStatus() == Symbol.NAUGHT)) {
            O_WIN = true;
        }

        if (X_WIN) {
            return GameState.XWIN;
        }
        else if (O_WIN) {
            return GameState.OWIN;
        }
        else {
            return GameState.DRAW;
        }
    }

    public boolean isFull() {
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                if (symbolGrid[i][j].isEditable()) {
                    return false;
                }
            }
        }
        return true;
    }
}