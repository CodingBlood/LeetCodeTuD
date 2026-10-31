class Solution {
    private static final int INF = 1000_000_00;
    int helper(int[] coins,int amount,int n,int[][] dp){
        if(n==0)return amount%coins[n]==0 ? amount/coins[0] : -1;
        if(amount==0)return 0;
        if(dp[amount][n]!=-1)return dp[amount][n];
        //not take
        int result=INF;
        int not_take = helper(coins,amount,n-1,dp);
        int take = INF;
        if(amount>=coins[n]){
            take = helper(coins,amount-coins[n],n,dp);
        }
        if(take!=INF && take!=-1){
            result=Math.min(take+1,result);
        }
        if(not_take!=INF && not_take!=-1){
            result=Math.min(not_take,result);
        }
        return dp[amount][n] = result;

    }
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[amount + 1][coins.length + 1];
        for(int[] i:dp){
            Arrays.fill(i,-1);
        }
        int sol = helper(coins,amount,coins.length-1,dp);
        return sol==INF?-1:sol;
    }
}