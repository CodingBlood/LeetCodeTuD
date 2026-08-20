class Solution {
    int[] findNSE(int[] arr) {
        int n = arr.length;
        Deque<Integer> s = new ArrayDeque<>();
        int[] ans = new int[arr.length];
        Arrays.fill(ans, n);
        for (int i = 0; i < arr.length; i++) {
            while (!s.isEmpty() && arr[i] <= arr[s.peek()]) {
                ans[s.pop()] = i;
            }
            s.push(i);
        }
        return ans;
    }

    int[] findPSE(int[] arr) {
        Deque<Integer> s = new ArrayDeque<>();
        int[] ans = new int[arr.length];
        Arrays.fill(ans, -1);
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && arr[i] <= arr[s.peek()]) {
                s.pop();
            }
            if (!s.isEmpty()) {
                ans[i] = s.peek();
            }
            s.push(i);
        }
        return ans;
    }

    public int sumSubarrayMins(int[] arr) {
        long t = 0;
        long mod = 1000000007;
        int[] nse = findNSE(arr);
        int[] pse = findPSE(arr);
        // for (int i : arr) {
        //     System.out.print(i + " , ");
        // }
        // System.out.println("");
        // for (int i : nse) {
        //     System.out.print(i + " , ");
        // }
        // System.out.println("");
        // for (int i : pse) {
        //     System.out.print(i + " , ");
        // }
        // System.out.println("");
        long tot = 0;
        for (int i = 0; i < arr.length; i++) {
            long leftCount = i - pse[i];
            long rightCount = nse[i] - i;

            long contribution = (leftCount * rightCount) % mod;
            contribution = (contribution * arr[i]) % mod;

            tot = (tot + contribution) % mod;
        }
        return (int) (tot % mod);
    }
}