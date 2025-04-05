public class Board {
    Character[][] grid;

    Board() {
        grid = new Character[3][3];
    }

    void displayBoard() {
        System.out.println("== Board ==");
        for (Character[] gr : grid) {
            for (Character grc : gr) {
                System.out.print(grc == null ? " _ " : (" " + grc + " "));
            }
            System.out.println();
        }
    }

    boolean isPositionValid(int i, int j) {
        if (i<0 || i>2 || j<0 || j>2 || grid[i][j] != null)
            return false;
        else return true;
    }

    void addSign(Player player, int i, int j) {
        grid[i][j] = player.sign;
    }

    boolean isFull() {
        int count = 0;
        for (Character[] gr : grid)
            for (Character grc : gr)
                if (grc != null) count++;

        return count >= 9;
    }

    boolean isOver() {
        // Check rows
        for (int i = 0; i < 3; i++)
            if (grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2] && grid[i][2] != null) return true;

        // Check cols
        for (int j = 0; j < 3; j++)
            if (grid[0][j] == grid[1][j] && grid[1][j] == grid[2][j] && grid[2][j] != null) return true;

        // Check diagonal
        if (grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2] && grid[2][2] != null) return true;

        // Check anti-diagonal
        if (grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0] && grid[2][0] != null) return true;

        return false;
    }

}
