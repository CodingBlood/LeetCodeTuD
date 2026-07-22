class Solution {
    public class P{
        String w;
        int n;
        P(String w, int n){
            this.w=w;
            this.n=n;
        }
    }
    public int ladderLength(String bW, String eW, List<String> wordList) {
        Set<String> wL = new HashSet<String>(wordList);
        Deque<P> q = new ArrayDeque<P>();
        q.add(new P(bW,1));
        while(!q.isEmpty()){
            P t = q.poll();
            for(int i=0;i<t.w.length();i++){
                for(int j=0;j<26;j++){
                    StringBuilder sb = new StringBuilder(t.w);
                    sb.setCharAt(i, (char) ('a' + j));
                    if(wL.contains(sb.toString())){
                        if(eW.equals(sb.toString())){
                            return t.n+1;
                        }
                        q.add(new P(sb.toString(),t.n+1));
                        wL.remove(sb.toString());
                    }
                }
            }
        }
        return 0;
    }
}