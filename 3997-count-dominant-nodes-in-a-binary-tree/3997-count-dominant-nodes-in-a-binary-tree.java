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
    static int c=0;
    void pre(TreeNode root, Deque<Integer> s){
        while(!s.isEmpty() && s.peek()<root.val)s.pop();
        s.push(root.val);
        if(root.left==null && root.right==null){
            c++;
            s.pop();
            return;
        }
        if(root.left!=null){
            pre(root.left,s);
        }
        if(root.right!=null){
            pre(root.right,s);
        }
        if(!s.isEmpty() && s.peek()==root.val){
            c++;
            s.pop();
        }
        
    }
    public int countDominantNodes(TreeNode root) {
        Deque<Integer> s = new ArrayDeque<Integer>();
        c=0;
        pre(root,s);
        return c;
    }
}