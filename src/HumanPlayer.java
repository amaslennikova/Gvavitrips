import java.util.Scanner;

public class HumanPlayer extends Player{
    Scanner scanner = new Scanner(System.in);

    @Override
    public boolean makeTurn(Board board, Player player) {
        System.out.println(player.name + " please make your turn. Enter a number of cell to place your mark.");
        int cell = 0;
        int line = 0;
        boolean isTurnMade = false;
        while (!isTurnMade) {
            cell = scanner.nextInt();
            if (board.checkIfCellInRange(cell)) {
                line = board.findFreeLine(cell);
                if (!board.isCellFull(line)) {
                    board.placeMark(cell, line, mark);
                    isTurnMade = true;
                } else {
                    System.out.println("This cell is full. Please choose another one.");
                }
            } else {
                System.out.println("You entered incorrect cell number. PLease enter a cell number from 0 to 6.");
            }
        } 
        System.out.println(player.name + " placed his mark to cell Nr." + cell);
        board.getBoard();
        return board.checkIfWins(mark, cell, line);
    }
}
