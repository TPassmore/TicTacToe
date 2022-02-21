package tictactoe;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Grid newGrid = new Grid("_________");
        newGrid.displayGrid();

        Player player1 = new Player(Symbol.CROSS);
        Player player2 = new Player(Symbol.NAUGHT);
        Player players[] = {player1, player2};

        int winner = 0;

        while (!(players[0].isWinner()) && !(players[1].isWinner())) {
           for (int i = 0; i < 2; i++){
                int cellInput[] = getInput(newGrid);
                players[i].won(newGrid.takeMove(cellInput[0], cellInput[1], players[i].getSymbol()));
                if (players[i].isWinner()) {
                    winner = i;
                    break;
                }
                if (newGrid.isFull()){
                    displayGameState(GameState.DRAW);
                    break;
                }
                newGrid.displayGrid();
            }
        }
        newGrid.displayGrid();
        displayGameState(newGrid.analyseGrid());
    }
    private static void displayGameState(GameState gameState){
            switch(gameState) {
            case XWIN:
                System.out.println("X wins");
                break;
            case OWIN:
                System.out.println("O wins");
                break;
            case DRAW:
                System.out.println("Draw");
                break;
        }

    }
    private static int[] getInput(Grid grid) {
        String row, column;
        int row_int = 1, column_int = 1;
        boolean invalid_coods = true;
        while (invalid_coods){
            invalid_coods = false;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter row and colum to place your symbol (FORMAT: [row][space][column]): ");
            row = scanner.next();
            column = scanner.next();
            if (!isNumeric(row) || !isNumeric(column)) {
                System.out.println("You should enter numbers!");
                invalid_coods = true;
            }
            else {
                row_int = Integer.parseInt(row);
                column_int = Integer.parseInt(column);
                if (row_int < 1 || row_int > 3 || column_int < 1 || column_int > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    invalid_coods = true;
                }
                else {
                    if (!grid.isCellFree(row_int, column_int)) {
                        invalid_coods = true;
                    }
                }
            }
        }

        return new int[]{row_int, column_int};
    }
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

}
