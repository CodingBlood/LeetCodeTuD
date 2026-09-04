class Solution {
    class DSU{
        List<Integer> parent=new ArrayList<>();; 
        List<Integer> rank=new ArrayList<>();; 
        DSU(int n){
            for(int i=0;i<n;i++){
                parent.add(i);
                rank.add(0);
            }
        }
        public int UP(int node){
            int p = parent.get(node); 
            if(node==p)return node;
            int up = UP(p);
            parent.set(node,up);
            return up;
        }
        public void UbyRank(int u,int v){
            int uup = UP(u);
            int vup = UP(v);
            if(uup==vup)return;
            if(rank.get(uup)>rank.get(vup)){
                parent.set(vup,uup);
                rank.set(vup,rank.get(uup)+rank.get(vup));
            }else{
                parent.set(uup,vup);
                rank.set(uup,rank.get(uup)+rank.get(vup));    
            }
        }
    }
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1)return -1;
        DSU dsu = new DSU(n);
        for(int i=0;i<connections.length;i++){
            dsu.UbyRank(connections[i][0],connections[i][1]);
        }
        for(int i:dsu.parent){
            System.out.print(i + " ");
        }
        System.out.println("i");
        for(int i:dsu.rank){
            System.out.print(i + " ");
        }
        int cnt=0;
        for(int i=0;i<n;i++){
            if(i==dsu.UP(i))cnt++;
        } 
        
        return cnt-1;
    }
}