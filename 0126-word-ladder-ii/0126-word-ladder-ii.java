class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        boolean flag=false;
        HashSet<String> hash=new HashSet<>();
        HashMap<String,Integer> mpp=new HashMap<>();
        HashMap<String,List<String>> parents=new HashMap<>();
        for(String i : wordList) hash.add(i);
        if(!hash.contains(endWord)) return new ArrayList<>();
        List<List<String>> ans=new ArrayList<>();
        Queue<String> q=new LinkedList<>();
        int cnt=-1;
        q.offer(beginWord);
        hash.remove(beginWord);
        for(int i=0;i<wordList.size();i++) parents.put(wordList.get(i),new ArrayList<>());
        parents.putIfAbsent(beginWord,new ArrayList<>());
        while(!q.isEmpty()){
            int size=q.size();
            cnt++;
            HashSet<String> levelvisited=new HashSet<>();
            for(int i=0;i<size;i++){
                String x=q.poll();
                char[] curr=x.toCharArray();
                mpp.putIfAbsent(x,cnt);
                if(x.equals(endWord)){
                    flag=true;
                    continue;
                }
                for(int j=0;j<curr.length;j++){
                    char real=curr[j];
                    for(char n='a';n<='z';n++){
                        if(n==real) continue;
                        curr[j]=n;
                        String word = new String(curr);
                        if(hash.contains(word)){
                            parents.get(word).add(x);
                            if(!levelvisited.contains(word)){
                                levelvisited.add(word);
                                q.offer(word);
                            }
                        }
                    }
                    curr[j]=real;
                }
            }
            for(String y : levelvisited) hash.remove(y);
            if(flag) break;
        }
        if(!mpp.containsKey(endWord)) return ans;
        dfs(endWord,mpp,ans,new ArrayList<>(),beginWord,parents);
        return ans;
    }
    void dfs(String curr,HashMap<String,Integer> mpp,List<List<String>> ans,List<String> res,String start,HashMap<String,List<String>> parents){
        res.add(curr);
        if(curr.equals(start)){
            List<String> temp=new ArrayList<>(res);
            Collections.reverse(temp);
            ans.add(new ArrayList<>(temp));
            res.remove(res.size()-1);
            return;
        }
        char[] cur=curr.toCharArray();
        for(String par : parents.get(curr)){
                if(mpp.containsKey(par) && mpp.get(par)==(mpp.get(curr)-1)){
                    dfs(par,mpp,ans,res,start,parents);
                }
        }
        res.remove(res.size()-1);
    }
}