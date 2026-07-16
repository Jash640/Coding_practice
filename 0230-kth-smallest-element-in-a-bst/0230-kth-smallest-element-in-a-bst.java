/** 
 * Definition for a binary tree node. 
 * public class TreeNode { 
 *     int val; 
 *     TreeNode left; 
 *     TreeNode right; 
 *     TreeNode() {} 
 *     TreeNode(int val) { this.val = val; } 
 *     TreeNode(int val, TreeNode left, TreeNode right) { 
 *         this.val = val; 
 *         this.left = left; 
 *         this.right = right; 
 *     } 
 * } 
 */
class Solution {
    int res = -1;
    int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return res;
    }

    public void inorder(TreeNode node, int k) {
        
        if (node == null || res != -1) return;

        inorder(node.left, k);

        count++;
        if (count == k) {
            res = node.val; 
            return;
        }

        inorder(node.right, k);
    }
}
