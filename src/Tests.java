import org.junit.Assert;
import org.junit.Test;

public class Tests {
    Game game = new Game();
    Board board = new Board();
    
    @Test
    public void humanPlayersDefined() {
        int input = 2;
        game.definePlayers(input);
        Assert.assertEquals(HumanPlayer.class, game.player1.getClass());
        Assert.assertEquals(HumanPlayer.class, game.player2.getClass());
    }

    @Test
    public void humanAIPlayersDefined() {
        int input = 1;
        game.definePlayers(input);
        Assert.assertEquals(HumanPlayer.class, game.player1.getClass());
        Assert.assertEquals(AiPlayer.class, game.player2.getClass());
    }
    
    @Test
    public void playerCanPlaceMark() {
        int cell = 0;
        int line = 5;
        Mark mark = Mark.X;
        board.placeMark(cell, line, mark);
        Mark[][] boardArray = board.getBoard();
        assert boardArray[5][0] == Mark.X;
    }
    
    @Test
    public void checkIfWinsVertical() {
        board.placeMark(0, 5, Mark.X);
        board.placeMark(0, 4, Mark.X);
        board.placeMark(0, 3, Mark.X);
        board.placeMark(0, 2, Mark.X);
        assert true == board.checkIfWins(Mark.X, 0, 2);
    }

    @Test
    public void checkIfWinsHorizontal() {
        board.placeMark(0, 5, Mark.X);
        board.placeMark(1, 5, Mark.X);
        board.placeMark(2, 5, Mark.X);
        board.placeMark(3, 5, Mark.X);
        assert true == board.checkIfWins(Mark.X, 0, 2);
    }

    @Test
    public void checkIfWinsDiaganal() {
        board.placeMark(0, 5, Mark.X);
        board.placeMark(1, 5, Mark.O);
        board.placeMark(1, 4, Mark.X);
        board.placeMark(2, 5, Mark.O);
        board.placeMark(2, 4, Mark.X);
        board.placeMark(2, 3, Mark.X);
        board.placeMark(3, 5, Mark.O);
        board.placeMark(3, 4, Mark.X);
        board.placeMark(3, 3, Mark.O);
        board.placeMark(3, 2, Mark.X);
        board.printBoard();
        assert true == board.checkIfWins(Mark.X, 3, 2);
    }
}
