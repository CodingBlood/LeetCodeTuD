class Solution {
    class Val implements Comparable<Val>{
        int i;
        Val(int i){
            this.i=i;
        }
        @Override
        public int compareTo(Val other){
            return Integer.compare(other.i,this.i);
        }
    }
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Val> pq = new PriorityQueue<>();
        for(int i: nums){
            pq.add(new Val(i));
        }
        while(k>1){
            k-=1;
            System.out.println(pq.poll().i);
            
        }
        return pq.poll().i;
    }
}