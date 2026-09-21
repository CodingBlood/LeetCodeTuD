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
    public List<Integer> inorder(TreeNode root){
        List<Integer> l = new ArrayList<Integer>();
        if(root==null)return l;
        if(root.left!=null){
            l.addAll(inorder(root.left));
        }
        l.add(root.val);
        if(root.right!=null){
            l.addAll(inorder(root.right));
        }
        
        return l;
    }
    public boolean isValidBST(TreeNode root) {
        List<Integer> v = inorder(root);
        for(int i=0;i<v.size()-1;i++){
            if(v.get(i)>=v.get(i+1))return false;
        }
        return true;
    }
}