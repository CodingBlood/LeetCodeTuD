class Solution {
    public int lengthOfLastWord(String s) {
        s=s.trim();
        int cnt=1;
        while(s.charAt(s.length()-cnt)!=' '){
            cnt++;
            if(s.length()-cnt<0)return cnt-1;
        }
        return cnt-1;
    }
}