class Solution {

    public boolean helper(String s, Set<String> set, Map<String,Boolean> dp) {
        if(s.length()==0)return true;
        if(dp.containsKey(s))return dp.get(s);
        int i=1,n=s.length();
        while(n-i>=0){
            if(set.contains(s.substring(n-i,n))){
                if(n-i==0)return true;
                if(helper(s.substring(0,n-i),set,dp)){
                    dp.put(s,true);
                    return true;
                }     
            }
            i++;
        }
        dp.put(s,false);
        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set=new HashSet<String>();
        Map<String,Boolean> dp=new HashMap<String, Boolean>();
        for(String i:wordDict){
            set.add(i);
        }
        return helper(s,set,dp);
    }
}