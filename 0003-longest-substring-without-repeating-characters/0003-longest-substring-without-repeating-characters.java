class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> mp = new HashMap<>();
        int size=0,start=0;
        for(int i=0;i<s.length();i++){
            char crr = s.charAt(i);

            if(mp.containsKey(crr) && mp.get(crr)>=start){
                start=mp.get(crr)+1;
            }
            mp.put(crr,i);

            size=Integer.max(size,i-start+1);
        }
        return size;
    }
}

// s   abcabcbb
//         l
//      s
// ls=3
// c=1
// a=0 b=1 c=2

