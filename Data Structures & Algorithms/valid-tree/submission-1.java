class Solution {
    public boolean validTree(int n, int[][] edges) {
            Map<Integer,List<Integer>> map=new HashMap();
            for(int i=0;i<n;i++){
                map.put(i,new ArrayList());
            }

            for(int a[]:edges){
                map.get(a[0]).add(a[1]);
                map.get(a[1]).add(a[0]);
            }
            System.out.println(map);
            boolean vis[]=new boolean[n];
            for(int i=0;i<n;i++){
                if(i!=0 && vis[i]==false)
                return false;
                if(vis[i]==false){
             //       System.out.println("checking at "+i);
                    if(haveCycle(i,map,vis,-1)){
            //            System.out.println("Cycle detected from "+i);
                        return false;
                    }
                }
            }
            return true;
    }

    public boolean haveCycle(int s, Map<Integer,List<Integer>> map, boolean vis[],int p){
        
        vis[s]=true;
     //   System.out.println("visisting node "+ s);
        for(int i:map.get(s)){
            if(p==i)
            continue;
            if(vis[i]==true)
            return true;
            if(haveCycle(i,map,vis,s))
            return true;
        }

        return false;
    }

    
}
