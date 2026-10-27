class Solution {
    public boolean time_to_eat(int[] p, long k, long h){
        long t=0;
        for(int i=0;i<p.length;i++){
            t += (p[i] + k - 1) / k; 
            if (t > h) return false;
        }
        return t<=h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        long e = 0;
        long s = 1;
        for(int i=0;i<piles.length;i++){
            if(piles[i]>e)e=piles[i];
        }
        long sol=0;
        while(s<=e){
            long mid= s + (e - s) / 2;;
            if(time_to_eat(piles,mid,h)){
                sol=mid;
                e=mid-1;
            }else{
                s=mid+1;
            }
        }
        return (int)sol;
    }
}