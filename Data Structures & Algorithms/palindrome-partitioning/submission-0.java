class Solution {
    List<List<String>> ans;
    public List<List<String>> partition(String s) {
        ans=new ArrayList();
        List<String> list=new ArrayList();
        recursion(s,0,list);
        return ans;
    }

    public void recursion(String s,int index,List<String> list){
        if(index==s.length()){
            ans.add(new ArrayList(list));
            return;
        }

        for(int i=index;i<s.length();i++){
            if(isPal(s,index,i)){
                list.add(s.substring(index,i+1));
                recursion(s,i+1,list);
                list.remove(list.size()-1);
            }
        }
    }

    public boolean isPal(String s,int start,int end){
        while(start<end){
            if(s.charAt(start) != s.charAt(end))
            return false;
            start++;
            end--;
        }
        return true;
    }
}
