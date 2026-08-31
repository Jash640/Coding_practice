class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int first = -1, prev = -1, min = Integer.MAX_VALUE;
        int index = 1;
        ListNode left = head;
        ListNode curr = head.next;
        while (curr != null && curr.next != null) {
            if ((curr.val > left.val && curr.val > curr.next.val) ||
                (curr.val < left.val && curr.val < curr.next.val)) {
                if (prev != -1)
                    min = Math.min(min, index - prev);
                if (first == -1)
                    first = index;   
                prev = index;
            }
            left = curr;
            curr = curr.next;
            index++;
        }
        if (first == -1 || prev == first)
            return new int[]{-1, -1};
        return new int[]{min, prev - first};
    }
}