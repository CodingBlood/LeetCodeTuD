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
        // @Override
        // public String toString() {
        //     return "n: " + this.n + ", " + " d: " + this.d + ", " + " k: " + this.k;
        // }

    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        int[] d = new int[n];
        int[] p = new int[n];
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Pair>());
        }
        for(int i=0;i<flights.length;i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2],0));
        }
        Arrays.fill(d,Integer.MAX_VALUE);
        Arrays.fill(p,Integer.MAX_VALUE);
        d[src]=0;
        p[src]=src;
        pq.add(new Pair(src,0,0));
        while(!pq.isEmpty()){
            Pair t = pq.poll();
            // System.out.println("Found in PQ : " + t);
            // if(t.n==dst && t.k<=k+1)return t.d;
            // if(t.d>d[t.n])continue;
            for(int i=0;i<adj.get(t.n).size();i++){
                // System.out.println("here");
                if(d[adj.get(t.n).get(i).n]>t.d+adj.get(t.n).get(i).d && t.k<=k){
                    // System.out.println("here1");
                    d[adj.get(t.n).get(i).n]=t.d+adj.get(t.n).get(i).d;
                    pq.add(new Pair(adj.get(t.n).get(i).n,d[adj.get(t.n).get(i).n],t.k+1));
                }
            }
        }
        if(d[dst]!=Integer.MAX_VALUE)return d[dst];
        return -1;
    }
}