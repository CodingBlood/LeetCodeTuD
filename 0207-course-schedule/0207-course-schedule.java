class Solution {
    public boolean dfs(int i,List<List<Integer>> adj,int[] v){
        if(v[i]==1)return false;
        if(v[i]==2)return true;
        v[i]=1; //visiting it
        for(int j=0;j<adj.get(i).size();j++){
            if(!dfs(adj.get(i).get(j),adj,v))return false;
        }
        v[i]=2;
        return true;
    }
    public boolean canFinish(int nC, int[][] pq) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<nC;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int[] i:pq){
            adj.get(i[0]).add(i[1]);
        }
        int[] v = new int[nC];
        for(int i=0;i<v.length;i++){
            if(v[i]==0){
                if(!dfs(i,adj,v))return false;
            }
        }
        return true;
    }
}