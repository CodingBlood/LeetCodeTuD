class Solution {
    static int M = 1_000_000_007;
    public static class Pair implements Comparable<Pair>{
        int n;
        long d;
        Pair(int n,long d){this.n=n;this.d=d;}
        @Override
        public int compareTo(Pair other){
            return Long.compare(this.d,other.d);
        }
        @Override
        public String toString(){
            return "[ n="+ this.n +" d=" + this.d + " ]";
        }
    }
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        long[] d = new long[n]; 
        long[] paths = new long[n]; 
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Pair>());
        }
        Arrays.fill(d,Long.MAX_VALUE);
        d[0]=0;
        paths[0]=1;
        pq.add(new Pair(0,0));
        for(int i=0;i<roads.length;i++){
            adj.get(roads[i][0]).add(new Pair(roads[i][1],roads[i][2]));
            adj.get(roads[i][1]).add(new Pair(roads[i][0],roads[i][2]));
        }
        while(!pq.isEmpty()){
            Pair t = pq.poll();
            if (t.d > d[t.n]) continue;
            for(int i=0;i<adj.get(t.n).size();i++){
                int crr_node = adj.get(t.n).get(i).n;
                long crr_dist = adj.get(t.n).get(i).d;
                if(d[crr_node]==(crr_dist+t.d)) {
                    paths[crr_node] = (paths[crr_node] + paths[t.n]) % M;
                }else if(d[crr_node]>(crr_dist+t.d)){
                    d[crr_node]=(crr_dist+t.d);
                    paths[crr_node] = paths[t.n]; 
                    pq.add(new Pair(crr_node, d[crr_node]));
                }
            }
        }
        return (int)(paths[n-1] % M);
    }
}