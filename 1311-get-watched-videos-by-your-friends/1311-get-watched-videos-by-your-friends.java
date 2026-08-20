class Solution {
    public static List<String> sortAndReturnString(HashMap<String, Integer> map) {
        return map.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue()
                        .thenComparing(Map.Entry.comparingByKey()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        Deque<int[]> q =new ArrayDeque<>();
        int[] v = new int[friends.length];
        HashMap<String, Integer> map = new HashMap<>();
        q.add(new int[]{id,0});
        v[id]=1;
        while(!q.isEmpty()){
            int[] t = q.poll();
            v[t[0]]=1;
            
            if(t[1]==level){
                for(int i=0;i<watchedVideos.get(t[0]).size();i++){
                    String s = watchedVideos.get(t[0]).get(i);
                    map.put(s,map.getOrDefault(s,0)+1);
                } 
                continue;
            }
            if(t[1]>level)continue;
            for(int i=0;i<friends[t[0]].length;i++){
                if(v[friends[t[0]][i]]!=1){
                    v[friends[t[0]][i]]=1;
                    q.add(new int[]{friends[t[0]][i],t[1]+1});
                }
            }
        }
        return sortAndReturnString(map);
    }
}