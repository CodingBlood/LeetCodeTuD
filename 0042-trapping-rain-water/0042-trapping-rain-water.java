class Solution {
    public int[] nmax(int[] height){
        int[] ans = new int[height.length];
        Arrays.fill(ans,-1);
        int crr=-1;
        for(int i=height.length-1;i>=0;i--){
            if(height[i]>crr){
                ans[i]=height[i];
                crr=height[i];
            }else{
                ans[i]=crr;
            }
        }
        return ans;
    }
    public int[] pmax(int[] height){
        int[] ans = new int[height.length];
        Arrays.fill(ans,-1);
        int crr=-1;
        for(int i=0;i<height.length;i++){
            if(height[i]>crr){
                ans[i]=height[i];
                crr=height[i];
            }else{
                ans[i]=crr;
            }
        }
        return ans;
    }
    public int trap(int[] height) {
        int[] nmax = nmax(height);
        int[] pmax = pmax(height);
        int sol=0;
        for(int i=0;i<height.length;i++){
            sol+=Math.abs(height[i]-Math.min(nmax[i],pmax[i]));
        }
        
        return sol;
    }
}