class Solution {
    public int dfs(int i,List<List<Integer>> map, int[] v){
        v[i]=1;
        int count=1;
        for(int j=0;j<map.get(i).size();j++){
            if(v[map.get(i).get(j)]!=1)count+=dfs(map.get(i).get(j),map,v);
        }
        return count;
    }
    public boolean[] cb(int x1,int y1, int r1,int x2,int y2,int r2){
        boolean[] det = new boolean[2];
        long dx = x2 - x1;
        long dy = y2 - y1;
        long distanceSquared = dx * dx + dy * dy; 

        if ((long)r1 * r1 >= distanceSquared) { det[0] = true; } else { det[0] = false; } 
        if ((long)r2 * r2 >= distanceSquared) { det[1] = true; } else { det[1] = false; } 
        
        return det;
    }
    public int maximumDetonation(int[][] bombs) {
        List<List<Integer>> map = new ArrayList<>();
        for(int i=0;i<bombs.length;i++){
            map.add(new ArrayList<Integer>());
        }
        for(int i=0;i<bombs.length;i++){
            for(int j=i+1;j<bombs.length;j++){
                boolean[] det = cb(bombs[i][0],bombs[i][1],bombs[i][2],bombs[j][0],bombs[j][1],bombs[j][2]);
                if(det[0]==true){map.get(i).add(j);}
                if(det[1]==true){map.get(j).add(i);}
            }
        }
        int max = 0;
        for(int i=0;i<bombs.length;i++){
            int[] v= new int[bombs.length];
            Arrays.fill(v,0);
            int c = dfs(i,map,v);
            if(c>max)max=c;
        }
        return max;
    }
}