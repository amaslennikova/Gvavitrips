import java.util.Random;

public class AiPlayer extends Player{
    
    @Override
    public boolean makeTurn(Board board, Player player) {
        Random rand = new Random();
        int cell = 0;
        int line = 0;
        boolean isTurnMade = false;
        while(!isTurnMade) {
            cell = rand.nextInt(6);
            line = board.findFreeLine(cell);
            if (!board.isCellFull(line)) {
                board.placeMark(cell, line, mark);
                isTurnMade = true;
            }
        }
        System.out.println(" ");
        System.out.println(player.name + " placed his mark to the collumn Nr." + cell);
        board.printBoard();
        return board.checkIfWins(mark, cell, line);
    }
}
