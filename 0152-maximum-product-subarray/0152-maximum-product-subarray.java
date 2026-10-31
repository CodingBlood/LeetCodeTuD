class Solution {
    int gmax=Integer.MIN_VALUE;
    public int[] helper(int n, int[] nums){
        if(n==0){
            gmax=Math.max(gmax,nums[n]);
            return new int[]{nums[n],nums[n]};
        }
        int[] pV = helper(n-1,nums);
        int a=nums[n];       //crr
        int b=pV[0]*nums[n]; //pmin*crr
        int c=pV[1]*nums[n]; //pmax*crr
        int cmax=Math.max(a,Math.max(b,c));
        int cmin=Math.min(a,Math.min(b,c));
        gmax=Math.max(gmax,cmax);
        return new int[]{cmin,cmax};
    }
    public int maxProduct(int[] nums) {
        helper(nums.length-1,nums);
        return gmax;
    }
}

