class Solution {
    // + = -->   - = <---
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i: asteroids){
            int status=1; // 1-> quiet 0-> explosion
            while(!stack.isEmpty()){
                int top = stack.pop();
                if((top>0 && i<0)){
                    if(Math.abs(top)>Math.abs(i)){
                        stack.push(top);
                        status=0;
                        break;
                    }
                    if(Math.abs(top)==Math.abs(i)){
                        status=0;
                        break;
                    }
                }else{
                    stack.push(top);
                    break;
                }
            }
            if(status!=0){
                stack.push(i);
            }
        }
        int[] sol = new int[stack.size()];
        for(int i=stack.size()-1;i>=0;i--){
            sol[i]=stack.pop();
        }
        return sol;
    }
}