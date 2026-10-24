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
    int max=0;
    public int itr(TreeNode root){
        int l=0,r=0;
        if(root.left!=null){
            l = itr(root.left);
        }
        if(root.right!=null){
            r = itr(root.right);
        }
       
        
        int currentMaxPath = Math.max(root.val, root.val + Math.max(l, r));
        max = Math.max(max, Math.max(currentMaxPath, root.val + l + r));
        
        return currentMaxPath;
    }
    public int maxPathSum(TreeNode root) {
        max=root.val;
        int d  = itr(root);
        return max;
    }
}