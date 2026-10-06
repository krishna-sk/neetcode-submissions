class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] isSeenInRow = new boolean[9][10];
        boolean[][] isSeenInCol = new boolean[9][10];
        boolean[][] isSeenInGrid = new boolean[9][10];

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                    continue;
                }

                int element = board[row][col] - '0';
                int grid = (row / 3) * 3 + col / 3;
                if (isSeenInRow[row][element] || isSeenInCol[col][element]
                    || isSeenInGrid[grid][element]) {
                    return false;
                }

                isSeenInRow[row][element] = true;
                isSeenInCol[col][element] = true;
                isSeenInGrid[grid][element] = true;
            }
        }

        return true;
    }
}
