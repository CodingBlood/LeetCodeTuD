class Solution {
    public static boolean dfs(ArrayList<ArrayList<Integer>> graph, int p,int[] v){
        if (v[p] == 1) return false;
        if (v[p] == 2) return true;
        v[p]=1;
        for (int i : graph.get(p)) {
            if (!dfs(graph, i, v)) {
                return false; 
            }
        }
        v[p]=2;
        return true;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<Integer>());
        } 
        for(int i=0;i<prerequisites.length;i++){
            graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        int[] v = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            if (v[i] == 0) {
                if (!dfs(graph, i, v)) {
                    return false; 
                }
            }
        }
        return true;
    }
}