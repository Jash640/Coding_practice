class Solution {
    public boolean exist(char[][] board, String word) {
        int r=board.length;
        int c=board[0].length;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(dfs(board,word,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][]board,String word,int i,int j,int idx){
        if(i<0||j<0||i>=board.length||j>=board[0].length||board[i][j]!=word.charAt(idx))return false;
        if(idx==word.length()-1)return true;
        char t=board[i][j];
        board[i][j]='#';
        boolean b=dfs(board,word,i-1,j,idx+1)||dfs(board,word,i,j-1,idx+1)||dfs(board,word,i,j+1,idx+1)||dfs(board,word,i+1,j,idx+1);
        board[i][j]=t;
        return b;
    }
}