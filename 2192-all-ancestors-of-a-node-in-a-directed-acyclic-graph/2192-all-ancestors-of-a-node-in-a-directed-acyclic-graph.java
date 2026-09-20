class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        int[] indeg = new int[n];
        Arrays.fill(indeg,0);
        List<List<Integer>> g = new ArrayList<>();
        List<Set<Integer>> sol = new ArrayList<>();
        List<List<Integer>> sol1 = new ArrayList<>();
        Deque<Integer> q = new ArrayDeque<Integer>();
        for(int i=0;i<n;i++){
            g.add(new ArrayList<Integer>());
            sol.add(new HashSet<Integer>());
        }
        for(int i=0;i<edges.length;i++){
            indeg[edges[i][1]]++;
            g.get(edges[i][0]).add(edges[i][1]);
        }
        for(int i=0;i<n;i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int crr = q.pop();
            for(int i:g.get(crr)){
                indeg[i]--;
                if(indeg[i]<=0){
                    q.add(i);
                }
                sol.get(i).addAll(sol.get(crr));
                
                sol.get(i).add(crr);
            }
        }
        for(int i=0;i<n;i++){
            sol1.add(new ArrayList<Integer>(sol.get(i)));
            Collections.sort(sol1.get(i));
        }
        return sol1;
    }
}