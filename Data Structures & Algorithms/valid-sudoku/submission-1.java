class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        Set[] rowSets = new Set[9];
        Set[] columnSets = new Set[9];
        Set[] gridSets = new Set[9];
        for(int i = 0; i < 9; i++) {
            rowSets[i] = new HashSet(9);
            columnSets[i] = new HashSet(9);
            gridSets[i] = new HashSet(9);
        }
        for(int i = 0 ; i < 9 ; i ++ ) {
            for(int j = 0; j < 9 ; j ++) {
                char ch = board[i][j];
                if(ch == '.') {
                    continue;
                }
                if(!rowSets[i].add(ch)) {
                    return false;
                }
                if(!columnSets[j].add(ch)) {
                    return false;
                }
                if(!(gridSets[(i/3)*3 + j/3]).add(ch)) {
                    return false;
                }
            }
        }

        return true;
    }
}




 