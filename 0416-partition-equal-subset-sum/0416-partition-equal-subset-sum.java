class Solution {
    public boolean helper(int[] nums,int t,int i,int[][] memo){
        if(t==0)return true;
        if(i<0 || t<0)return false;
        if(memo[i][t]!=-1)return memo[i][t]==1;
        if(helper(nums,t-nums[i],i-1,memo) || helper(nums,t,i-1,memo)){
            memo[i][t]=1;
            return true;
        }
        memo[i][t]=0;
        return false;
    }
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i:nums){
            sum+=i;
        }
        int[][] memo = new int[nums.length][sum];
        for(int[] i:memo){
            Arrays.fill(i,-1);
        }
        if(sum%2==1)return false;
        return helper(nums,sum/2,nums.length-1,memo);
    }
}