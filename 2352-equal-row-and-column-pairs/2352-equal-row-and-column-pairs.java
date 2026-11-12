class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        Map<String, Integer> mp = new HashMap<String, Integer>();
        
        for (int[] j : grid) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < grid.length; i++) {
                sb.append(j[i]).append(",");
            }
            String val = sb.toString();
            mp.put(val, mp.getOrDefault(val, 0) + 1);
        }
        
        int sol = 0;
        for (int j = 0; j < n; j++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < grid.length; i++) {
                sb.append(grid[i][j]).append(",");
            }
            String val = sb.toString();
            sol += mp.getOrDefault(val, 0);
        }
        
        return sol;
    }
}
