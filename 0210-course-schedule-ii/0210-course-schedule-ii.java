class Solution {
    public boolean dfs(List<List<Integer>> adj, int[] v, int i, List<Integer> topo) {
        if (v[i] == 1)
            return false;
        if (v[i] == 2)
            return true;
        v[i] = 1;
        for (int j = 0; j < adj.get(i).size(); j++) {
            if (!dfs(adj, v, adj.get(i).get(j), topo))
                return false;
        }
        v[i] = 2;

        topo.add(i);
        return true;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<Integer>());
        }
        List<Integer> topo = new ArrayList<Integer>();
        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        int[] v = new int[numCourses];
        Arrays.fill(v, 0);

        for (int i = 0; i < numCourses; i++) {
            if (v[i] == 0) {
                if (!dfs(adj, v, i, topo))
                    return new int[0];
            }
        }
        int[] arr = new int[topo.size()];
        for (int i = 0; i < topo.size(); i++) {
            arr[i] = topo.get(i);
        }
        return arr;
    }
}
