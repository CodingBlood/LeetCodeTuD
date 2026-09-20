class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> s = new ArrayDeque<Integer>();
        for(int i=0;i<tokens.length;i++){    
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")){
                int b = s.pop();
                int a = s.pop();
                if(tokens[i].equals("+")){
                    s.push(a+b);
                }else if(tokens[i].equals("-")){
                    s.push(a-b);
                }else if(tokens[i].equals("*")){
                    s.push(a*b);
                }else{
                    s.push(a/b);
                }
            }else{
                s.push(Integer.parseInt(tokens[i]));
            }
        }
        return s.pop();
    }
}