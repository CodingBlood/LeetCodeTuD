class Solution {
    public void dfs(int[][] iC,int i,int[] v){
        v[i]=1;
        for(int j=0;j<iC[i].length;j++){
            if(iC[i][j]==1 && v[j]!=1){
                dfs(iC,j,v);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n=0;
        int[] v = new int[isConnected.length];
        Arrays.fill(v,0);
        for(int i=0;i<isConnected.length;i++){
            if(v[i]!=1){
                dfs(isConnected,i,v);
                n++;
            }
        }
        return n;
    }
}