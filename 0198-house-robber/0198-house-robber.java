class Solution {
    public int helper(int[] nums,int n,int[] dp){
        if(n<0)return 0;
        if(dp[n]!=-1)return dp[n];
        int p=helper(nums,n-1,dp);
        int pp=helper(nums,n-2,dp);
        if(pp+nums[n]>p){
            return dp[n]=pp+nums[n];
        }else{
            return dp[n]=p;
        }
    }
    public int rob(int[] nums) {
        int n=nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return helper(nums,n-1,dp);
    }
}