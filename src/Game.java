import java.util.Scanner;

public class Game {

    Scanner scanner = new Scanner(System.in);

    Board board = new Board();

    Player player1;
    Player player2;

    public void run() {
        definePlayers();
        boolean gameCompleted = false;
        Player currentPlayer = player1;
        board.printBoard();

        while (!gameCompleted) {
            gameCompleted = currentPlayer.makeTurn(board, currentPlayer);
            if (gameCompleted) {
                System.out.println(currentPlayer.name + " wins.");
                break;
            }
            currentPlayer = switchPlayer(currentPlayer, player2);
        }
    }

    private void definePlayers() {

        for (int i=0; i<10; i++) {
            Integer input = getPlayerInt();
            if (input == 1) {
                player1 = new HumanPlayer();
                player2 = new AiPlayer();
                break;
            }
            if (input == 2) {
                player1 = new HumanPlayer();
                player2 = new HumanPlayer();
                break;
            }
            if (input == 0) {
                player1 = new AiPlayer();
                player2 = new AiPlayer();
                break;
            }
            System.out.println("Your input is incorrect. Please enter '0', '1' or '2'.");
        }
        player1.mark = Mark.X;
        player1.name = "Player 1";
        player2.mark = Mark.O;
        player2.name = "Player 2";
    }
    
    private Integer getPlayerInt() {
        System.out.println("Hello! Lets start a game. How many players will play? Press '0', '1' or '2'.");
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
