class Solution {
    public static class Pair implements Comparable<Pair>{
        int n;
        int d;
        Pair(int n,int d){
            this.n=n;
            this.d=d;
        }
        @Override
        public int compareTo(Pair other){
            return Integer.compare(this.d,other.d);
        }
        
        @Override
        public String toString(){
            return "[ n="+this.n+" , d="+this.d+" ]";
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        PriorityQueue<Pair> pq= new PriorityQueue<Pair>();
        int[] d = new int[n];
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Pair>());
        }
        for(int i=0;i<times.length;i++){
            int s = times[i][0]-1;
            int e = times[i][1]-1;
            int w = times[i][2];
            adj.get(s).add(new Pair(e,w));
        }
        // System.out.println(adj);
        Arrays.fill(d,Integer.MAX_VALUE);
        d[k-1]=0;
        pq.add(new Pair(k-1,0));
        while(!pq.isEmpty()){
            Pair t = pq.poll();
            for(int i=0;i<adj.get(t.n).size();i++){
                int crr_node = adj.get(t.n).get(i).n;
                int crr_dist = adj.get(t.n).get(i).d;
                if(d[crr_node]>crr_dist+t.d){
                    d[crr_node]=crr_dist+t.d;
                    pq.add(new Pair(crr_node,d[crr_node]));
                }
            }
        }
        int sol = Integer.MIN_VALUE;
        for(int i:d){
            if(i==Integer.MAX_VALUE)return -1;
            if(i>sol){
                sol=i;
            }
        }
        return sol;
    }
}