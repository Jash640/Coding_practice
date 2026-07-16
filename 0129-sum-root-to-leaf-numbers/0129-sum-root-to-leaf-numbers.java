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
    int sum=0;
    public int sumNumbers(TreeNode root) {
        inorder(root,root.val);
        return sum;
    }
    public void inorder(TreeNode root,int total){
        if(root==null)return;
        if(root.left==null && root.right==null){
            sum+=total;
            return;
        }
        inorder(root.left,(root.left!=null)? total*10+root.left.val:total);
        inorder(root.right,(root.right!=null)? total*10+root.right.val:total);
    }
}