class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer,Integer> hp = new HashMap<Integer, Integer>();

        int max=0;
        int count = 0;
        hp.put(0,-1);
        for(int i=0; i<nums.length;i++){
            count += (nums[i] == 1) ? 1 : -1;
            if(hp.containsKey(count)){
                max = Math.max(max, i - hp.get(count));
            }else {
                hp.put(count,i);
            }

        }
        return max;
        //  0  0  1 1 1 1 1  0  0  0
        // -1 -2 -1 0 1 2 3  2  1  0

        //  0  0  1 1 1 1 1 1  0  0  0
        // -1 -2 -1 0 1 2 3 4 -3 -2 -1
        //  1  2  3 4 5 6 7 8  9 10  11

        //  0  0  1 1 1 1 1 1  0  0  0
        // -1 -2 -1 0 1 2 3 4 -3 -2 -1
        //  1  2  3 4 5 6 7 8  9 10  11
    }
}