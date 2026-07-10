class Solution {
    public int findCircleNum(int[][] ic) {
        int count = 0,l = ic.length;
        Boolean[] v = new Boolean[l];
        Deque<Integer> q = new ArrayDeque<Integer>();
        Arrays.fill(v, false);
        for (int f = 0; f < l; f++) {
            if (v[f]==false) {
                q.add(f);
                v[f] = true;
                count++;
                while (!q.isEmpty()) {
                    int node = q.poll();
                    for (int i = 0; i < ic[node].length; i++) {
                        if (ic[node][i] == 1 && v[i] == false) {
                            v[i] = true;
                            q.add(i);
                        }
                    }
                }
            }
        }
        return count;
    }
}