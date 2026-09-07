class Solution {
    public int distinctSubseqII(String s) {
        long[] last = new long[26];
        long total = 0;
        long mod = 1_000_000_007;
        for (char c : s.toCharArray()) {
            int i = c - 'a';
            long add = (total + 1 - last[i] + mod) % mod;
            total = (total + add) % mod;
            last[i] = (last[i] + add) % mod;
        }
        return (int) total;
    }
}