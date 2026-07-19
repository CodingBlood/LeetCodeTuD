class Solution {
    public String getCanonical(String s) {
        if (s == null || s.length() <= 1) return s;
        
        int n = s.length();
        int i = 0, j = 1, k = 0;
        
        while (i < n && j < n && k < n) {
            char a = s.charAt((i + k) % n);
            char b = s.charAt((j + k) % n);
            
            if (a == b) {
                k++;
            } else {
                if (a > b) {
                    i += k + 1;
                } else {
                    j += k + 1;
                }
                
                if (i == j) {
                    j++;
                }
                k = 0;
            }
        }
        
        int idx = Math.min(i, j);
        return s.substring(idx) + s.substring(0, idx);
    }
    public int minimumGroups(String[] words) {
        Set<String> uniqueGroups = new HashSet<>();
        
        for (String word : words) {
            if (word.length() <= 1) {
                uniqueGroups.add(word + "#");
                continue;
            }
            
            StringBuilder e = new StringBuilder();
            StringBuilder o = new StringBuilder();
            
            for (int i = 0; i < word.length(); i++) {
                if (i % 2 == 0) {
                    e.append(word.charAt(i));
                } else {
                    o.append(word.charAt(i));
                }
            }
            
            String canE = getCanonical(e.toString());
            String canO = getCanonical(o.toString());
            
            uniqueGroups.add(canE + "#" + canO);
        }
        
        return uniqueGroups.size();
    }
}