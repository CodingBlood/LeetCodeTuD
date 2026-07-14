class Solution {
    static final int[] h = new int[]{-1,0,1,0};
    static final int[] vr = new int[]{0,-1,0,1};
    int dfs(int i, int j, int[][] b, int[][] v, int cnt){
        v[i][j]=1;
        for(int k=0;k<4;k++){
            int m=i+h[k];
            int n=j+vr[k];
            if(m>=0 && n>=0 && m<=b.length-1 && n<=b[0].length-1){ 
                if(b[m][n]==1 && v[m][n]==0){
                    cnt=dfs(m,n,b,v,cnt);
                }
            }
        }
        return cnt+1;
    }
    public int numEnclaves(int[][] board) {
        int r = board.length, c = board[0].length,cnt=0,sol=0;
        int[][] v = new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(board[i][j]==1){
                    sol++;
                }
                v[i][j]=0;
            }
        }
        for(int i=0;i<r;i++){
            if(board[i][0]==1 && v[i][0]==0)cnt=dfs(i,0,board,v,cnt);
            if(board[i][c-1]==1 && v[i][c-1]==0)cnt=dfs(i,c-1,board,v,cnt);
        }
        for(int i=1;i<c-1;i++){
            if(board[0][i]==1 && v[0][i]==0)cnt=dfs(0,i,board,v,cnt);
            if(board[r-1][i]==1 && v[r-1][i]==0)cnt=dfs(r-1,i,board,v,cnt);
        }
        return sol-cnt;
    }
}
