class Solution {
    public String rearrangeString(String s, char x, char y) {
        StringBuilder sol = new StringBuilder();
        int xi=0,yi=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==x){
                xi++;
            }
            if(s.charAt(i)==y){
                yi++;
            }
        }
        for(int i=0;i<yi;i++){
            sol.append(y);
        }
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=x && s.charAt(i)!=y){
                sol.append(s.charAt(i));
            }
        }
        
        for(int i=0;i<xi;i++){
            sol.append(x);
        }
        return sol.toString();
    }
}