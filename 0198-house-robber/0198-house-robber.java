class Solution {
    public int helper(int n, int[] nums, int[] dp){
        if(n==0)return nums[0];
        if(n==-1)return 0;
        if(dp[n]!=-1)return dp[n];
        int p = helper(n-1,nums,dp);
        int pp = helper(n-2,nums,dp);
        if(p>pp+nums[n]){
            return dp[n]=p;
        }else{
            return dp[n]=pp+nums[n];
        }
    }
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return helper(nums.length-1,nums,dp);
    }
}