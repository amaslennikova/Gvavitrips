
public class Game {
    
    Board board = new Board();

    Player player1;
    Player player2;

    public void run() {
        UserInteraction userInt = new UserInteraction();
        int input = userInt.getMenuInput();
        definePlayers(input);
        boolean gameCompleted = false;
        Player currentPlayer = player1;
        board.printBoard();

        while (!gameCompleted) {
            System.out.println(currentPlayer.name + " please make your turn. Enter a number of cell to place your mark.");
            gameCompleted = currentPlayer.makeTurn(board, currentPlayer);
            if (gameCompleted) {
                System.out.println(currentPlayer.name + " wins.");
                break;
            }
            currentPlayer = switchPlayer(currentPlayer, player2);
        }
    }

    public void definePlayers(int input) {

        for (int i=0; i<10; i++) {
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
        }
        player1.mark = Mark.X;
        player1.name = "Player 1";
        player2.mark = Mark.O;
        player2.name = "Player 2";
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
