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
        TreeNode node;
        long index;

        Pair(TreeNode node, long index) {
            this.node = node;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {

        if (root == null) {
            return 0;
        }

        Queue<Pair> queue = new LinkedList<>();

        // Root gets index 1
        queue.offer(new Pair(root, 1));

        long maxWidth = 0;

        while (!queue.isEmpty()) {

            // Number of nodes in the current level
            int levelSize = queue.size();

            long firstIndex = 0;
            long lastIndex = 0;

            // Process the current level
            for (int i = 0; i < levelSize; i++) {

                Pair current = queue.poll();

                TreeNode node = current.node;
                long index = current.index;

                // First node of this level
                if (i == 0) {
                    firstIndex = index;
                }

                // Last node of this level
                if (i == levelSize - 1) {
                    lastIndex = index;
                }

                // Left child
                if (node.left != null) {
                    queue.offer(new Pair(node.left, 2 * index));
                }

                // Right child
                if (node.right != null) {
                    queue.offer(new Pair(node.right, 2 * index + 1));
                }
            }

            // Width of the current level
            long width = lastIndex - firstIndex + 1;

            // Update maximum width
            maxWidth = Math.max(maxWidth, width);
        }

        return (int) maxWidth;
    }
}