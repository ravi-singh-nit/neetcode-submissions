class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String,Map<String,Double>> map=new HashMap();
        int i=0;
        for(List<String> eq: equations){
            String a=eq.get(0);
            String b=eq.get(1);

            map.putIfAbsent(a,new HashMap());
            map.putIfAbsent(b,new HashMap());
            double val= values[i];
            map.get(a).put(b,val);
            map.get(b).put(a,1.0/val);
            i++;
        }
        double ans[]=new double[queries.size()];
        i=0;
        for(List<String> query : queries){
            String a= query.get(0);
            String b= query.get(1);

            if(!map.containsKey(a) || ! map.containsKey(b)){
                 ans[i]=-1.0;
            }else if(a.equals(b)){
                ans[i]=1.0;
            }else{
                Set<String> vis= new HashSet();
                 ans[i]=dfs(a,b,1.0,vis,map);
            }
            i++;
        }
        return ans;
    }

    public double dfs(String s,String d,double cost,Set<String> vis,Map<String,Map<String,Double>> map ){
        vis.add(s);

        if(s.equals(d))
        return cost;

        Map<String,Double> nbrs= map.get(s);

        for(Map.Entry<String,Double> me: nbrs.entrySet()){
            String nbr =me.getKey();
            double wt = me.getValue();
            if(vis.contains(nbr)==false){
                double lans =dfs(nbr,d,cost*wt,vis,map);
                if(lans!=-1.0)
                return lans;
            }
        }
        return -1.0;
    }

}