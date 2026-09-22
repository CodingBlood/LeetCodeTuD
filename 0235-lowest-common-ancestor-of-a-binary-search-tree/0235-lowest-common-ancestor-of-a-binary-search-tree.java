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
    public boolean find(TreeNode root, TreeNode x){
        if(root==x)return true;
        if(root==null)return false;
        return find(root.left,x) || find(root.right,x);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)return null;
        TreeNode l = lowestCommonAncestor(root.left,p,q);
        TreeNode r = lowestCommonAncestor(root.right,p,q);
        if(l!=null){
            return l;
        }else if(r!=null){
            return r;
        }else{
            if(find(root,p) && find(root,q)){
                return root;
            }else{
                return null;
            }
        }
   
        
    }
}