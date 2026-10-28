class Solution {
    public int[][] merge(int[][] intervals) {
        int[][] t = new int[intervals.length][2];
        for(int i=0;i<intervals.length;i++){
            t[i]=intervals[i].clone();
        }
        Arrays.sort(t,(a,b)->{
            if(a[0]==b[0]){
                return Integer.compare(a[1],b[1]);
            }
            return Integer.compare(a[0],b[0]);
        });
        int[][] sol = new int[intervals.length][2];
        int m=1;
        sol[0]=t[0].clone();
        for(int i=1;i<intervals.length;i++){
            if(sol[m-1][1]>=t[i][0]){
                sol[m-1][1]=Integer.max(sol[m-1][1],t[i][1]);
            }else{
                sol[m]=t[i].clone();
                m++;
            }
        }
        return Arrays.copyOf(sol,m);
    }
}