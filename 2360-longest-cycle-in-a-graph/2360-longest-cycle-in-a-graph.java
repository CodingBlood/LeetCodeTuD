class Solution {

    int max=-1;
    public void dfs(int i,int[] edges,int[] v,int[] nodeStep, int cc){
        if(i==-1)return;
        if(v[i]==1){
            int cl = cc - nodeStep[i];
            if(cl>max)max=cl;
            return ;
        }
        if(v[i]==2)return;
        v[i]=1; //start exploring
        nodeStep[i] = cc;
        dfs(edges[i],edges,v,nodeStep,cc+1);
        v[i]=2;
        return;
    }
    public int longestCycle(int[] edges) {
        int[] v = new int[edges.length];
        int[] nodeStep = new int[edges.length];
        Arrays.fill(v,0);
        for(int i=0;i<edges.length;i++){
            if(v[i]==0){
                dfs(i,edges,v, nodeStep, 1);
            }
        }
        return max;
    }
}