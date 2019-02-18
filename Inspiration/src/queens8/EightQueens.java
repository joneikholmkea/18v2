package queens8;

public class EightQueens {
    public static void main(String[] args) {
        int nQueens = 8;

        //Initialize array
        int[] board = new int[nQueens];
        for (int i = 0; i < board.length; i++) {
            board[i] = -1;
        }

        //Place the first queen to get started
        int currentRow = 0;
        board[currentRow] = 0; // set the first queen on column 0, row 0
        currentRow++;
        int currentColumn = 0;  //initialize currentColumn to 0
        while (currentRow >= 0) {
            if (isValid(currentRow, currentColumn, board)) { // also checks if currentColumn < board.length
                board[currentRow] = currentColumn;
                currentRow++;
                currentColumn = 0;

                //Board completed?
                if (currentRow >= board.length) {
                    printBoard(board);
                    return;
                }
            }
            else {
                //If board is not valid
                currentColumn++; // increase queen column by 1, to see if that works
                if (currentColumn >= board.length) { // we've reached the end of the board, column wise
                    board[currentRow] = -1; // remove the queen on the current row, since
                    currentRow--;
                    if (currentRow >= 0)
                        currentColumn = board[currentRow] + 1;
                    // now we search for at better column for the queen on the previous row
                }
            }
        }
    }

    public static boolean isValid(int currentRow, int currentColumn, int[] board) {
        if (currentColumn >= board.length)
            return false;

        for (int i = 0; i < currentRow; i++) {
            //Check if currentColumn appears in any other currentRow
            if (board[i] == currentColumn)
                return false;

            //Check both diagonals
            if (Math.abs(currentRow - i) == Math.abs(currentColumn - board[i])) 
                return false;
        }

        return true;
    }

    public static void printBoard(int[] board) {
        // PrintBoard functionality here
        for(int i=0; i<board.length;i++){
            for (int j=0; j<board.length;j++){ //count columns
                if (board[i]==j)
                  System.out.print("|Q");
                else
                  System.out.print("| ");
            }
            System.out.println(" |");
        }
    }
}
