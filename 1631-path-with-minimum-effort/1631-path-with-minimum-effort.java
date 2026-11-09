class Solution {
    class Triplet implements Comparable<Triplet>{
        int i,j,k;
        Triplet(int i,int j,int k){
            this.i=i;
            this.j=j;
            this.k=k;
        }
        @Override
        public int compareTo(Triplet other){
            return Integer.compare(this.k,other.k);
        }
    }
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<Triplet> pq = new PriorityQueue<>();
        int[][] D = new int[heights.length][heights[0].length];
        for(int[] i: D){
            Arrays.fill(i, Integer.MAX_VALUE);
        }
        pq.add(new Triplet(0,0,0));
        D[0][0]=0;
        int[] h = new int[]{-1,0,1,0};
        int[] v = new int[]{0,-1,0,1};

        while(!pq.isEmpty()){
            Triplet t = pq.poll();
            for(int i=0;i<4;i++){
                int ch = t.i+h[i];
                int vh = t.j+v[i];
                if(ch>=0 && vh>=0 && ch<heights.length && vh<heights[0].length){
                    int crr_dist = Math.max(t.k,Math.abs(heights[t.i][t.j]-heights[ch][vh]));
                    if(D[ch][vh]>crr_dist){
                        D[ch][vh]=crr_dist;
                        pq.add(new Triplet(ch,vh,crr_dist));
                    }
                }
            }
        }
        return D[heights.length-1][heights[0].length-1];
    }
}