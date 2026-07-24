class Solution {
    public static int[] HD = new int[]{0,1,0,-1};
    public static int[] VD = new int[]{1,0,-1,0};
    public class Pair implements Comparable<Pair>{
        int i;
        int j;
        int d;
        Pair(int i, int j, int d){
            this.i = i;
            this.j = j;
            this.d = d;
        }
        @Override
        public int compareTo(Pair other){
            return Integer.compare(this.d,other.d);
        }
    }
    public int minimumEffortPath(int[][] h) {
        int x=h.length;
        int y=h[0].length;
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        int[][] sp = new int[x][y];
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                sp[i][j]=Integer.MAX_VALUE;
            }
        }
        sp[0][0]=0;
        pq.add(new Pair(0,0,0));
        while(!pq.isEmpty()){
            Pair t = pq.poll();
            for(int i=0;i<4;i++){
                int m=t.i+HD[i];
                int n=t.j+VD[i];
                if(m>=0 && n>=0 && m<x && n<y){
                    int temp = Math.max(t.d,(Math.abs(h[t.i][t.j]-h[m][n])));
                    // System.out.print(temp);
                    // System.out.print(" temp ");
                    // System.out.print(t.d);
                    // System.out.print(" t.d ");
                    // System.out.print(sp[m][n]);
                    // System.out.println(" sp[m][n] ");
                    if(sp[m][n]>temp){
                        sp[m][n]=temp;
                        pq.add(new Pair(m,n,temp));
                    }
                }
            }
        }
        return sp[x-1][y-1];
    }
}