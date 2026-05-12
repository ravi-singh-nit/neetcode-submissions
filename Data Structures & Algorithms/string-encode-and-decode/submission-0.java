class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb=new StringBuilder();
        for(String s:strs){
            sb.append(s.length()+"#"+s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> ans= new ArrayList();
        for(int i=0;i<str.length();i++){
            int start=i;
            while(i<str.length() && str.charAt(i)!='#'){
                i++;
            }
            int len = Integer.parseInt(str.substring(start,i));
            String decodedStr =str.substring(i+1,i+1+len);
            ans.add(decodedStr);
            i+=len;
        
        }
        return ans;
    }
}
