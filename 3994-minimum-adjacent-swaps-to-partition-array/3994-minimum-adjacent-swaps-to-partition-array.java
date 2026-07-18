class Solution {
    private static final int MOD = 1_000_000_007;

    public int minAdjacentSwaps(int[] nums, int a, int b) {
        
        int n = nums.length;
        long count0 = 0;
        long count1 = 0;
        
        for (int num : nums) {
            if (num < a) {
                count0++;
            } else if (num <= b) {
                count1++;
            }
        }
        
        long current0 = 0;
        long current1 = 0;
        long current2 = 0;
        long totalSwaps = 0;
        
        for (int num : nums) {
            if (num < a) {
                totalSwaps = (totalSwaps + current1 + current2) % MOD;
                current0++;
            } else if (num <= b) {
                totalSwaps = (totalSwaps + current2) % MOD;
                current1++;
            } else {
                current2++;
            }
        }
        
        return (int) (totalSwaps % MOD);
    }
}


