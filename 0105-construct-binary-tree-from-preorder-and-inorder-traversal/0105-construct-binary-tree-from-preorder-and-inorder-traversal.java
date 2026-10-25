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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0)return null;
        if(preorder.length==1)return new TreeNode(preorder[0]);
        TreeNode sol = new TreeNode(preorder[0]);
        int i=0;
        while(inorder[i]!=preorder[0])i++;
        int[] lin = Arrays.copyOfRange(inorder,0,i);
        int[] rin = Arrays.copyOfRange(inorder,i+1,inorder.length);
        int[] lpre = Arrays.copyOfRange(preorder,1,i+1);
        int[] rpre = Arrays.copyOfRange(preorder,i+1,preorder.length);
        sol.left = buildTree(lpre, lin);
        sol.right = buildTree(rpre, rin);
        return sol;
    }
}