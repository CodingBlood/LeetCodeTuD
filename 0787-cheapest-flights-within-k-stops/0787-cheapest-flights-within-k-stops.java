class Solution {
    public static class Pair implements Comparable<Pair>{
        int n;
        int d;
        int k;
        Pair(int n,int d,int k){
            this.n=n;
            this.d=d;
            this.k=k;
        }
        @Override
        public int compareTo(Pair other){
            return Integer.compare(this.k, other.k);
        }

    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        int[] d = new int[n];
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Pair>());
        }
        for(int i=0;i<flights.length;i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2],0));
        }
        Arrays.fill(d,Integer.MAX_VALUE);
        d[src]=0;
        pq.add(new Pair(src,0,0));
        while(!pq.isEmpty()){
            Pair t = pq.poll();
            for(int i=0;i<adj.get(t.n).size();i++){
                int crr_node=adj.get(t.n).get(i).n;
                int crr_dist=adj.get(t.n).get(i).d;
                if(d[crr_node]>t.d+crr_dist && t.k<=k){
                    d[crr_node]=t.d+crr_dist;
                    pq.add(new Pair(crr_node,d[crr_node],t.k+1));
                }
            }
        }
        if(d[dst]!=Integer.MAX_VALUE)return d[dst];
        return -1;
    }
}