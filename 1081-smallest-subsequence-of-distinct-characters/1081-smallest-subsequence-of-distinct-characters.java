import java.util.Stack;

class Solution {
    public String smallestSubsequence(String s) {
        // Track the last occurrence index of each character
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        
        // Track characters currently inside our result stack
        boolean[] seen = new boolean[26];
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            
            // Skip if the character is already in our sub-sequence
            if (seen[curr - 'a']) {
                continue;
            }
            
            // Pop characters that are larger than 'curr' AND appear again later
            while (!stack.isEmpty() && stack.peek() > curr && lastIndex[stack.peek() - 'a'] > i) {
                seen[stack.pop() - 'a'] = false;
            }
            
            stack.push(curr);
            seen[curr - 'a'] = true;
        }
        
        // Build the final string from the stack
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }
        
        return sb.toString();
    }
}
