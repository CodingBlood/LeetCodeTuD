class Solution {
    static final int[] h = new int[]{-1,0,1,0};
    static final int[] vr = new int[]{0,-1,0,1};
    void dfs(int i, int j, char[][] b, char[][] bs, int[][] v){
        for(int k=0;k<4;k++){
            int m=i+h[k];
            int n=j+vr[k];
            if(m>=0 && n>=0 && m<=b.length-1 && n<=b[0].length-1){ 
                if(b[m][n]=='O' && v[m][n]!=1){
                    v[m][n]=1;
                    dfs(m,n,b,bs,v);
                    bs[m][n]='O';
                }
            }
        }
    }
    public void solve(char[][] board) {
        int r = board.length, c = board[0].length;
        int[][] v = new int[r][c];
        char[][] bs = new char[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                bs[i][j]='X';
            }
        }
        for(int i=0;i<r;i++){
            if(board[i][0]=='O' && v[i][0]==0){
                v[i][0]=1;
                dfs(i,0,board,bs,v);
                bs[i][0]='O';
            }
            if(board[i][c-1]=='O' && v[i][c-1]==0){
                v[i][c-1]=1;
                dfs(i,c-1,board,bs,v);
                bs[i][c-1]='O';
            }
        }
        for(int i=1;i<c-1;i++){
            if(board[0][i]=='O' && v[0][i]==0){
                v[0][i]=1;
                dfs(0,i,board,bs,v);
                bs[0][i]='O';
            }
            if(board[r-1][i]=='O' && v[r-1][i]==0){
                v[r-1][i]=1;
                dfs(r-1,i,board,bs,v);
                bs[r-1][i]='O';
            }
        }
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                board[i][j]=bs[i][j];
            }
        }
    }
}