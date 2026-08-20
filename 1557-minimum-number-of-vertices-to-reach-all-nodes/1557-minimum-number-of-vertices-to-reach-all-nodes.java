class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] indeg = new int[n];
        Arrays.fill(indeg,0);
        for(int i=0;i<edges.size();i++){
            indeg[edges.get(i).get(1)]+=1;
        }
        List<Integer> sol = new ArrayList<Integer>();
        for(int i=0;i<n;i++){
            if(indeg[i]==0)sol.add(i);
        }
        return sol;
    }
}