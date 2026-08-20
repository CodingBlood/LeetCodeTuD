class Solution {
    public double dfs(int s,int e,double[][] grid, boolean[] visited){
        if(s==e)return 1;
        visited[s] = true;
        for(int i=0;i<grid.length;i++){
            if(grid[s][i]!=-1 && !visited[i]){
                double subResult = dfs(i, e, grid, visited);
                if (subResult != -1.0) {
                    return grid[s][i] * subResult;
                }
            }
        }
        return -1;
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Set<String> set = new HashSet<>();
        for(int i=0;i<equations.size();i++){    
            set.add(equations.get(i).get(0));
            set.add(equations.get(i).get(1));
        }
        List<String> list = new ArrayList<>(set);
        int n=set.size();
        double[][] grid = new double[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                grid[i][j]=-1;
            }
            grid[i][i]=1;
        }
        for(int i=0;i<equations.size();i++){  
            String s= equations.get(i).get(0);
            String e= equations.get(i).get(1);  
            grid[list.indexOf(s)][list.indexOf(e)]=values[i];
            grid[list.indexOf(e)][list.indexOf(s)]=1/values[i];
        }
        
        int n1= queries.size();
        double[] d =new double[n1];
        for(int i=0;i<n1;i++){
            String s= queries.get(i).get(0);
            String e= queries.get(i).get(1);
            if(!set.contains(s) || !set.contains(e)){
                d[i]=-1;
            }else{
                d[i]=dfs(list.indexOf(s),list.indexOf(e),grid, new boolean[n]);
            }
        }
        
        return d;
    }
}