class Solution {
    boolean dfs(int i,int[] v,int[][] graph,List<Integer> sol){
        if(v[i]==2)return true;
        if(v[i]==1) return false;
        v[i]=1;
        for(int j=0;j<graph[i].length;j++){
            if(!dfs(graph[i][j],v,graph,sol)){
                return false;
            }
        } 
        v[i]=2;
        sol.add(i);
        return true;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] v = new int[graph.length];
        Arrays.fill(v,0);
        List<Integer>  sol = new ArrayList<>();

        for(int i=0;i<v.length;i++){
            if(dfs(i,v,graph,sol)){
                continue;
            }
        }
        sol.sort(null);
        return sol;
    }
}