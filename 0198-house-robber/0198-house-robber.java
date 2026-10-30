class Solution {
    public int rob(int[] nums) {
        int p=0;
        int pp=0;
        for(int i=0;i<nums.length;i++){
            if(pp+nums[i]>p){
                nums[i]+=pp;
            }else{
                nums[i]=p;
            }
            pp=p;
            p=nums[i];
        }
        return nums[nums.length-1];
    }
}