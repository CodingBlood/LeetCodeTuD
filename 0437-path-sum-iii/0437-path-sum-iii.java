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
    long prefix = 0;
    long ans = 0;

    HashMap<Long, Integer> map = new HashMap<>();

    private void dfs(TreeNode root, int target) {

        if (root == null)
            return;

        prefix += root.val;

        ans += map.getOrDefault(prefix - target, 0);

        map.put(prefix, map.getOrDefault(prefix, 0) + 1);

        dfs(root.left, target);
        dfs(root.right, target);

        map.put(prefix, map.get(prefix) - 1);

        prefix -= root.val;
    }

    public int pathSum(TreeNode root, int targetSum) {

        map.put(0L, 1);

        dfs(root, targetSum);

        return (int) ans;
    }
}