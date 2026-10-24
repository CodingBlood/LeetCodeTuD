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
    class Pair {
        TreeNode n;
        int l;

        Pair(TreeNode n, int l) {
            this.n = n;
            this.l = l;
        }
    }

    public List<Integer> levelOrder(TreeNode root) {
        // Queue
        Deque<Pair> Q = new ArrayDeque<Pair>();
        //Solution Array
        List<Integer> lvl = new ArrayList<>();
        if(root==null)return lvl;

        //BFS
        Q.add(new Pair(root, 1));
        while (!Q.isEmpty()) {
            Pair t = Q.poll();
            TreeNode cn = t.n;
            int cl = t.l;

            if (lvl.size() < cl) {
                lvl.add(cn.val);
            }else{
                lvl.set(cl-1,cn.val);
            }

            if (cn.left != null) {
                Q.add(new Pair(cn.left, cl + 1));
            }
            if (cn.right != null) {
                Q.add(new Pair(cn.right, cl + 1));
            }
        }
        return lvl;
    }
    public List<Integer> rightSideView(TreeNode root) {
        return levelOrder(root);
    }   
}