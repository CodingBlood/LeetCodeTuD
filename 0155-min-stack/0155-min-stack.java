class MinStack {
    List<Integer> s = new ArrayList<>();
    List<Integer> min = new ArrayList<>();
    int i = -1;

    public MinStack() {
        i = -1;
    }

    public void push(int value) {
        i++;

        int currentMin = value;
        if (i > 0) {
            currentMin = Math.min(min.get(i - 1), value);
        }

        if (s.size() > i) {
            s.set(i, value);
            min.set(i, currentMin);
        } else {
            s.add(value);
            min.add(currentMin);
        }
    }

    public void pop() {
        if (i >= 0) {
            s.remove(i);
            min.remove(i);
            i--;
        }
    }

    public int top() {
        if (i >= 0) {
            return s.get(i);
        }
        return 0;
    }

    public int getMin() {
        if (i >= 0) {
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