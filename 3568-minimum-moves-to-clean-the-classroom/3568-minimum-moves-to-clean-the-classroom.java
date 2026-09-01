class Solution {
    static class State {
        int r, c, mask, energy, moves;

        State(int r, int c, int mask, int energy, int moves) {
            this.r = r;
            this.c = c;
            this.mask = mask;
            this.energy = energy;
            this.moves = moves;
        }
    }

    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();

        int sr = 0, sc = 0, k = 0;
        int[][] id = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                id[i][j] = -1;
                char ch = classroom[i].charAt(j);

                if (ch == 'S') {
                    sr = i;
                    sc = j;
                } else if (ch == 'L') {
                    id[i][j] = k++;
                }
            }
        }

        if (k == 0) return 0;

        int target = (1 << k) - 1;

        boolean[][][][] visited =
            new boolean[m][n][1 << k][energy + 1];

        java.util.Queue<State> q = new java.util.ArrayDeque<>();
        q.offer(new State(sr, sc, 0, energy, 0));
        visited[sr][sc][0][energy] = true;

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        while (!q.isEmpty()) {
            State cur = q.poll();

            if (cur.mask == target) {
                return cur.moves;
            }

            int e = cur.energy;

            if (e == 0) {
                if (classroom[cur.r].charAt(cur.c) == 'R') {
                    e = energy;
                } else {
                    continue;
                }
            }

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                    continue;
                }

                if (classroom[nr].charAt(nc) == 'X') {
                    continue;
                }

                int ne = e - 1;
                int mask = cur.mask;
                char cell = classroom[nr].charAt(nc);

                if (cell == 'L') {
                    mask |= 1 << id[nr][nc];
                }

                if (cell == 'R') {
                    ne = energy;
                }

                if (!visited[nr][nc][mask][ne]) {
                    visited[nr][nc][mask][ne] = true;
                    q.offer(new State(nr, nc, mask, ne, cur.moves + 1));
                }
            }
        }

        return -1;
    }
}