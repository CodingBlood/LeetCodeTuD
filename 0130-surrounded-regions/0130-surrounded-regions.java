class Solution {
    static final int[] h = new int[]{-1,0,1,0};
    static final int[] vr = new int[]{0,-1,0,1};
    void dfs(int i, int j, char[][] b, char[][] bs){
        bs[i][j]='O';
        for(int k=0;k<4;k++){
            int m=i+h[k];
            int n=j+vr[k];
            if(m>=0 && n>=0 && m<=b.length-1 && n<=b[0].length-1){ 
                if(b[m][n]=='O' && bs[m][n]!='O'){
                    dfs(m,n,b,bs);
                    bs[m][n]='O';
                }
            }
        }
    }
    public void solve(char[][] board) {
        int r = board.length, c = board[0].length;
        char[][] bs = new char[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                bs[i][j]='X';
            }
        }
        for(int i=0;i<r;i++){
            if(board[i][0]=='O' && bs[i][0]=='X')dfs(i,0,board,bs);
            if(board[i][c-1]=='O' && bs[i][c-1]=='X')dfs(i,c-1,board,bs);
        }
        for(int i=1;i<c-1;i++){
            if(board[0][i]=='O' && bs[0][i]=='X')dfs(0,i,board,bs);
            if(board[r-1][i]=='O' && bs[r-1][i]=='X')dfs(r-1,i,board,bs);
        }
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                board[i][j]=bs[i][j];
            }
        }
    }
}