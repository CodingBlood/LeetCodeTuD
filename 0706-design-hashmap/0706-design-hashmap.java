class MyHashMap {
    int noOfBuckets = 10000;
    List<List<int[]>> buckets;
    public MyHashMap() {
        buckets = new ArrayList<>();
        for(int i=0;i<noOfBuckets;i++){
            buckets.add(new ArrayList<>());
        }
    }
    public int hash(int key){
        return key%noOfBuckets;
    }
    public void put(int key, int value) {
        List<int[]> currentBucket = buckets.get(hash(key));
        for(int[] pair:currentBucket){
            if(pair[0]==key){
                pair[1]=value;
                return;
            }
        }
        currentBucket.add(new int[]{key,value});
    }
    
    public int get(int key) {
        List<int[]> currentBucket = buckets.get(hash(key));
        for(int[] pair:currentBucket){
            if(pair[0]==key){
                return pair[1];
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        List<int[]> currentBucket = buckets.get(hash(key));
        currentBucket.removeIf(pair -> pair[0] == key);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */