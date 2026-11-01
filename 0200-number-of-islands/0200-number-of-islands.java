class Solution {
    class Pair{
        int i,j;
        Pair(int i, int j){
            this.i=i;
            this.j=j;
        }
    }
    public void dfs(char[][] grid,int[][] vis,int i,int j){
        int[] h = new int[]{0,-1,0,1};
        int[] v = new int[]{1,0,-1,0};
        for(int d=0;d<4;d++){
            int ch=i+h[d];
            int vh=j+v[d];
            if(ch>=0 && vh>=0 && ch<grid.length && vh<grid[0].length && grid[ch][vh]=='1' && vis[ch][vh]==0){
                vis[ch][vh]=1;
                dfs(grid,vis,ch,vh);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int[][] vis = new int[grid.length][grid[0].length];
        for(int[] i : vis){
            Arrays.fill(i,0);
        }
        int c=0;
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1' && vis[i][j]==0){
                    vis[i][j]=1;
                    dfs(grid,vis,i,j);
                    c++;
                }
            }
        }
        return c;

    }
}