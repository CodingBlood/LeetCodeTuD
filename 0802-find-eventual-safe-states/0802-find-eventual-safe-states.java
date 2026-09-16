class Solution {
    public Boolean dfs(int i, int[][] graph, int[] v){
        if(v[i]==2) return true;
        if(v[i]==1) return false; 
        v[i]=1; // started exploring
        for(int j=0;j<graph[i].length;j++){
            int neighbor = graph[i][j];
            if(v[neighbor]==0){
                if(!dfs(neighbor,graph,v)){
                    return false;
                }
            }else if(v[neighbor]==1){
                return false;
            }
        }
        v[i]=2;
        return true;    
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] v = new int[graph.length];
        Arrays.fill(v,0);
        List<Integer> sol = new ArrayList<Integer>();
        for(int i=0;i<graph.length;i++){
            if(v[i]==0){
                if(dfs(i,graph,v));
            }
        }
        for(int i=0;i<v.length;i++){
            if(v[i]==2){
                sol.add(i);
            }
        }
        return sol;
    }
}