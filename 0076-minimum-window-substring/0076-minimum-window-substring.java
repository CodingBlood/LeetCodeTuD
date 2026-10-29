class Solution {
    public String minWindow(String s, String t) {
        
        if(t.length() > s.length()){
            return "";
        }

        HashMap<Character,Integer> map = new HashMap<>();

        // Store frequency of characters in t
        for(int i = 0; i < t.length(); i++){
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int minCount = t.length();
        int minLength = Integer.MAX_VALUE;

        int left = 0;
        int start = 0;

        // Expand window
        for(int right = 0; right < s.length(); right++){

            char ch = s.charAt(right);

            if(map.containsKey(ch)){

                // Needed character found
                if(map.get(ch) > 0){
                    minCount--;
                }

                // Reduce frequency
                map.put(ch, map.get(ch) - 1);
            }

            // Shrink window
            while(minCount == 0){

                int winLength = right - left + 1;

                // Update minimum window
                if(winLength < minLength){
                    minLength = winLength;
                    start = left;
                }

                char leftChar = s.charAt(left);

                if(map.containsKey(leftChar)){

                    // Restore frequency
                    map.put(leftChar, map.get(leftChar) + 1);

                    // Window becomes invalid
                    if(map.get(leftChar) > 0){
                        minCount++;
                    }
                }

                left++;
            }
        }

        if(minLength == Integer.MAX_VALUE){
            return "";
        }

        return s.substring(start, start + minLength);
    }
}