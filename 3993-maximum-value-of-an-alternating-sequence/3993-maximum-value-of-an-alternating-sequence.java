class Solution {
    public long maximumValue(int n, int s, int m) {
        long q = n/2;
        long l = 0;
          if (n == 1) {
            return s;
        }
        if(n%2==0){
            l= (n-q)-1;
        }else{
            l=(n-q)-2;
        }
        return (long) s + (m*q) - l;
    }
}