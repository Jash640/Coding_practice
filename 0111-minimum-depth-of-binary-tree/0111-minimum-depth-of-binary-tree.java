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
    int min=Integer.MAX_VALUE;
    int count=0;
    public int minDepth(TreeNode root) {
        inorder(root,1);
        if(min==Integer.MAX_VALUE)return 0;
        else return min;
    }
    public void inorder(TreeNode root, int count){
        if(root==null)return ;
        if(root.left==null && root.right==null){
            if(count<min)min=count;
            return;
        }
        inorder(root.left,count+1);
        inorder(root.right,count+1);
    }
}