class Solution {
    final static int[] hr = new int[]{0,1,0,-1};
    final static int[] vr = new int[]{1,0,-1,0};
    public static void dfs(int i,int j,int[][] v,char[][] grid){
        v[i][j]=1;
        for(int k=0;k<4;k++){
            int m = i+hr[k];
            int n = j+vr[k];
            if(m>=0 && n>=0 && m<grid.length && n<grid[0].length){
                if(grid[m][n]=='1' && v[m][n]==0){
                    dfs(m,n,v,grid);
                }
            }
        }
        
    }
    public int numIslands(char[][] grid) {
        int[][]v = new int[grid.length][grid[0].length];
        int N=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1' && v[i][j]==0){
                    dfs(i,j,v,grid);
                    N++;
                }
            }
        }
        return N;
    }
}