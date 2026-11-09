class Solution {
    class Pair implements Comparable<Pair>{
        int i,j;
        Pair(int i, int j){
            this.i=i;
            this.j=j;
        }
        @Override
        public int compareTo(Pair other){
            return Integer.compare(this.j,other.j);
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);

        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Pair>());
        }
        for(int i=0;i<times.length;i++){
            adj.get(times[i][0]-1).add(new Pair(times[i][1]-1,times[i][2]));
        }
        int min =Integer.MIN_VALUE;
        pq.add(new Pair(k-1,0));
        dist[k-1]=0;
        while(!pq.isEmpty()){
            Pair crr = pq.poll();
            for(int i=0;i<adj.get(crr.i).size();i++){
                Pair temp = adj.get(crr.i).get(i);
                if(dist[temp.i]>crr.j+temp.j){
                    dist[temp.i]=crr.j+temp.j;
                    pq.add(new Pair(temp.i,crr.j+temp.j));
                }
            }
        }
        for(int i: dist){
            if(i==Integer.MAX_VALUE)return -1;
            min = Integer.max(i,min);
        }
        return min;
    }
}