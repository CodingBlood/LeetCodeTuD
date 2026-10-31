class Solution {
    int helper(int[] coins,int n, int amt, int[][] dp){
        if(amt<0)return 0;
        if(amt==0)return 1;
        if(n==0){
            if(amt%coins[0]==0){
                return 1;
            }
            return 0;
        }
        if(dp[n][amt]!=-1)return dp[n][amt];

        // not take the coin
        int not_take = helper(coins,n-1,amt,dp);
        int take=0;
        if(amt>=coins[n]){
            take = helper(coins,n,amt-coins[n],dp);
        }
        return dp[n][amt]=not_take+take;
    }
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        for(int[] i :dp){
            Arrays.fill(i,-1);
        }
        return helper(coins, coins.length-1,amount,dp);
    }
}