class Solution {
    boolean dfs(int i,List<List<Integer>> adj,List<Integer> sol,int[] v){
        if(v[i]==2)return true;
        if(v[i]==1)return false;
        v[i]=1;
        for(int j=0;j<adj.get(i).size();j++){
            if(!dfs(adj.get(i).get(j),adj,sol,v)){
                return false;
            }
        }
        v[i]=2;
        sol.add(i);
        return true;
    }
    public int[] findOrder(int nC, int[][] prq) {
        int[] v = new int[nC];
        Arrays.fill(v,0);
        List<List<Integer>> adj = new ArrayList<>();
        List<Integer> sol = new ArrayList<>();
        for(int i=0;i<nC;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0;i<prq.length;i++){
            adj.get(prq[i][1]).add(prq[i][0]);
        }
        for(int i=0;i<nC;i++){
            if(v[i]==0){
                if(!dfs(i,adj,sol,v)){
                    return new int[0];
                }
            }
        }
        int[] s = new int[nC];
        for(int i=0;i<sol.size();i++){
            s[i]=sol.get(sol.size() - 1 - i);
        }
        return s;
    }
}