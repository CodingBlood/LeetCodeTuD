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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> sol = new ArrayList<TreeNode>();
        if(root==null)return sol;
        Set<Integer> s = new HashSet<Integer>();
        for(int i=0;i<to_delete.length;i++){
            s.add(to_delete[i]);
        }
        if(!s.contains(root.val)) {
            sol.add(root);
        }
        Deque<TreeNode> Q = new ArrayDeque<TreeNode>();
        Q.add(root);
        while(!Q.isEmpty()){
            TreeNode t = Q.poll();
            if(s.contains(t.val)){
                List<TreeNode> l = delNodes(t.left,to_delete);
                List<TreeNode> r = delNodes(t.right,to_delete);
                if(!l.isEmpty())sol.addAll(l);
                if(!r.isEmpty())sol.addAll(r);
                t.left=null;
                t.right=null;
                t=null;
            }else{
                if(t.left!=null){
                    Q.add(t.left);
                    if(s.contains(t.left.val)){
                        t.left=null;
                    }
                }
                if(t.right!=null){
                    Q.add(t.right);
                    if(s.contains(t.right.val)){
                        t.right=null;
                    }
                }
            }
        }
        return sol;
    }
}