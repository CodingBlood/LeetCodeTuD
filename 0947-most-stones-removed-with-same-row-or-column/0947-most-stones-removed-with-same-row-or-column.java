class Solution {
    class DSU{
        List<Integer> parent = new ArrayList<Integer>();
        List<Integer> rank = new ArrayList<Integer>();
        DSU(int n){
            for(int i=0;i<n;i++){
                parent.add(i);
                rank.add(1);
            }
        }
        public int UP(int node){
            if(node==parent.get(node))return node;
            int up = UP(parent.get(node));
            parent.set(node,up);
            return up;
        }
        public void UbyRank(int u,int v){
            int uup=UP(u);
            int vup=UP(v);
            if(uup==vup)return;
            if(rank.get(uup)>rank.get(vup)){
                parent.set(vup,uup);
                rank.set(uup,rank.get(uup)+rank.get(vup));
            }else{
                parent.set(uup,vup);
                rank.set(vup,rank.get(uup)+rank.get(vup));
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