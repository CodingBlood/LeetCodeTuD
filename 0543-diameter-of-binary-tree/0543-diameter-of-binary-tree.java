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
    int max= 0;
    public int itr(TreeNode root){
        int l=0,r=0;
        if(root.left!=null){
            l = itr(root.left);
        }
        if(root.right!=null){
            r = itr(root.right);
        }
                
        max = max>l+r?max:l+r;
        return l>=r?l+1:r+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        int d= itr(root);
        return max;
    }
}