import java.util.Scanner;

public class Game {
    Board board;
    Player player1;
    Player player2;
    Player playerWithChance;
    Player winner;

    Game() {
        board = new Board();
        player1 = new Player("Player 1", 'X');
        player2 = new Player("Player 2", 'O');
    }

    void playGame() {
        playerWithChance = player1;

        // While there is no winner and board is not full
        while (winner == null && !board.isFull()) {
            // Display board
            board.displayBoard();
            // Ask for position from player with chance
            System.out.println(playerWithChance.getDisplayName() + ", please enter position...");

            // Get positions
            Scanner inputScanner = new Scanner(System.in);
            System.out.print("Enter row: ");
            int i = inputScanner.nextInt();
            System.out.print("Enter column: ");
            int j = inputScanner.nextInt();

            // Check if entered position is valid
            if (!board.isPositionValid(i, j)) {
                System.out.println("Invalid position entered");
                System.out.println();
                continue;
            }

            // Add sign
            board.addSign(playerWithChance, i, j);
            // Check for winner
            if (board.isOver()) winner = playerWithChance;
            // Change chance
            playerWithChance = playerWithChance == player1 ? player2 : player1;

            System.out.println();
        }

        // Declare result
        System.out.println("== Result ==");
        if (winner == null) System.out.println("Draw");
        else System.out.println(winner.getDisplayName() + " has won");
    }

}
