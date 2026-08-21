class Solution {
    public int[] nse(int[] arr){
        Deque<Integer> s = new ArrayDeque<Integer>();
        int[] sol = new int[arr.length];
        Arrays.fill(sol, arr.length);
        for(int i=arr.length-1;i>=0;i--){
            while(!s.isEmpty()){
                if(arr[s.peek()]<arr[i]){
                    sol[i]=s.peek();
                    break;
                }else{
                    s.pop();
                }
            }
            s.push(i);
        }
        return sol;
    }
    public int[] pse(int[] arr){
        Deque<Integer> s = new ArrayDeque<Integer>();
        int[] sol = new int[arr.length];
        Arrays.fill(sol, -1);
        for(int i=0;i<arr.length;i++){
            while(!s.isEmpty()){
                if(arr[s.peek()]<=arr[i]){
                    sol[i]=s.peek();
                    break;
                }else{
                    s.pop();
                }
            }
            s.push(i);
        }
        return sol;
    }
    public int sumSubarrayMins(int[] arr) {
        int[] nse = nse(arr);
        int[] pse = pse(arr);
        long mod = 1000000007;
        long sum=0;
        for(int i=0;i<arr.length;i++){
            // System.out.println(arr[i] + " n : " + nse[i] + " p : " + pse[i]);
            long left = (i-pse[i]);
            long right = (nse[i]-i);
            long c=(((left*right)%mod)*arr[i])%mod;
            sum=(sum+c)%mod;
            // System.out.println((i-pse[i]) + " * " + (nse[i]-i) + " sum : " + sum);
        }
        return (int)sum;
    }
}