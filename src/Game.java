import java.util.Scanner;

public class Game {

    Scanner scanner = new Scanner(System.in);

    Board board = new Board();

    HumanPlayer player1 = new HumanPlayer();

    public void run() {
        board.setBoard();
        Player player2 = definePlayers();
        boolean gameCompleted = false;
        Player currentPlayer = player1;
        board.getBoard();

        while (!gameCompleted) {
            gameCompleted = currentPlayer.makeTurn(board, currentPlayer);
            if (gameCompleted) {
                System.out.println(currentPlayer.name + " wins.");
                break;
            }
            currentPlayer = switchPlayer(currentPlayer, player2);
        }
    }

    private Player definePlayers() {
        Player player2;
        player1.mark = Mark.X;
        player1.name = "Player 1";

        for (int i=0; i<10; i++) {
            Integer input = getPlayerInt();
            if (input == 1) {
                player2 = new AiPlayer();
                player2.mark = Mark.O;
                player2.name = "Player 2";
                return player2;
            }
            if (input == 2) {
                player2 = new HumanPlayer();
                player2.mark = Mark.O;
                player2.name = "Player 2";
                return player2;
            }
            System.out.println("Your input is incorrect. Please enter '1' or '2'.");
        }
        return null;
    }
    
    private Integer getPlayerInt() {
        System.out.println("Hello! Lets start a game. How many players will play? Press '1' or '2'.");
        return scanner.nextInt();
    }

    private Player switchPlayer(Player currentPlayer, Player player2) {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
        return currentPlayer;
    }
}
