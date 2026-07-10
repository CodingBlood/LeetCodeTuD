class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] v = new int[grid.length][grid[0].length];
        int c=0;
        for(int[] i: v){
            Arrays.fill(i,0);
        }
        Deque<int[]> q= new ArrayDeque<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    v[i][j]=2;
                    q.add(new int[]{i,j,0});
                }
            }
        }
        while(!q.isEmpty()){
            int[] set = q.poll();
            int i=set[0];
            int j=set[1];
            int k=set[2];
            if(i+1<grid.length && v[i+1][j]==0 && grid[i+1][j]==1){
                v[i+1][j]=2;
                grid[i+1][j]=2;
                q.add(new int[]{i+1,j,k+1});
            }
            if(i-1>=0 && v[i-1][j]==0 && grid[i-1][j]==1){
                v[i-1][j]=2;
                grid[i-1][j]=2;
                q.add(new int[]{i-1,j,k+1});
            }
            if(j+1<grid[0].length && grid[i][j+1]==1 && v[i][j+1]==0){
                v[i][j+1]=2;
                grid[i][j+1]=2;
                q.add(new int[]{i,j+1,k+1});
            }
            if(j-1>=0 && grid[i][j-1]==1 && v[i][j-1]==0){
                v[i][j-1]=2;
                grid[i][j-1]=2;
                q.add(new int[]{i,j-1,k+1});
            }
            if(k>c){
                c=k;
            }
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
    return c;

    }
}