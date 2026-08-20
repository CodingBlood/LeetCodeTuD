class Solution {
    class DisjointSet{
        List<Integer> parent = new ArrayList<>();
        List<Integer> size = new ArrayList<>();
        DisjointSet(int n){
            for(int i=0;i<n;i++){
                parent.add(i);
                size.add(0);
            }
        }
        public int UP(int node){
            if(node==parent.get(node))return node;
            int up = UP(parent.get(node));
            parent.set(node, up);
            return up;
        }
        public void uBS(int u,int v){
            int upu = UP(u);
            int upv = UP(v);
            if(upu==upv)return;
            if(size.get(upu)<size.get(upv)){
                parent.set(upu,upv);
                size.set(upv,size.get(upu)+size.get(upv));
            }else{
                parent.set(upv,upu);
                size.set(upu,size.get(upu)+size.get(upv));
            }
        }
    }
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1)return -1;
        DisjointSet DSU = new DisjointSet(n);
        for(int i=0;i<connections.length;i++){
            DSU.uBS(connections[i][0],connections[i][1]);
        }
        for(int i:DSU.parent){
            System.out.println(i);
        }
        int cnt=0;
        for(int i=0;i<n;i++){
            if(i==DSU.UP(i))cnt++;
        } 
        
        return cnt-1;
    }
}