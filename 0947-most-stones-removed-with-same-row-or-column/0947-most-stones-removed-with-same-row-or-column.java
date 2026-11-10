class Solution {
    class DSU{
        List<Integer> parent = new ArrayList<>();
        List<Integer> size = new ArrayList<>();
        DSU(int n){
            for(int i=0;i<n;i++){
                parent.add(i);
                size.add(1);
            }
        }
        public int UP(int node){
            if(parent.get(node)==node)return node;
            int up = UP(parent.get(node));
            parent.set(node,up);
            return up;
        }
        public void UbyRank(int u, int v){
            int upu=UP(u);
            int upv=UP(v);
            if(upu==upv)return;
            if(size.get(upu)>size.get(upv)){
                parent.set(upv,upu);
                size.set(upu,size.get(upu)+size.get(upv));
            }else{
                parent.set(upu,upv);
                size.set(upv,size.get(upu)+size.get(upv));
            }
        }
    }
    public int removeStones(int[][] stones) {
        int n=stones.length;
        DSU dsu = new DSU(n);
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(stones[i][0]==stones[j][0] || stones[i][1]==stones[j][1]){
                    dsu.UbyRank(i,j);
                }
            }   
        }
        int cnt=0;
        for(int i=0;i<n;i++){
            if(i==dsu.UP(i))cnt++;
        }
        return n-cnt;
    }
}