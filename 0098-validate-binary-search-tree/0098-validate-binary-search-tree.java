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
    public void inorder(TreeNode root, List<Integer> sol){
        if(root==null){
            return;
        } 
        inorder(root.left, sol);
        sol.add(root.val);
        inorder(root.right, sol);
        return;
    }
    public boolean isValidBST(TreeNode root) {
        List<Integer> sol = new ArrayList<>();
        inorder(root, sol);
        for(int i=0;i<sol.size()-1;i++){
            if(sol.get(i)>=sol.get(i+1)){
                return false;
            }
        }
        return true;
    }
}