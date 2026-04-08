class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] isSeenInRow = new boolean[10][10];
        boolean[][] isSeenInCol = new boolean[10][10];
        boolean[][] isSeenInBox = new boolean[10][10];
        
        for(int row=0;row<9;row++){
            for(int col = 0;col<9;col++){
                if(board[row][col] == '.'){
                    continue;
                }
                  
                int number = board[row][col] - '0';
                int boxIndex = (row/3) * 3 + col/3;
                if(isSeenInRow[row][number] || isSeenInCol[number][col] || isSeenInBox[boxIndex][number]){
                    return false;
                }

                isSeenInRow[row][number] = true;
                isSeenInCol[number][col] = true;
                isSeenInBox[boxIndex][number] = true;
            }
        }

        return true;
    }
}