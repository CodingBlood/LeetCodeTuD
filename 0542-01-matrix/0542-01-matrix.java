
class Solution {
    static class P {
        int i;
        int j;
        int k;

        P(int i, int j, int k) {
            this.i = i;
            this.j = j;
            this.k = k;
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        int[][] sol = new int[mat.length][mat[0].length];
        int[][] v = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                sol[i][j] = Integer.MAX_VALUE;
            }
        }
        Deque<P> q = new ArrayDeque<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    q.add(new P(i, j, 0));
                    v[i][j] = 1;
                    sol[i][j] = 0;
                }
            }
        }

        while (!q.isEmpty()) {
            P p = q.poll();
            int[] h = new int[] { -1, 0, 1, 0 };
            int[] vr = new int[] { 0, -1, 0, 1 };
            for (int y = 0; y < 4; y++) {
                int m = p.i + h[y];
                int n = p.j + vr[y];
                if (m >= 0 && n >= 0 && m < mat.length && n < mat[0].length) {
                    if (v[m][n] != 1) {
                        v[m][n] = 1;
                        sol[m][n] = p.k + 1;
                        q.add(new P(m, n, p.k + 1));
                    }
                }
            }

        }

        return sol;
    }
}