class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int[][] sol = new int[intervals.length][2];
        int m = 0;

        for (int[] interval : intervals) {
            if (m == 0 || interval[0] > sol[m - 1][1]) {
                sol[m] = interval;
                m++;
            } else {
                sol[m - 1][1] = Math.max(sol[m - 1][1], interval[1]);
            }
        }
        return Arrays.copyOf(sol, m);
    }
}