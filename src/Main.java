import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("What size board do you want to play on? ");
        System.out.print("Height (Rows): ");
        int height = Integer.valueOf(scanner.nextLine());
        System.out.print("Width (Columns): ");
        int length = Integer.valueOf(scanner.nextLine());

        Board board = new Board(height, length);

        int player = 1;
        int column;
        int result = 0;

        while(true) {
            System.out.println("It's player " + player + "'s turn.");
            do {
                System.out.print("Which column do you select: ");
                column = Integer.valueOf(scanner.nextLine());
                result = board.putPiece(column, player);
                if (result == 1) {
                    System.out.println("That column is full.");
                }
            }while (result == 1);
            board.printBoard();
            if (board.checkWin(column, player)) {
                System.out.println("Player " + player + " won.");
                break;
            } else {
                if (player == 1) {
                    player = 2;
                } else {
                    player = 1;
                }
            }

        }
    }
}
