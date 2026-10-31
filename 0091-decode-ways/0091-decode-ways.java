class Solution {
    public int helper(int n,int[] nums,int[] dp){
        if(n==0 && nums[0]!=0)return 1;
        if(nums[0]==0)return 0;
        if(n<0)return 1;
        if(dp[n]!=-1)return dp[n];
        int a=0,b=0;
        if(nums[n-1]*10+nums[n]<=26 && nums[n-1]!=0){
            a=helper(n-2,nums,dp);
        }
        if(nums[n]!=0){
            b=helper(n-1,nums,dp);
        }
        

        return dp[n]=a+b;
    }
    public int numDecodings(String s) {
        int[] nums = new int[s.length()];
        int i=0;
        for(char c: s.toCharArray()){
            nums[i++]=c-'0';
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return helper(nums.length-1,nums,dp);
    }
}
// 11106
// num(6)
// 6
// 1+06       0+6
// <=26?
// num(1)    num(0)
// else
// 0
// ->a        ->b
// sum = a+b