class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] pre = new int[nums.length];
        pre[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            pre[i]=pre[i-1]+nums[i];
        }
        HashMap<Integer,Integer> mp = new HashMap<Integer,Integer>();
        mp.put(0,1);
        int cnt=0;
        for(int i=0;i<pre.length;i++){
            if(mp.containsKey(pre[i]-k)){
                cnt+=mp.get(pre[i]-k);
                mp.put(pre[i], mp.getOrDefault(pre[i],0)+1);
            }else{
                mp.put(pre[i], mp.getOrDefault(pre[i],0)+1);
            }
        }
        return cnt;
    }
}

