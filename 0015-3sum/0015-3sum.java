class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> sol = new HashSet<>();
        for(int i=0;i<nums.length-1;i++){
            int s=i+1;
            int e=nums.length-1;
            while(s<e){
                if(nums[i]+nums[s] + nums[e]<0){
                    s++;
                }else if(nums[i]+nums[s] + nums[e]>0){
                    e--;
                }else{
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[s]);
                    triplet.add(nums[e]);
                    sol.add(triplet);
                    s++;
                }
            }
        }
        return new ArrayList<>(sol);
    }
}