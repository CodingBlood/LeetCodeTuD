class Solution {
    public boolean isBipartite(int[][] graph) {
        Deque<Integer> q = new ArrayDeque<Integer>();
        int[] v = new int[graph.length];
        Arrays.fill(v,-1);
        for(int i=0;i<graph.length;i++){
            if(v[i]==-1){
                // color before adding
                v[i] = 0;
                q.add(i);
                while(!q.isEmpty()){
                    int t = q.poll();
                    int dc = 1 - v[t];
                    for(int j=0;j<graph[t].length;j++){
                        if(v[graph[t][j]]==-1){
                            v[graph[t][j]]=dc;
                            q.add(graph[t][j]);
                        }else{
                            if(v[graph[t][j]]!=dc){
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}