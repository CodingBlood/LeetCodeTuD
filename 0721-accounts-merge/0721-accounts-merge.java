class Solution {
    class DisjointSet{
        int[] parent,size;
        public DisjointSet(int n){
            parent = new int[n];
            size = new int[n];
            for(int i=0;i<n;i++){
                parent[i]=i;
                size[i]=1;
            }
        }
        public int ultimateParent(int i){
            if(parent[i]!=i){
                parent[i] = ultimateParent(parent[i]);
                return parent[i];
            }
            return i;
        }

        public void Union(int i, int j){
            int rooti = ultimateParent(i);
            int rootj = ultimateParent(j);
            if(rooti!=rootj){
                int ranki = size[rooti];
                int rankj = size[rootj];
                if(ranki>=rankj){
                    parent[rootj]=rooti;
                    size[rooti]+=size[rootj];
                }else{
                    parent[rooti]=rootj;
                    size[rootj]+=size[rooti];
                }
            }
        }
        public int[] parent(){
            return parent;
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, Integer> eToId = new HashMap<>();
        HashMap<String, String> eToName = new HashMap<>();
        int k=0;
        for(List<String> account: accounts){
            String name = account.get(0);
            for(int j=1;j<account.size();j++){
                String email = account.get(j);
                if(!eToId.containsKey(account.get(j))){
                    eToId.put(email,k++);
                    eToName.put(email,name);
                }
                
            }            
        }
        DisjointSet DSU = new DisjointSet(k);
        for(List<String> acc : accounts){
            if(acc.size()<2)continue;
            String name = acc.get(0);
            String fE = acc.get(1);
            int fId = eToId.get(fE);
            for(int j=2;j<acc.size();j++){
                String nE = acc.get(j);
                int nId = eToId.get(nE);
                DSU.Union(fId,nId);
            }
        }

        HashMap<Integer,List<String>> hmp = new HashMap<>();
        for(String email: eToId.keySet()){
            int id = eToId.get(email);
            int up = DSU.ultimateParent(id);
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