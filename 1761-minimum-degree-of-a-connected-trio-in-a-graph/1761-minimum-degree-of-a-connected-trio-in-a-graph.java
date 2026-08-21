class Solution {
    public int minTrioDegree(int n, int[][] edges) {
        boolean[][] connected = new boolean[n][n];
        int[] degree = new int[n];
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0] - 1;
            int v = edges[i][1] - 1;
            connected[u][v]=true;
            connected[v][u]=true;
            degree[u]++;
            degree[v]++;
        }

        List<int[]> trio = new ArrayList<>();
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if (degree[i] < 2) continue; 
            for(int j=i+1;j<n;j++){
                if(connected[i][j]){
                    for(int k=j+1;k<n;k++){
                        if(connected[j][k] && connected[k][i]){
                            int crr = degree[i] + degree[j] + degree[k] - 6;
                            min=min<crr?min:crr;
                        }
                    }
                }
            }
        }
        
        return min==Integer.MAX_VALUE?-1:min;
    }
}