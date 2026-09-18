class Solution {
    public int[] NGE(int[] nums) {
        Deque<Integer> s = new ArrayDeque<Integer>();
        int[] r = new int[nums.length];
        Arrays.fill(r, nums.length);
        for (int i = 0; i < nums.length; i++) {
            while (!s.isEmpty()) {
                if (nums[s.peek()] < nums[i]) {
                    r[s.pop()] = i;
                } else {
                    break;
                }
            }
            s.push(i);
        }
        return r;
    }
    public int[] dailyTemperatures(int[] temperatures) {
        int[] sol = NGE(temperatures);
        for(int i=0;i<temperatures.length;i++){
            if(sol[i]==temperatures.length){
                sol[i]=0;
            }else{
                sol[i]-=i;
            }
        }
        return sol;
    }
}
