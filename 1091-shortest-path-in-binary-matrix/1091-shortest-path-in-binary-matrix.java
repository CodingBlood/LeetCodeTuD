class Solution {
    class Triplet{
        int i,j,k;
        Triplet(int i, int j, int k){
            this.i=i;
            this.j=j;
            this.k=k;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        int[][] vis = new int[n][n];
        for(int[] i:vis){
            Arrays.fill(i,0);
        }
        if(grid[0][0]==1 || grid[n-1][n-1]==1)return -1;
        if(n==1)return 1;
        Deque<Triplet> Q = new ArrayDeque<Triplet>();
        Q.add(new Triplet(0,0,1));
        vis[0][0]=1;

        int[] h = new int[]{-1,-1,-1, 1,1,1, 0,0};
        int[] v = new int[]{-1, 0, 1,-1,0,1,-1,1};
        while(!Q.isEmpty()){
            Triplet curr = Q.poll();
            for(int i=0;i<8;i++){
                int ch = curr.i+h[i];
                int vh = curr.j+v[i]; 
                
                if(ch>=0 && ch<n && vh>=0 && vh<n && vis[ch][vh]!=1 && grid[ch][vh]==0){
                    if(ch==n-1 && vh==n-1){
                        return curr.k+1;
                    }
                    Q.add(new Triplet(ch,vh,curr.k+1));
                    vis[ch][vh]=1;
                }
            }
        }
        return -1;
    }
}