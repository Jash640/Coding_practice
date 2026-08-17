import java.util.*;

class Solution {
    static final long MOD = 1_000_000_007L;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;

        long[] up = new long[m];
        long[] down = new long[m];

        if (n == 1) {
            return m;
        }

        for (int i = 0; i < m; i++) {
            up[i] = i;
            down[i] = m - 1 - i;
        }

        for (int len = 3; len <= n; len++) {
            long[] newUp = new long[m];
            long[] newDown = new long[m];

            long[] prefixDown = new long[m];
            prefixDown[0] = down[0];

            for (int i = 1; i < m; i++) {
                prefixDown[i] = (prefixDown[i - 1] + down[i]) % MOD;
            }

            long[] suffixUp = new long[m];
            suffixUp[m - 1] = up[m - 1];

            for (int i = m - 2; i >= 0; i--) {
                suffixUp[i] = (suffixUp[i + 1] + up[i]) % MOD;
            }

            for (int i = 0; i < m; i++) {
                if (i > 0) {
                    newUp[i] = prefixDown[i - 1];
                }

                if (i < m - 1) {
                    newDown[i] = suffixUp[i + 1];
                }
            }

            up = newUp;
            down = newDown;
        }

        long ans = 0;

        for (int i = 0; i < m; i++) {
            ans = (ans + up[i] + down[i]) % MOD;
        }

        return (int) ans;
    }
}