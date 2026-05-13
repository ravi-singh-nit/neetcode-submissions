class Solution {
    public boolean isValid(String s) {
        int count =0;
        Stack<Character> st= new Stack();
        for(char c: s.toCharArray()){
            if(c=='('||c=='{' || c=='[')
            st.push(c);
            else{
                if(st.isEmpty() || !isReverseOf(c,st.pop()) )
                return false;
            }
            
        }
        return st.size()==0;
        
    }

    public boolean isReverseOf(char c1,char c2){
        if(c1==')' && c2=='(')
        return true;

        if(c1=='}' && c2== '{')
        return true;

        if(c1==']' && c2=='[')
        return true;

        return false;

    }
}
