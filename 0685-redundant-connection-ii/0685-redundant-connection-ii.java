class Solution {
    class DSU{
        List<Integer> parent = new ArrayList<Integer>();
        DSU(int n){
            for(int i=0;i<n;i++){
                parent.add(i);
            }
        }
        public int UP(int node){
            if(node==parent.get(node))return node;
            int ultimate_parent = UP(parent.get(node));
            parent.set(node,ultimate_parent);
            return ultimate_parent;
        }
        public Boolean union(int u, int v){
            int uup=UP(u);
            int vup=UP(v);
            if(uup==vup)return true;
            parent.set(vup,uup);
            return false;
        }
    }
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] parentTrack = new int[n + 1];
        int[] edge1 = null;
        int[] edge2 = null;
        DSU dsu = new DSU(n+1);
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (parentTrack[v] != 0) {
                edge1 = new int[]{parentTrack[v], v};
                edge2 = new int[]{u, v};
                break;
            }
            parentTrack[v] = u;
        }
        for (int[] edge : edges) {
            if (edge2 != null && edge[0] == edge2[0] && edge[1] == edge2[1]) {
                continue;
            }
            
            if (dsu.union(edge[0], edge[1])) {
                if (edge1 != null) return edge1;
                return edge;
            }
        }

        return edge2;
    }
}
