class Solution {
    class DSU{
        List<Integer> parent = new ArrayList<>();
        List<Integer> rank   = new ArrayList<>();
        DSU(int n){
            for(int i=0;i<n;i++){
                parent.add(i);
                rank.add(0);
            }
        }
        public int UP(int node){
            if(parent.get(node)==node)return node;
            int ultimate_parent=UP(parent.get(node));
            parent.set(node,ultimate_parent);
            return ultimate_parent;
        }
        public void UnionbyRank(int u, int v){
            int uup=UP(u);
            int vup=UP(v);
            if(uup==vup)return;
            if(rank.get(uup)>=rank.get(vup)){
                parent.set(vup,uup);
                rank.set(uup, rank.get(uup)+rank.get(vup));
            }else{
                parent.set(uup,vup);
                rank.set(vup, rank.get(uup)+rank.get(vup));
            }
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> eToID   = new HashMap<String, Integer>();
        Map<String, String > eToName = new HashMap<String, String >();
        int n = accounts.size();
        int k=0;
        for(int i=0;i<n;i++){
            String name=accounts.get(i).get(0);
            for(int j=1;j<accounts.get(i).size();j++){
                String email = accounts.get(i).get(j);
                if(!eToID.containsKey(email)){
                    eToID.put(email,k++);
                    eToName.put(email,name);
                }
            }
        }
        DSU dsu = new DSU(k);
        for(int i=0;i<n;i++){
            if(accounts.get(i).size()<2)continue;
            String name = accounts.get(i).get(0);
            String fE = accounts.get(i).get(1);
            int fEId = eToID.get(fE);
            for(int j=2;j<accounts.get(i).size();j++){
                int cId = eToID.get(accounts.get(i).get(j));
                dsu.UnionbyRank(fEId,cId);
            }
        }
        HashMap<Integer,List<String>> hmp = new HashMap<>();
        for(String email: eToID.keySet()){
            int id = eToID.get(email);
            int up = dsu.UP(id);
            hmp.putIfAbsent(up, new ArrayList<>());
            hmp.get(up).add(email);
        }
        List<List<String>> mergedAccounts = new ArrayList<>();
        for (int rootId : hmp.keySet()) {
            List<String> emails = hmp.get(rootId);
            Collections.sort(emails);
            
            List<String> componentOutput = new ArrayList<>();
            String name = eToName.get(emails.get(0)); 
            componentOutput.add(name);
            componentOutput.addAll(emails);
            
            mergedAccounts.add(componentOutput);
        }

        return mergedAccounts;
    }
}