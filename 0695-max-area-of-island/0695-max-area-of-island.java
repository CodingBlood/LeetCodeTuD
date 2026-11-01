class Solution {
    public int dfs(int[][] grid,int[][] vis,int i,int j){
        vis[i][j]=1;
        int[] h = new int[]{-1,0,1,0};
        int[] v = new int[]{0,1,0,-1};
        int m=1;
        for(int d=0;d<4;d++){
            int ch = i+h[d];
            int cv = j+v[d];
            if(ch>=0 && cv>=0 && ch<grid.length && cv<grid[0].length){
                if(grid[ch][cv]==1 && vis[ch][cv]==0){
                    m+=dfs(grid,vis,ch,cv);
                }
            }
        }
        return m;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int[][] v = new int[grid.length][grid[0].length];
        int max=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1 && v[i][j]==0){
                    max=Math.max(max,dfs(grid,v,i,j));
                }
            }
        }
        return max;
    }
}