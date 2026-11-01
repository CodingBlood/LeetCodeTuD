class Solution {
    class Triplet {
        int i, j, t;

        Triplet(int i, int j, int t) {
            this.i = i;
            this.j = j;
            this.t = t;
        }
    }

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];

        int[] h = new int[] { -1, 0, 1, 0 };
        int[] v = new int[] { 0, 1, 0, -1 };

        Deque<Triplet> Q = new ArrayDeque<Triplet>();
        int max_t = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    Q.add(new Triplet(i, j, 0));
                    vis[i][j] = 1;
                }
            }
        }

        while (!Q.isEmpty()) {
            Triplet t = Q.poll();
            max_t = Math.max(max_t, t.t);
            for (int d = 0; d < 4; d++) {
                int ch = t.i + h[d];
                int vh = t.j + v[d];
                if (ch >= 0 && vh >= 0 && ch < n && vh < m && grid[ch][vh] == 1 && vis[ch][vh] == 0) {
                    Q.add(new Triplet(ch, vh, t.t + 1));
                    vis[ch][vh] = 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return max_t;
    }
}