class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] grids = new int[9];

        for(int row = 0; row < 9 ; row ++) {
            for(int col = 0; col < 9; col++ ) {
                char ch = board[row][col];
                if(ch =='.') {
                    continue;
                }   
                int digit = ch - '1';
                int mask = 1 << digit;
                int grid = (row/3)*3 + (col/3);

                if( (rows[row] & mask) != 0 || (cols[col] & mask) !=0 || (grids[grid] & mask) != 0) {
                    return false;
                }
                rows[row] |= mask;
                cols[col] |= mask;
                grids[grid] |= mask;
            }
        }

        return true;
    }
}
