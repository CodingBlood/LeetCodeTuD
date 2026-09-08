class Solution {
    class DSU{
        List<Integer> parent = new ArrayList<>();
        List<Integer> size = new ArrayList<>();
        DSU(int n){
            for(int i=0;i<n;i++){
                parent.add(i);
                size.add(1);            }
        }
        public int UP(int node){
            if(node == parent.get(node))return node;
            int ultimate_parent = UP(parent.get(node));
            parent.set(node,ultimate_parent);
            return ultimate_parent;
        }
        public void union(int u, int v){
            int uup = UP(u);
            int vup = UP(v);
            if(uup==vup)return;
            if(size.get(uup)>=size.get(vup)){
                parent.set(vup, uup);
                size.set(uup,size.get(uup)+size.get(vup));
            }else {
                parent.set(uup, vup);
                size.set(vup,size.get(uup)+size.get(vup));
            }
        }
    }
    public boolean equationsPossible(String[] equations) {
        Set<Character> set = new HashSet<Character>();
        Map<Character, Integer> hmp = new HashMap<Character, Integer>();
        for(String s: equations){
            set.add(s.charAt(0));
            set.add(s.charAt(3));
        }
        int k=0;
        for(Character c: set){
            hmp.put(c,k++);
        }
        DSU dsu = new DSU(k);
        for(String s: equations){
            if(s.charAt(1)=='='){
                int i = hmp.get(s.charAt(0));
                int j = hmp.get(s.charAt(3));
                dsu.union(i,j);
            }
        }
        // System.out.println(hmp);
        for(String s: equations){
            if(s.charAt(1)=='!'){
                int i = hmp.get(s.charAt(0));
                int j = hmp.get(s.charAt(3));
                // System.out.println(i+" : "+j);
                // System.out.println(dsu.UP(i)+" : "+dsu.UP(j));
                if(dsu.UP(i)==dsu.UP(j))return false;
            }
        }
        return true;
    }
}