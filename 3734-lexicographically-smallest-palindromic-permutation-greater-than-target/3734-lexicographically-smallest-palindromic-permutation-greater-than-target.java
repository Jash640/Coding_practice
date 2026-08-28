class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();

        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }

        int odd = 0;
        char mid = 0;

        for (int i = 0; i < 26; i++) {
            if ((cnt[i] & 1) != 0) {
                odd++;
                mid = (char) ('a' + i);
            }
        }

        if (odd > 1) {
            return "";
        }

        int m = n / 2;
        int[] half = new int[26];

        for (int i = 0; i < 26; i++) {
            half[i] = cnt[i] / 2;
        }

        int[] rem = half.clone();
        int k = 0;

        while (k < m) {
            int c = target.charAt(k) - 'a';

            if (rem[c] == 0) {
                break;
            }

            rem[c]--;
            k++;
        }

        if (k == m) {
            String h = target.substring(0, m);
            String ans = build(h, mid);

            if (ans.compareTo(target) > 0) {
                return ans;
            }
        }

        int start = k;

        if (k == m) {
            start = m - 1;
            rem = half.clone();

            for (int i = 0; i < m; i++) {
                rem[target.charAt(i) - 'a']--;
            }
        }

        for (int pos = start; pos >= 0; pos--) {
            if (pos < k) {
                rem[target.charAt(pos) - 'a']++;
            }

            int t = target.charAt(pos) - 'a';

            for (int c = t + 1; c < 26; c++) {
                if (rem[c] == 0) {
                    continue;
                }

                StringBuilder h = new StringBuilder(m);

                for (int i = 0; i < pos; i++) {
                    h.append(target.charAt(i));
                }

                h.append((char) ('a' + c));
                rem[c]--;

                for (int x = 0; x < 26; x++) {
                    while (rem[x] > 0) {
                        h.append((char) ('a' + x));
                        rem[x]--;
                    }
                }

                return build(h.toString(), mid);
            }
        }

        return "";
    }

    private String build(String half, char mid) {
        StringBuilder ans = new StringBuilder();

        ans.append(half);

        if (mid != 0) {
            ans.append(mid);
        }

        ans.append(new StringBuilder(half).reverse());

        return ans.toString();
    }
}