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
    public int size(TreeNode root) {
        if (root == null)
            return 0;
        return size(root.left) + size(root.right) + 1;
    }

    public int kthSmallest(TreeNode root, int k) {
        if (k == 0)
            return root.val;
        int l = size(root.left);
        if (k == l + 1) {
            return root.val;
        } else if (k <= l) {
            return kthSmallest(root.left, k);
        } else {
            return kthSmallest(root.right, k - l - 1);
        }
    }
}