class Solution {
    public int smallestBalancedIndex(int[] nums) {
        int i=0,j=nums.length-1;
        long leftSum=0,rightProd=1;
        while(j!=i){
            if(leftSum<rightProd){
                leftSum+=nums[i];
                i++;
            }else{
                rightProd*=nums[j];
                j--;
            }
        }
        return leftSum==rightProd?i:-1;
    }
}