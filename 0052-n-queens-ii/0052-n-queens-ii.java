class Solution {

    public int totalNQueens(int n) {
        return dfs(n, 0, new boolean[n], new boolean[2 * n - 1], new boolean[2 * n - 1]);
    }

    public int dfs(int n, int i, boolean[] col, boolean[] d1, boolean[] d2) {

        if (i == n) {
            return 1;
        }

        int r = 0;

        for (int j = 0; j < n; j++) {

            if (col[j] || d1[i + j] || d2[n - 1 + i - j]) {
                continue;
            }

            col[j] = d1[i + j] = d2[n - 1 + i - j] = true;

            r += dfs(n, i + 1, col, d1, d2);

            col[j] = d1[i + j] = d2[n - 1 + i - j] = false;
        }

        return r;
    }
}