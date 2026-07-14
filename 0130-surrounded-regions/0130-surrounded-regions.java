class Solution {
    // static class P{
    //     int i,j,k;
    //     P(int i,int j, int k){
    //         this.i=i;
    //         this.j=j;
    //         this.k=k;
    //     }
    // }
    void dfs(int i, int j, char[][] b, char[][] bs, int[][] v){
        int[] h = new int[]{-1,0,1,0};
        int[] vr = new int[]{0,-1,0,1};
        for(int k=0;k<4;k++){
            int m=i+h[k];
            int n=j+vr[k];
            if(m>0 && n>0 && m<b.length-1 && n<=b[0].length-1){ //can be anything
                if(b[m][n]=='O' && v[m][n]!=1){
                    v[m][n]=1;
                    dfs(m,n,b,bs,v);
                    bs[m][n]='O';
                }
            }
        }
    }
    public void solve(char[][] board) {
        int[][] v = new int[board.length][board[0].length];
        char[][] bs = new char[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                bs[i][j]='X';
                System.out.print(bs[i][j] + " ");
            }
            System.out.println("");
        }
        // System.out.println(bs);
        // Deque<P> q = new ArrayDeque<>();
        for(int i=0;i<board.length;i++){
            if(board[i][0]=='O' && v[i][0]==0){
                v[i][0]=1;
                dfs(i,0,board,bs,v);
                bs[i][0]='O';
            }
            if(board[i][board[0].length-1]=='O' && v[i][board[0].length-1]==0){
                v[i][board[0].length-1]=1;
                dfs(i,board[0].length-1,board,bs,v);
                bs[i][board[0].length-1]='O';
            }
        }
        for(int i=1;i<board[0].length-1;i++){
            if(board[0][i]=='O' && v[0][i]==0){
                v[0][i]=1;
                dfs(0,i,board,bs,v);
                bs[0][i]='O';
            }
            if(board[board.length-1][i]=='O' && v[board.length-1][i]==0){
                v[board.length-1][i]=1;
                dfs(board.length-1,i,board,bs,v);
                bs[board.length-1][i]='O';
            }
        }
        // for(char[] i:bs){
        //     for(char j:i){
        //         System.out.print(j + " ");
        //     }
        //     System.out.println("");
        // }

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                board[i][j]=bs[i][j];
                System.out.print(bs[i][j] + " ");
            }
            System.out.println("");
        }
    }
}