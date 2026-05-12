class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList();
        Map<String,List<String>> map= new HashMap();
        for(String s: strs){
            char charArray[]=s.toCharArray();
            Arrays.sort(charArray);
            String sorted = String.valueOf(charArray);
            if(map.containsKey(sorted)){
                map.get(sorted).add(s);
            }else{
                List<String> list= new ArrayList();
                list.add(s);
                map.put(sorted,list);
            }
        }
        for(Map.Entry<String,List<String>> entry: map.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }
}
