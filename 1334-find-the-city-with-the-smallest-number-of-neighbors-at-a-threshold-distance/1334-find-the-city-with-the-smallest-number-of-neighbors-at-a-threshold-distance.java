class Solution {
    //Floyd-Warshal
    static int INF = 100000;
    public int findTheCity(int n, int[][] e, int distanceThreshold) {
        int[][] sol = new int[n][n];
        for(int[] i:sol){
            for(int j: i){
                Arrays.fill(i,INF);
            }
        }
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         System.out.print(sol[i][j] + " ");
        //     }
        //     System.out.println();
        // } 
        for(int i=0;i<n;i++){
            sol[i][i]=0;
        }
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         System.out.print(sol[i][j] + " ");
        //     }
        //     System.out.println();
        // } 
        for(int i=0;i<e.length;i++){
            sol[e[i][0]][e[i][1]]=e[i][2];
            sol[e[i][1]][e[i][0]]=e[i][2];
        }
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         System.out.print(sol[i][j] + " ");
        //     }
        //     System.out.println();
        // } 
        for(int val=0;val<n;val++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    sol[i][j] = Math.min(sol[i][j], sol[i][val] + sol[val][j]);
                }
            }   
        }
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         System.out.print(sol[i][j] + " ");
        //     }
        //     System.out.println();
        // } 
        int ans=n,ans_i=0;
        for(int i=0;i<n;i++){
            int t=0;
            for(int j=0;j<n;j++){
                if(sol[i][j]<=distanceThreshold){
                    t++;
                }
            }
            if (t <= ans) {
                ans = t;
                ans_i = i;
            }
        }
        return ans_i;
    }
}