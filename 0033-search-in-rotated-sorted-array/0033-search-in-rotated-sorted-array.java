class Solution {
    public int search(int[] nums, int target) {
        int s=0;
        int e=nums.length-1;
        int mid = (s+e)/2;
        while(s<=e){
            mid = (s+e)/2;
            if(nums[mid]==target)return mid;
            if(nums[s]<=nums[mid]){
                if(nums[s]<=target && nums[mid]>=target){
                    e=mid-1;
                }else{
                    s=mid+1;
                }
            }else if(nums[e]>=nums[mid]){
                if(nums[e]>=target && nums[mid]<=target){
                    s=mid+1;
                }else{
                    e=mid-1;
                }
            }
        }
        return -1;
    }
}