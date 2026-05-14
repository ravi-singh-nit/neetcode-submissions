class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> st= new Stack();
        for(String s: tokens){
            if(isOperator(s)){
                int sec=Integer.parseInt(st.pop());
                int first=Integer.parseInt(st.pop());
                st.push(solve(first,sec,s));
            }else{
                st.push(s);
            }
        }
        return Integer.parseInt(st.pop());
    }
    public boolean isOperator(String s){
        if(s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/"))
        return true;
        return false;
    }

    public String solve(int first, int sec, String op){
        if(op.equals("+"))
        return (first+sec)+"";

        if(op.equals("*"))
        return (first*sec)+"";


        if(op.equals("/"))
        return (first/sec)+"";

        return (first-sec)+"";
    }
}
