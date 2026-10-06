class Solution {
    public int helper(int n,List<Integer> dp){
        if(n==0)return 1;
        if(n<0)return 0;
        if(dp.get(n)!=Integer.MAX_VALUE)return dp.get(n);
        dp.set(n, helper(n-1,dp) + helper(n-2,dp));
        return dp.get(n);
    }
    public int climbStairs(int n) {
        List<Integer> dp = new ArrayList<Integer>();
        for(int i=0;i<n+1;i++){
            dp.add(Integer.MAX_VALUE);
        }
        return helper(n,dp);
    }
}