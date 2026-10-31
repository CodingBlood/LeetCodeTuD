class Solution {
    public int helper(int[] coins, int amount,int i, int[][] dp){
        if(amount==0)return 0;
        if(i<0)return -1;
        if(dp[i][amount]!=-2)return dp[i][amount];
        if(i == 0) return amount % coins[0] == 0 ? amount / coins[0] : -1;
        int take = -1;
        if (amount >= coins[i]) {
            take = helper(coins, amount - coins[i], i, dp);
        }
        int nottake = helper(coins,amount,i-1,dp);


        if(take<0){
            if(nottake<0){
                return dp[i][amount]=-1;
            }else{
                return dp[i][amount]=nottake;
            }
        }else{
            if(nottake<0){
                return dp[i][amount]=take+1;
            }else{
                return dp[i][amount]=Math.min(take+1,nottake);
            }
        }
        


    }
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[][] dp = new int[coins.length][amount+1];
        for(int[] i: dp){
            Arrays.fill(i,-2);
        }
        return helper(coins,amount,coins.length-1,dp);
    }
}