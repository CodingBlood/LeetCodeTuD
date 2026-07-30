class Solution {
    public class Pair implements Comparable<Pair>{
        int w,n,p;
        Pair(int w,int n,int p){
            this.w=w;
            this.n=n;
            this.p=p;
        }
        @Override
        public int compareTo(Pair other){
            return Integer.compare(this.w,other.w);
        } 
        // @Override
        // public String toString(){
        //     return "[ " + this.w + " - " + this.n + " - " + this.p + " ]";
        // } 
    }
    public int distance(int xi, int yi, int xj, int yj){
        return Math.abs(Math.abs(xi-xj) + Math.abs(yi-yj));
    }
    public int minCostConnectPoints(int[][] points) {
        int cost=0;
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        int[] v = new int[points.length];
        Arrays.fill(v,0);
        pq.add(new Pair(0,0,0));
        while(!pq.isEmpty()){
            Pair t = pq.poll();
            // System.out.println(t);
            if(v[t.n]==1)continue;
            v[t.n]=1;
            cost+=t.w;
            for(int i=0;i<points.length;i++){
                if(v[i]==0){
                    int d = distance(points[t.n][0],points[t.n][1],points[i][0],points[i][1]);
                    pq.add(new Pair(d,i,t.n));
                    // System.out.print("    Added to Q ");
                    // System.out.println(pq.peek());
                }
            }
        }
        return cost;
    }
}