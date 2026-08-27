class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        char[] ans = new char[n];

        int i = 0;
        while (i < n) {
            int x = target.charAt(i) - 'a';

            if (freq[x] == 0) break;

            ans[i] = target.charAt(i);
            freq[x]--;
            i++;
        }

        for (int j = Math.min(i, n - 1); j >= 0; j--) {
            if (j < i) {
                freq[ans[j] - 'a']++;
            }

            int t = target.charAt(j) - 'a';

            for (int c = t + 1; c < 26; c++) {
                if (freq[c] > 0) {
                    ans[j] = (char) ('a' + c);
                    freq[c]--;

                    int k = j + 1;

                    for (int ch = 0; ch < 26; ch++) {
                        while (freq[ch] > 0) {
                            ans[k++] = (char) ('a' + ch);
                            freq[ch]--;
                        }
                    }

                    return new String(ans);
                }
            }
        }

        return "";
    }
}