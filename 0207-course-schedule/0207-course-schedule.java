class Solution {
    // // DFS
    // public boolean dfs(int i, int[] v, List<List<Integer>> gp){
    //     if(v[i]==2)return true;   // no cycle
    //     if(v[i]==1)return false;  // cycle

    //     v[i]=1;
    //     for(int j=0;j<gp.get(i).size();j++){
    //         if(!dfs(gp.get(i).get(j),v,gp)){
    //             return false;
    //         }
    //     }
    //     v[i]=2;
    //     return true;
    // }
    // public boolean canFinish(int nC, int[][] prerequisites) {
    //     List<List<Integer>> gp = new ArrayList<>();
    //     for(int i=0;i<nC;i++){
    //         gp.add(new ArrayList<Integer>());
    //     }
    //     for(int i=0;i<prerequisites.length;i++){
    //         gp.get(prerequisites[i][0]).add(prerequisites[i][1]);
    //     }
    //     int[] v = new int[nC];
    //     for(int i=0;i<nC;i++){
    //         if(v[i]==0){
    //             if(!dfs(i,v,gp)){
    //                 return false;
    //             }
    //         }
    //     }
    //     return true;
    // }


    // Kahn's Algo
    public boolean canFinish(int nC, int[][] prerequisites) {
        List<List<Integer>> gp = new ArrayList<>();
        int[] deg = new int[nC];
        for(int i=0;i<nC;i++){
            gp.add(new ArrayList<Integer>());
        }
        for(int i=0;i<prerequisites.length;i++){
            gp.get(prerequisites[i][0]).add(prerequisites[i][1]);
            deg[prerequisites[i][1]]++;
        }
        Deque<Integer> s = new ArrayDeque<Integer>();
        for(int i=0;i<nC;i++){
            if(deg[i]==0)s.push(i);
        }
        while(!s.isEmpty()){
            int t=s.pop();
            for(int i=0;i<gp.get(t).size();i++){
                deg[gp.get(t).get(i)]--;
                if(deg[gp.get(t).get(i)]==0){
                    s.push(gp.get(t).get(i));
                }
            }
        }
        for(int i=0;i<nC;i++){
            if(deg[i]!=0)return false;
        }
        return true;
    }
}