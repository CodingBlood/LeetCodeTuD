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
        // int[] dp = new int[nums.length];
        // Arrays.fill(dp,-1);
        // dp[0]=nums[0];
        int p=0;
        int pp=0;
        for(int i=0;i<nums.length;i++){
            if(pp+nums[i]>p){
                nums[i]+=pp;
            }else{
                nums[i]=p;
            }
            pp=p;
            p=nums[i];
        }
        return nums[nums.length-1];
    }
}