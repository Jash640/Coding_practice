class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, int[]> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new int[]{i, i});
            } else {
                map.get(nums[i])[1] = i;
            }
        }

        int ans = -1;
        int windows = n - k + 1;

        for (Map.Entry<Integer, int[]> e : map.entrySet()) {
            int first = e.getValue()[0];
            int last = e.getValue()[1];

            int left = Math.max(0, first - k + 1);
            int right = Math.min(last, windows - 1);

            if (right - left + 1 == 1) {
                ans = Math.max(ans, e.getKey());
            }
        }

        return ans;
    }
}