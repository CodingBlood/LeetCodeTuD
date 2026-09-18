class Solution {
    public long maximumImportance(int n, int[][] roads) {
        Integer[] deg = new Integer[n];
        Arrays.fill(deg,0);
        for(int[] r:roads){
            deg[r[0]]++;
            deg[r[1]]++;
        }
        Arrays.sort(deg,Collections.reverseOrder());
        long sol=0;
        int v=n;
        for(int i:deg){
            sol+=(long)i*v;
            v--;
        }
        return (long) sol;
    }
}