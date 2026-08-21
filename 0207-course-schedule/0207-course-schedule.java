class Solution {
    // DFS
    public boolean dfs(int i, int[] v, List<List<Integer>> gp){
        if(v[i]==2)return true;   // no cycle
        if(v[i]==1)return false;  // cycle

        v[i]=1;
        for(int j=0;j<gp.get(i).size();j++){
            if(!dfs(gp.get(i).get(j),v,gp)){
                return false;
            }
        }
        v[i]=2;
        return true;
    }
    public boolean canFinish(int nC, int[][] prerequisites) {
        List<List<Integer>> gp = new ArrayList<>();
        for(int i=0;i<nC;i++){
            gp.add(new ArrayList<Integer>());
        }
        for(int i=0;i<prerequisites.length;i++){
            gp.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        int[] v = new int[nC];
        for(int i=0;i<nC;i++){
            if(v[i]==0){
                if(!dfs(i,v,gp)){
                    return false;
                }
            }
        }
        return true;
    }
}