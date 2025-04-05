public class SnakeAndLadderGame {
    Board board;
    Dice dice;
    Player player1;
    Player player2;
    Player playerWithChance;
    Player winner;

    SnakeAndLadderGame() {
        board = new Board();
        dice = new Dice();

        player1 = new Player("Player1", board.startPosition);
        player2 = new Player("Player2", board.startPosition);
    }

    void play () {
        // Display start position
        System.out.println(player1.name + " " + player1.position);
        System.out.println(player2.name + " " + player2.position);
        playerWithChance = player1;

        while (winner == null) {
            // Update player's position and print
            playerWithChance.position = board.getNewPosition(playerWithChance.position,  dice.roll());
            System.out.println(playerWithChance.name + " " + playerWithChance.position);

            // Check for winner
            if (board.isEndPosition(playerWithChance.position)) winner = playerWithChance;

            // Change chance
            playerWithChance = playerWithChance == player1 ? player2 : player1;
        }

        // Declare result
        System.out.println("== Result ==");
        System.out.println(winner.name + " has won");
    }
}
