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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode itr = root;
        if(root==null)return new TreeNode(val,null,null);
        while((itr.val>val && itr.left!=null) || (itr.val<val && itr.right!=null)){
            if(itr.val>val){
                itr=itr.left;
            }else{
                itr=itr.right;
            }
        }
        if(itr.val>val){
            itr.left=new TreeNode(val,null,null);
        }else{
            itr.right=new TreeNode(val,null,null);
        }
        return root;
    }
}