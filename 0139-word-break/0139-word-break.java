class Solution {

    public boolean helper(String s, Set<String> set, Boolean[] dp) {
        if(s.length()==0)return true;
        if(dp[s.length()]!=null)return dp[s.length()];
        int i=1,n=s.length();
        while(n-i>=0){
            if(set.contains(s.substring(n-i,n))){
                if(n-i==0)return true;
                if(helper(s.substring(0,n-i),set,dp)){
                    dp[s.length()]=true;
                    return true;
                }     
            }
            i++;
        }
        dp[s.length()]=false;
        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set=new HashSet<String>();
        Boolean[] dp = new Boolean[s.length()+1];
        for(String i:wordDict){
            set.add(i);
        }
        return helper(s,set,dp);
    }
}