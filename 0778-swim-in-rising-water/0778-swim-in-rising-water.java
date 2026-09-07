class Solution {
    class DSU{
        List<Integer> parent = new ArrayList<Integer>();
        List<Integer> size = new ArrayList<Integer>();
        DSU(int n){
            for(int i=0;i<n*n;i++){
                parent.add(i);
                size.add(1);
            }
        }
        public int UP(int node){
            if(node==parent.get(node))return node;
            int ultimate_parent = UP(parent.get(node));
            parent.set(node,ultimate_parent);
            return ultimate_parent;
        }
        public void union(int u,int v){
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
    public int swimInWater(int[][] grid) {
        /// we will create a while loop t...from 0 to infity
        // we will keep on merging elements of grid... for each t
        // we will do this untill the UP({0,0})==UP({n-1,n-1})
        // return t
        int n=grid.length;
        int low = Math.max(grid[0][0], grid[n - 1][n - 1]);
        int high = n * n - 1;
        int ans=high;
        int[] di = new int[]{-1,0,1,0};
        int[] dj = new int[]{0,1,0,-1};
        while (low <= high) {
            int mid = low + (high - low) / 2;
            DSU dsu = new DSU(n);
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(grid[i][j]<=mid){
                        for(int k=0;k<4;k++){
                            int ni = i+di[k];
                            int nj = j+dj[k];
                            if(ni<n && ni>=0 && nj<n && nj>=0 && grid[ni][nj]<=mid){
                                dsu.union(i * n + j, ni * n + nj);
                            }
                        }
                    }
                }       
            }
            if (dsu.UP(0) == dsu.UP(n * n - 1)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1; 
            }
        }
        return ans;
    }
}