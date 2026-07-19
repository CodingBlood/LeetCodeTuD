class Solution {
    public boolean canReach(int[] s, int[] t) {
        if (s[0] == t[0] && s[1] == t[1]) return true;
        boolean[][] visited = new boolean[8][8];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{s[0], s[1],0});
        visited[s[0]][s[1]] = true;
        int[][] moves = {
            {2, 1}, {1, 2}, {-1, 2}, {-2, 1},
            {-2, -1}, {-1, -2}, {1, -2}, {2, -1}
        };
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int[] move : moves) {
                int nextX = curr[0] + move[0];
                int nextY = curr[1] + move[1];
                if (nextX == t[0] && nextY == t[1]) {
                    if((curr[2]+1)%2==0)return true;
                    continue;
                }
                if (nextX >= 0 && nextX < 8 && nextY >= 0 && nextY < 8) {
                    if (!visited[nextX][nextY]) {
                        visited[nextX][nextY] = true;
                        queue.add(new int[]{nextX, nextY,curr[2]+1});
                    }
                }
            }
        }
        
        return false;
    }
}
