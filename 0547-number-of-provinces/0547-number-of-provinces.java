class Solution {
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        Boolean[] visited = new Boolean[isConnected.length];
        Deque<Integer> q = new ArrayDeque<Integer>();
        Arrays.fill(visited, false);
        for (int f = 0; f < isConnected.length; f++) {
            if (visited[f]==false) {
                q.add(f);
                visited[f] = true;
                count++;
                while (!q.isEmpty()) {
                    int node = q.poll();
                    for (int i = 0; i < isConnected[node].length; i++) {
                        if (isConnected[node][i] == 1 && visited[i] == false) {
                            visited[i] = true;
                            q.add(i);
                        }
                    }
                }
            }
        }
        return count;
    }
}