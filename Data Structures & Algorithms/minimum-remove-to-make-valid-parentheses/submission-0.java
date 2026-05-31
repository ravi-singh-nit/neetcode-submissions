class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> st= new Stack();
        Set<Integer> set=new HashSet();
        int n=s.length();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='('){
                st.push(i);
            }else if(ch==')'){
                if(st.size()==0){
                    set.add(i);
                }else{
                    st.pop();
                }
            }
        }
        while(st.size()>0)
        set.add(st.pop());

        StringBuilder sb= new StringBuilder();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='(' || ch==')'){
                if(!set.contains(i)){
                    sb.append(ch);
                }
            }else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}