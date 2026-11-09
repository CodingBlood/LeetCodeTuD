class Solution {
    int[] h= new int[]{-1,0,1,0};
    int[] v= new int[]{0,1,0,-1};
    public int dfs(int[][] grid,int[][] vis,int i,int j){
        if(vis[i][j]==1)return 0;
        int size=1;
        vis[i][j]=1;
        for(int t=0;t<4;t++){
            int ch=i+h[t];
            int cv=j+v[t];
            if(ch>=0 && cv>=0 && ch<grid.length && cv<grid[0].length && grid[ch][cv]==1){
                size+=dfs(grid,vis,ch,cv);
            }
        }
        
        return size;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int max=0;
        int n=grid.length;
        int m=grid[0].length;
        int[][] v= new int[n][m];
        for(int[] i:v){
            Arrays.fill(i,0);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(v[i][j]==0 && grid[i][j]==1){
                    max = Math.max(max,dfs(grid,v,i,j));
                }
            }
        }

        return max;
    }
}