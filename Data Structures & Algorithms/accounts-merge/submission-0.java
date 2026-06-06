class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String,Integer> emailToid=new HashMap();
        DSU dsu = new DSU(accounts.size());
        for(int i=0;i<accounts.size();i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String email=accounts.get(i).get(j);
                if(emailToid.containsKey(email)){
                    dsu.union(emailToid.get(email),i);
                }else{
                    emailToid.put(email,i);
                }

            }
        }

        Map<Integer,List<String>> idToList=new HashMap();
        for(Map.Entry<String,Integer> me: emailToid.entrySet()){
            String email=me.getKey();
            int group= dsu.find(me.getValue());
            if(idToList.containsKey(group)==false)
            idToList.put(group,new ArrayList());
            idToList.get(group).add(email);
        }

        List<List<String>> ans= new ArrayList();

        for(Map.Entry<Integer,List<String>> me: idToList.entrySet()){
            String person=accounts.get(me.getKey()).get(0);
            List<String> curr = new ArrayList();
            curr.add(person);
            curr.addAll(me.getValue());
            ans.add(curr);
        }
        return ans;
        
    }
}

class DSU{
    int par[];
    int rank[];

    public DSU(int n){
        par=new int[n];
        rank=new int[n];

        for(int i=0;i<n;i++){
            par[i]=i;
            rank[i]=1;
        }
    }

    public int find(int x){
        if(x==par[x])
        return par[x];

        return par[x]=find(par[x]);
    }


    public boolean union(int x,int y){
        int px=find(x);
        int py=find(y);

        if(px==py)
        return false;


        if(rank[px]>rank[py]){
            par[py]=px;
        }else if(rank[py]>rank[px]){
            par[px]=py;
        }else{
            par[px]=py;
            rank[py]++;
        }
        return true;
    }
}