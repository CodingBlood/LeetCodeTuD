class LRUCache {
    class Node {
        Node left, right;
        private int value, key;

        Node(int value, int key, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public int getvalue() {
            return value;
        }
        public void setvalue(int value) {
            this.value=value;
        }

        public int getkey() {
            return key;
        }
    }

    Node MRU = null;
    Node LRU = null;
    private int capacity, size = 0;
    Map<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Node current = map.get(key);
        if (current == null)return -1;
        if (current == MRU)return current.getvalue();
        if (current == LRU)LRU = current.left;
        if (current.left != null)current.left.right = current.right;
        if (current.right != null) current.right.left = current.left;
        current.left = null;
        current.right = MRU;
        if (MRU != null)MRU.left = current;
        MRU = current;
        return current.getvalue();
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.get(key).setvalue(value);
            get(key);
            return;
        }
        
        if (MRU == null) {
            Node nw = new Node(value, key, null, null);
            MRU = nw;
            LRU = nw;
            size=1;
            map.put(key, nw);
        } else {
            Node nw = new Node(value, key, null, MRU);
            map.put(key, nw);
            MRU.left = nw;
            MRU = nw;
            size++;
            if (size > capacity) {
                map.remove(LRU.getkey());
                LRU = LRU.left;
                if (LRU != null) { 
                    LRU.right = null;
                }
                size--;
            }
        }
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */