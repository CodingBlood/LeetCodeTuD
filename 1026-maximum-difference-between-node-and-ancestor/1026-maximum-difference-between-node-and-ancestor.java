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
    public int dfs(TreeNode root,int min,int max){
        if(root==null)return Math.abs(min-max);
        return Math.max(dfs(root.left,Math.min(min,root.val),Math.max(max,root.val)),
                        dfs(root.right,Math.min(min,root.val),Math.max(max,root.val)));
    }
    public int maxAncestorDiff(TreeNode root) {
        return dfs(root,root.val,root.val);
    }
}