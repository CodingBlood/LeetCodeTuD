class MyHashMap {
    int[] map;
    int MOD=1000000;
    public MyHashMap() {
        map = new int[MOD];
        Arrays.fill(map,-1);
    }
    
    public void put(int key, int value) {
        map[key%MOD]=value;
    }
    
    public int get(int key) {
        return map[key%MOD];
    }
    
    public void remove(int key) {
        map[key%MOD]=-1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */