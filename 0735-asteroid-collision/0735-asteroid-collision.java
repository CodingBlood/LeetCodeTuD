class Solution {
    // +--> <-- - 
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> s = new ArrayDeque<Integer>();
        for(int i=0;i<asteroids.length;i++){
            int ast = asteroids[i];
            int status=0;
            while(!s.isEmpty()){
                int top=s.peek();
                if(top>0 && ast<0){
                    if(Math.abs(ast)>top){
                        s.pop();
                    }else if(Math.abs(ast)<top){
                        status=1;//asteroid broke
                        break;
                    }else if(Math.abs(ast)==top){
                        s.pop();
                        status=1;//asteroid broke
                        break;
                    }
                }else{
                    break;
                }
            }
            if(status!=1){
                s.push(ast);
            }
        }
        int[] sol = new int[s.size()];
        for (int i = sol.length - 1; i >= 0; i--) {
            sol[i] = s.pop();
        }
        return sol;
    }
}