import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution { 
    public List<List<String>> solveNQueens(int n) { 
        List<List<String>> r = new ArrayList<>(); 
        char[][] board = new char[n][n]; 
        for (int i = 0; i < n; i++) { 
            Arrays.fill(board[i], '.'); 
        } 
        dfs(n, 0, new boolean[n], new boolean[2 * n - 1], new boolean[2 * n - 1], board, r); 
        return r; 
    } 

    public void dfs(int n, int i, boolean[] col, boolean[] d1, boolean[] d2, char[][] board, List<List<String>> r) { 
        if (i == n) { 
            r.add(construct(board)); 
            return; 
        } 
        for (int j = 0; j < n; j++) { 
            if (col[j] || d1[i + j] || d2[n - 1 + i - j]) continue; 
            
            board[i][j] = 'Q'; 
            col[j] = d1[i + j] = d2[n - 1 + i - j] = true; 
            
            dfs(n, i + 1, col, d1, d2, board, r); 
            
            board[i][j] = '.'; 
            col[j] = d1[i + j] = d2[n - 1 + i - j] = false; 
        } 
    } 

    public List<String> construct(char[][] board) { 
        List<String> l = new ArrayList<>(); 
        for (int i = 0; i < board.length; i++) { 
            l.add(String.valueOf(board[i])); 
        } 
        return l; 
    } 
}
