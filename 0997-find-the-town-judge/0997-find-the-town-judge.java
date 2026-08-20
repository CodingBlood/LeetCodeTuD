class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] indeg = new int[n];
        int[] outdeg = new int[n];
        Arrays.fill(indeg,0);
        Arrays.fill(outdeg,0);
        for(int i=0;i<trust.length;i++){
            outdeg[trust[i][0]-1]+=1;
            indeg[trust[i][1]-1]+=1;
        }
        
        // for(int i=0;i<n;i++){
        //     System.out.println(outdeg[i] + " , " + indeg[i]);
        // }
        for(int i=0;i<n;i++){
            if(outdeg[i]==0 && indeg[i]==n-1)return i+1;
        }
        return -1;
    }
}