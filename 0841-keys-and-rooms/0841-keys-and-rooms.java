class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] v = new boolean[rooms.size()];
        Arrays.fill(v,false);
        Deque<Integer> q = new ArrayDeque<>();
        q.add(0);
        while(!q.isEmpty()){
            int t = q.poll();
            if(!v[t]){
                v[t]=true;
                for(int j=0;j<rooms.get(t).size();j++){
                    q.add(rooms.get(t).get(j));
                }
            }
        }
        for(int j=0;j<rooms.size();j++){
            if(!v[j])return false;
        }
        return true;
    }
}