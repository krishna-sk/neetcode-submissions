class Solution {
    public boolean isValidSudoku(char[][] board) {
        int rows = board.length, columns = board[0].length;
        
        for(int i=0;i<board.length;i++){
            if(!isValidRow(board,i)){
                return false;
            }
        }

        for(int i=0;i<board[0].length;i++){
            if(!isValidColumn(board,i)){
                return false;
            }
        }

        for(int i=0;i<9;i+=3){
            for(int j=0;j<9;j+=3){
                if(!isValidGrid(board,i,j)){
                    return false;
                }
            }
        }

        /**
               0 1 2    3 4 5  6  7  8 
            0  00       03     06 
            1
            2
            3  30       33     36
            4
            5
            6  60       63     66
            7
            8
            9

         */
        return true;
    }

    public boolean isValidRow(char[][] board, int row) {
        int columns = board[row].length;
        boolean[] isSeen = new boolean[10];
        for (int i = 0; i < columns; i++) {
            if (board[row][i] != '.') {
                int element = board[row][i] - '0';
                if (isSeen[element]) {
                    return false;
                }
                isSeen[element] = true;
            }
        }

        return true;
    }

    public boolean isValidColumn(char[][] board, int column) {
        int rows = board[0].length;
        boolean[] isSeen = new boolean[10];
        for (int i = 0; i < rows; i++) {
            if (board[i][column] != '.') {
                int element = board[i][column] - '0';
                if (isSeen[element]) {
                    return false;
                }
                isSeen[element] = true;
            }
        }

        return true;
    }

    public boolean isValidGrid(char[][] board, int row, int column) {
        int rows = board[0].length;
        boolean[] isSeen = new boolean[10];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i + row][j + column] != '.') {
                    int element = board[i + row][j + column] - '0';
                    if (isSeen[element]) {
                        return false;
                    }
                    isSeen[element] = true;
                }
            }
        }

        return true;
    }
}