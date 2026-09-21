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
    public TreeNode left(TreeNode itr){
        if(itr.left==null){
            return itr;
        }else{
            return left(itr.left);
        }
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode itr=root;
        if(itr==null)return itr;
        if(itr.val==key){
            if(itr.right==null){
                return itr.left;
            }else{
                TreeNode t = left(itr.right);
                itr.val=t.val;
                itr.right = deleteNode(itr.right, t.val); 
            }
        }else{
            if(key>root.val){
                itr.right = deleteNode(itr.right,key);
            }else{
                itr.left = deleteNode(itr.left,key);
            }
        }
        return root;
    }
}