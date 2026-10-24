/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode po(TreeNode root, TreeNode p, TreeNode q){
        if(root==null)return null;
        if (root == p || root == q) return root;
        TreeNode l = po(root.left,p,q);
        TreeNode r = po(root.right,p,q);
        if (l != null && r != null) return root;
        return l != null ? l : r;

    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return po(root,p,q);
    }
}