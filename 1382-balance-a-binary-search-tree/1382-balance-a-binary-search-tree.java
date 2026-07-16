class Solution {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        inorder(root, inorder);
        return build(inorder, 0, inorder.size() - 1);
    }

    public void inorder(TreeNode root, List<Integer> inorder) {
        if (root == null) return;

        inorder(root.left, inorder);
        inorder.add(root.val);
        inorder(root.right, inorder);
    }

    public TreeNode build(List<Integer> inorder, int low, int high) {
        if (low > high) return null;

        int mid = low + (high - low) / 2;

        TreeNode root = new TreeNode(inorder.get(mid));

        root.left = build(inorder, low, mid - 1);
        root.right = build(inorder, mid + 1, high);

        return root;
    }
}