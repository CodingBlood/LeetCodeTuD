class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int last = nums.length-1;
        while(start<=last){
            int mid = (start+last)/2;
            if(nums[mid]==target)return mid;
            if(nums[mid]>target){
                last=mid-1;
            }else{
                start=mid+1;
            }
        }
        return -1;
    }
}