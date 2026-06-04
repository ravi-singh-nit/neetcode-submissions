class Solution {
    public String foreignDictionary(String[] words) {
      Map<Character,List<Character>> map=new HashMap();
      Map<Character,Integer> indegree= new HashMap();
      int n=words.length;

      for(String s:words){
        for(char c:s.toCharArray()){
            map.putIfAbsent(c, new ArrayList());
            indegree.putIfAbsent(c,0);
        }
      }

      for(int i=0;i<n-1;i++){
        String s1=words[i];
        String s2=words[i+1];

        if(s1.length() > s2.length() && s1.startsWith(s2))
        return "";


        for(int j=0;j<s1.length();j++){
            if(s1.charAt(j)!=s2.charAt(j)){
                char u=s1.charAt(j);
                char v=s2.charAt(j);
                map.get(u).add(v);
                indegree.put(v,indegree.get(v)+1);
                break;
            }
        }
      }

      LinkedList<Character> queue= new LinkedList<>();
    
      for(char c: indegree.keySet()){
        if(indegree.get(c)==0){
            queue.add(c);
        }
      }
      StringBuilder sb = new StringBuilder();
     
      while(queue.size()>0){
        char curr= queue.poll();
        sb.append(curr);
        for(char nbr:map.get(curr)){
            indegree.put(nbr,indegree.get(nbr)-1);
            if(indegree.get(nbr)==0){
                queue.add(nbr);
            }
        }
      }
      //return sb.toString();
      return sb.length() == indegree.size() ? sb.toString() : "";
    }
}
