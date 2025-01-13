import java.util.Scanner;

public class TicTacToe{
    public static char[][] board = new char[4][4];
    private static char currentPlayer;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain;

        do {
            initializeBoard();
            currentPlayer = 'X';
            boolean gameWon = false;

            while (!gameWon && !isDraw()) {
                printBoard();
                playerMove(scanner);
                gameWon = checkWinner();
                if (!gameWon) {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            }

            printBoard();
            if (gameWon) {
                System.out.println("Player " + currentPlayer + " wins!");
            } else {
                System.out.println("It's a draw!");
            }

            System.out.print("Do you want to play again? (y/n): ");
            playAgain = scanner.next().equalsIgnoreCase("y");
        } while (playAgain);

        scanner.close();
    }

    private static void initializeBoard() {
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    private static void printBoard() {
        System.out.println("Current board:");
        for (int i = 1; i <= 3; i++) {
            System.out.print(" " + board[i][1] + " | " + board[i][2] + " | " + board[i][3]);
            System.out.println();
            if (i <= 2) {
                System.out.println("---|---|---");
            }
        }
    }

    private static void playerMove(Scanner scanner) {
        int row, col;
        while (true) {
            System.out.print("Player " + currentPlayer + ", enter your move (row and column): ");
            row = scanner.nextInt();
            col = scanner.nextInt();

            if (row >= 1 && row <= 3 && col >= 1 && col <= 3 && board[row][col] == ' ') {
                board[row][col] = currentPlayer;
                break;
            } else {
                System.out.println("This move is not valid. Try again.");
            }
        }
    }

    private static boolean checkWinner() {

        for (int i = 1; i <= 3; i++) {
            if ((board[i][1] == currentPlayer && board[i][1] == currentPlayer && board[i][3] == currentPlayer) ||
                    (board[1][i] == currentPlayer && board[2][i] == currentPlayer && board[3][i] == currentPlayer)) {
                return true;
            }
        }

        if ((board[1][1] == currentPlayer && board[2][2] == currentPlayer && board[3][3] == currentPlayer) ||
                (board[1][3] == currentPlayer && board[2][2] == currentPlayer && board[3][1] == currentPlayer)) {
            return true;
        }
        return false;
    }

    private static boolean isDraw() {
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}