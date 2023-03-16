class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char ch = board[i][j];
                if(ch!='.'){
                    if(!set.add(ch+"r"+i) || !set.add(ch+"c"+j) || !set.add(ch+"b"+i/3+"-"+j/3)) return false;
                }
            }
        }
        return true;
    }
}