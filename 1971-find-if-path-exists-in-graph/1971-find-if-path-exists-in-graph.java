class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> map = new ArrayList<>();
        int[] v = new int[n];
        Arrays.fill(v,0);
        for(int i=0;i<n;i++){
            map.add(new ArrayList<Integer>());
        }
        for(int i=0;i<edges.length;i++){
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }
        Deque<Integer> q =  new ArrayDeque<>();
        q.add(source);
        v[source]=1;
        while(!q.isEmpty()){
            int t=q.poll();
            if(t==destination)return true;
            for(int i=0;i<map.get(t).size();i++){
                int node = map.get(t).get(i);
                if(v[node]!=1){
                    v[node]=1;
                    q.add(node);
                }
            }
        }
        return false;
    }
}