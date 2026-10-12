class Solution {

    class Pair{
        int n;
        double w;
        Pair(int n, double w){
            this.n=n;
            this.w=w;
        }
    }

    class Node implements Comparable<Node>{
        int n;
        double w;
        Node(int n, double w){
            this.n=n;
            this.w=w;
        }

        @Override
        public int compareTo(Node other){
            return Double.compare(this.n,other.n);
        }

        @Override
        public String toString(){
            return "( n = " + n + " w= " + w + " ) ";
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Pair>());
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1],-Math.log(succProb[i])));
            adj.get(edges[i][1]).add(new Pair(edges[i][0],-Math.log(succProb[i])));
        }

        double[] d = new double[n];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[start_node]=0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start_node,0));
        while(!pq.isEmpty()){
            Node q = pq.poll();
            for(int i=0;i<adj.get(q.n).size();i++){
                int c_node = adj.get(q.n).get(i).n;
                double c_wght = adj.get(q.n).get(i).w;
                if(d[c_node]>c_wght+q.w){
                    d[c_node]=c_wght+q.w;
                    pq.add(new Node(c_node,c_wght+q.w));
                }
            }
        }
        return Math.exp(-d[end_node]);
    }
}