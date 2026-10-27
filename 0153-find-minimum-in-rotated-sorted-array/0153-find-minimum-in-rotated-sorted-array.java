class Solution {
    public int findMin(int[] nums) {
        int s = 0;
        int e = nums.length-1;
        int c = nums[0];
        while(s<=e){
            int mid = (s+e)/2;
            c=nums[mid]<c?nums[mid]:c;
            c=nums[s]<c?nums[s]:c;
            c=nums[e]<c?nums[e]:c;
            if(nums[s]<nums[mid]){
                s=mid+1;
            }else{
                e=mid-1;
            }
        }
        return c;
    }
}