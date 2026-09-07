class Solution {
    class DSU{
        List<Integer> parent = new ArrayList<Integer>();
        List<Integer> size = new ArrayList<Integer>();
        DSU(int n){
            for(int i=0;i<n;i++){
                parent.add(i);
                size.add(1);
            }
        }
        public int UP(int node){
            if(node==parent.get(node))return node;
            int ultimate_parent = UP(parent.get(node));
            parent.set(node,ultimate_parent) ;
            return ultimate_parent;
        }
        public void union(int u, int v){
            int uup=UP(u);
            int vup=UP(v);
            if(uup==vup)return;
            if(size.get(uup)>=size.get(vup)){
                parent.set(vup,uup);
                size.set(uup,size.get(uup)+size.get(vup));
            }else{
                parent.set(uup,vup);
                size.set(vup,size.get(uup)+size.get(vup));
            }
        }
    }
    public int largestIsland(int[][] grid) {
        int n=grid.length;
        DSU dsu = new DSU(n*n);
        int[] di=new int[]{-1,0,1,0};
        int[] dj=new int[]{0,1,0,-1};
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if (grid[i][j] == 1) {
                    for(int k=0;k<4;k++){
                        int ni=i+di[k];
                        int nj=j+dj[k];
                        if(ni<n && ni>=0 && nj<n && nj>=0 && grid[ni][nj]==1){
                            dsu.union(i*n+j,ni*n+nj);
                        }
                    }
                }
            }
        }
        int max=0;
        boolean hasZero = false;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if (grid[i][j] == 0) {
                    Set<Integer> uniqueIslands = new HashSet<>();
                    hasZero=true;
                    for(int k=0;k<4;k++){
                        int ni=i+di[k];
                        int nj=j+dj[k];
                        if(ni<n && ni>=0 && nj<n && nj>=0 && grid[ni][nj]==1){
                           uniqueIslands.add(dsu.UP(ni*n+nj));
                        }
                    }
                    int currentTotal = 1; 
                    for (int root : uniqueIslands) {
                        currentTotal += dsu.size.get(root);
                    }
                    
                    if(currentTotal > max){
                        max = currentTotal;
                    }
                }
            }
        }
        return hasZero ? max : n*n;
    }
}