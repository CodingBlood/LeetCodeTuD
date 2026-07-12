class Solution {
    public void bfs(Deque<int[]> q,int[][] image, Boolean[][] v, int color, int og){
        while(!q.isEmpty()){
            int[] t = q.poll();
            int sr=t[0],sc=t[1];
            if(image[sr][sc]==og){
                image[sr][sc]=color;
                if(sr-1>=0 && v[sr-1][sc]){
                    v[sr-1][sc]=false;
                    q.add(new int[]{sr-1,sc});
                }
                if(sc-1>=0 && v[sr][sc-1]){
                    v[sr][sc-1]=false;
                    q.add(new int[]{sr,sc-1});
                }
                if(sr+1<image.length && v[sr+1][sc]){
                    v[sr+1][sc]=false;
                    q.add(new int[]{sr+1,sc});
                }
                if(sc+1<image[0].length && v[sr][sc+1]){
                    q.add(new int[]{sr,sc+1});
                    v[sr][sc+1]=false;
                }
            } 
        }        
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int og=image[sr][sc];
        Boolean[][] v = new Boolean[image.length][image[0].length];
        for(Boolean[] i:v){
            Arrays.fill(i,true);
        }
        Deque<int[]> q = new ArrayDeque<int[]>();
        q.add(new int[]{sr,sc});
        v[sr][sc]=false;
        bfs(q, image,v,color,og);
        return image;
    }
}