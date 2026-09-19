class MinStack {
    List<Integer> s = new ArrayList<>();
    List<Integer> min = new ArrayList<>();
    int i=-1;
    public MinStack() {
        i=-1;
    }
    
    public void push(int value) {
        s.add(value);
        i++;
        if(i-1>=0){
            if(min.get(i-1)<value){
                min.add(min.get(i-1));
            }else{
                min.add(value);
            }
        }else{
            min.add(value);
        }
        
    }
    
    public void pop() {
        if(i>=0){
            s.remove(i);
            min.remove(i);
            i--;
        }
    }
    
    public int top() {
        if(i>=0){
            return s.get(i);
        }
        return 0;
    }
    
    public int getMin() {
        if(i>=0){
            return min.get(i);
        }
        return 0;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */