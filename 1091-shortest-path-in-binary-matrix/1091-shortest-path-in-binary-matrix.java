class Solution {
    static final int[] H = new int[]{-1,-1,-1,0,1,1,1,0};
    static final int[] V = new int[]{-1,0,1,1,1,0,-1,-1};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int d = grid.length;
        if(grid[0][0]==1 || grid[d-1][d-1]==1)return -1;
        if(d==1 && grid[0][0]==0)return 1;
        Deque<int[]> q = new ArrayDeque<>();
        int[][] vis = new int[d][d];
        for(int i=0;i<d;i++){
            for(int j=0;j<d;j++){
                vis[i][j]=0;
            }  
        }
        q.add(new int[]{0,0,1});
        vis[0][0]=1;
        int sol=Integer.MAX_VALUE,y=0;
        while(!q.isEmpty()){
            int[] t = q.poll();
            for(int i=0;i<8;i++){
                int m=H[i]+t[0];
                int n=V[i]+t[1];
                
                if(m==d-1 && n==d-1){
                    sol=sol<(t[2]+1)?sol:(t[2]+1);
                    y=1;
                }
                if(m>=0 && n>=0 && m<d && n<d) {
                    if(grid[m][n]==0 && vis[m][n]==0){
                        q.add(new int[]{m,n,t[2]+1});
                        vis[m][n]=1;
                    }
                }
            }            
        }
        if(y==0)return -1;
        return sol;
    }
}