class Solution {
    void dfs(int node, Boolean[] v, int[][] isConnected){
        v[node]=true;
        for(int i=0;i<isConnected[node].length;i++){
            if(isConnected[node][i]==1){
                if(v[i]==false){
                    dfs(i,v,isConnected);
                }
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        Boolean[] v = new Boolean[isConnected.length];
        Arrays.fill(v,false);
        int c=0;
        for(int i=0;i<isConnected.length;i++){
            if(v[i]==false){
                v[i]=true;
                dfs(i,v,isConnected);
                c++;
            }
        }
        return c;
    }
}