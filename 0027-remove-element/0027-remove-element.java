class Solution {
    public int removeElement(int[] nums, int val) {
        int j= nums.length-1;
        
        int i=0;
        while(i<=j){
            while (j >= 0 && nums[j] == val) { 
                j--; 
            } 
            
            if (i > j) {
                break;
            }
            
            if (nums[i] == val) { 
                int t = nums[i]; 
                nums[i] = nums[j]; 
                nums[j] = t; 
                j--;
            } 
            
            i++; 
        }
        return i;
    }
}