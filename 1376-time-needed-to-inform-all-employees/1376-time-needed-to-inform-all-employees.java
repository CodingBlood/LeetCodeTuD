class Solution {
    public int helper(int hID ,List<List<Integer>> mp,int[] informTime){
        int sol=informTime[hID];
        int t=0;
        for(int i=0;i<mp.get(hID).size();i++){
            t=Math.max(t,helper(mp.get(hID).get(i),mp,informTime));
        }
        return sol+t;
    }
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<List<Integer>> mp = new ArrayList<>();
        for(int i=0;i<n;i++){
            mp.add(new ArrayList<Integer>());
        }
        for(int i=0;i<n;i++){
            if(manager[i]!=-1)mp.get(manager[i]).add(i);
        }
        int sol=informTime[headID];
        int t=0;
        for(int i=0;i<mp.get(headID).size();i++){
            t=Math.max(t,helper(mp.get(headID).get(i),mp,informTime));
        }
        return sol+t;
    }
}
                //            0
                //          /   \
                //         /     \
                //        /       \
                //       /         \
                //      1           2
                //     / \         / \
                //    /   \       /   \
                //   3     4     5     6
                //  / \   / \   / \   / \
                // 7   8 9 10  11 12 13 14