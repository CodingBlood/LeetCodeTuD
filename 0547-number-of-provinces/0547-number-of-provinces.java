class Solution {
    public int parent(int i,int[] parent){
        if(parent[i]!=i){
            parent[i]=parent(parent[i],parent);
        }
        return parent[i]; 
    }
    public int findCircleNum(int[][] C) {
        int n=C.length;
        int[] size = new int[n];
        int[] parent = new int[n];
        for(int i=0;i<n;i++){
            size[i]=1;
            parent[i]=i;
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(C[i][j]==1){
                    int upi = parent(i,parent);
                    int upj = parent(j,parent);
                    if(size[upi]>=size[upj]){
                        size[upi]+=size[upj];
                        parent[upj]=upi;
                    }else if(size[upi]<size[upj]){
                        size[upj]+=size[upi];
                        parent[upi]=upj;
                    }
                }
            }
        }
        Set<Integer> s = new HashSet<Integer>();
        for(int i=0;i<n;i++){
            parent(i,parent);
            s.add(parent[i]);
        }
        return s.size();
    }
}