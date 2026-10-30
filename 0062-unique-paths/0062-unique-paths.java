class Solution {
    public int helper(int i,int j,int[][] dp){
        if(i<0)return 0;
        if(j<0)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        return dp[i][j]=helper(i-1,j,dp)+helper(i,j-1,dp);
    }
    public int uniquePaths(int m, int n) {
        int[][]dp = new int[m][n];
        for(int[] i: dp){
            Arrays.fill(i,-1);
        }
        dp[0][0]=1;
        return helper(m-1,n-1,dp);
    }
}
