class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int[] ones = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                ones[count++] = i;
            }
        }
        if (count < k) {
            return "";
        }

        int bestStart = -1;
        int bestLen = Integer.MAX_VALUE;

        for (int i = 0; i + k - 1 < count; i++) {
            int start = ones[i];
            int end = ones[i + k - 1];
            int len = end - start + 1;

            if (len < bestLen) {
                bestLen = len;
                bestStart = start;
            } else if (len == bestLen) {
                if (isSmaller(s, start, bestStart, bestLen)) {
                    bestStart = start;
                }
            }
        }

        return s.substring(bestStart, bestStart + bestLen);
    }

    private boolean isSmaller(String s, int start1, int start2, int len) {
        for (int i = 0; i < len; i++) {
            char c1 = s.charAt(start1 + i);
            char c2 = s.charAt(start2 + i);

            if (c1 != c2) {
                return c1 < c2;
            }
        }
        return false;
    }
}