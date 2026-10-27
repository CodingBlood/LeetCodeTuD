class Solution {
    public boolean days_toShip_acceptable(int[] w, int c, int d) {
        int t = 1;
        int currload = 0;
        for (int i = 0; i < w.length; i++) {
            if (currload + w[i] <= c) {
                currload += w[i];
            } else {
                t++;
                currload = w[i];
            }
            if (t > d)return false;
                
        }
        return t <= d;
    }

    public int shipWithinDays(int[] weights, int days) {
        int s = weights[0];
        int e = 0;
        for (int i : weights) {
            if(i>s)s=i;
            e += i;
        }
        int sol = e;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (days_toShip_acceptable(weights, mid, days)) {
                sol = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return sol;
    }
}