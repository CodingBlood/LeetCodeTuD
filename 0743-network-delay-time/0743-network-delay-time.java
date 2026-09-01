class Solution {
    // lets do toplogical sort using Kahn's algo to detect the min distance of each node from k, if any og the node is still infinity..then return -1
    public static class Pair implements Comparable<Pair>{
        int node;
        int time;
        Pair(int node, int time){
            this.node = node;
            this.time = time;            
        }
        @Override
        public int compareTo(Pair other){
            return Integer.compare(this.node,other.node);
        }
        @Override
        public String toString(){
            return " ( " + this.node + " - " + this.time + " ) ";
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] time = new int[n];
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Pair>());
        }
        for(int i=0;i<times.length;i++){
            adj.get(times[i][0]-1).add(new Pair(times[i][1]-1,times[i][2]));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(k-1,0));
        Arrays.fill(time, Integer.MAX_VALUE);
        time[k-1]=0;
        while(!pq.isEmpty()){
            Pair t = pq.poll();
            // System.out.println(t);
            if(t.time>time[t.node])continue;
            for(int i=0;i<adj.get(t.node).size();i++){
                int crr_node = adj.get(t.node).get(i).node;
                int crr_time = adj.get(t.node).get(i).time;
                if(time[crr_node]>t.time+crr_time){
                    time[crr_node]=t.time+crr_time;
                    pq.add(new Pair(crr_node,time[crr_node]));
                }
            }
        }
        int sum=0;
        for(int i:time){
            if(i==Integer.MAX_VALUE)return -1;
            if(i>sum)sum=i;
        }
        return sum;
    }
}


