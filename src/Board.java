public class Board {
    private int height;
    private int length;
    private int[][] grid;
    public Board(int height, int length) {
        this.height = height;
        this.length = length;
        this.grid = new int[height][length];
    }

    public int putPiece(int column, int player) {
        for (int row = height - 1; row >= 0; row--) {
            if (grid[row][column] == 0) {
                grid[row][column] = player;
                return 0;
            }
        }
        return 1;
    }

    public void printBoard() {
        for (int row = 0; row < height; row++){
            for (int col = 0; col < length; col++) {
                int cell = grid[row][col];

                if (cell == 0) System.out.print("- ");
                else if (cell == 1) System.out.print("X ");
                else if (cell == 2) System.out.print("O ");
            }
            System.out.println();
        }

        for (int col = 0; col < length; col++) {
            System.out.print(col + " ");
        }
        System.out.println();
    }

    public boolean checkWin(int column, int player) {
        int checkRow = 0;
        int checkCol = 0;
        int count = 0;
        for (int row = 0; row <= height - 1; row++) {
            if (grid[row][column] == player) {
                checkRow = row;
                checkCol = column;
                break;

            }
        }
        for(int col = 0; col <= length - 1; col++) {

            if (grid[checkRow][col] == player) {
                count++;
                if (count == 4) {
                    return true;
                }
            } else {
                count = 0;
            }
        }
        count = 0;
        for(int row = 0; row <= height - 1; row++) {

            if (grid[row][checkCol] == player) {
                count++;
                if (count == 4) {
                    return true;
                }
            } else {
                count = 0;
            }
        }
        count = 0;
        int maxY = grid.length - 1 - checkRow;
        int maxX = grid[0].length - 1 - checkCol;
        int maxLast;
        if (maxX < maxY) maxLast = maxX;
        else maxLast = maxY;
        for (int i = 1; i <= maxLast; i++) {
            if (grid[checkRow + i][checkCol + i] == player) {
                count++;
            } else {
                break;
            }
        }
        int minY = checkRow;
        int minX = checkCol;
        int minLast;
        if (minX < minY) minLast = minX;
        else minLast = minY;
        for (int i = 1; i <= minLast; i++) {
            if (grid[checkRow - i][checkCol - i] == player) {
                count++;

            } else {
                break;
            }
        }

        if (count + 1 >= 4) {
            return true;
        }
        count = 0;
        int maxY2 = grid.length - 1 - checkRow;
        int maxX2 = checkCol;
        int maxLast2;
        if (maxX2 < maxY2) maxLast2 = maxX2;
        else maxLast2 = maxY2;
        for (int i = 1; i <= maxLast2; i++) {
            if (grid[checkRow + i][checkCol - i] == player) {
                count++;
            } else {
                break;
            }
        }
        int minY2 = checkRow;
        int minX2 = grid[0].length - 1 - checkCol;
        int minLast2;
        if (minX2 < minY2) minLast2 = minX2;
        else minLast2 = minY2;
        for (int i = 1; i <= minLast2; i++) {
            if (grid[checkRow - i][checkCol + i] == player) {
                count++;

            } else {
                break;
            }
        }

        if (count + 1 >= 4) {
            return true;
        }


        return false;
    }
}
