class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<Integer>();

        for(int i:nums){
            s.add(i);
        }
        int longest=0;
        for(int i : s){
            int l=0;
            if(!s.contains(i-1)){
                l=1;
            
                while(s.contains(i+l)){
                    l++;
                }
            }
            longest=longest>l?longest:l;
        }

        return longest;
    }
}