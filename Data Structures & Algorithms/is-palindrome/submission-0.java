class Solution {
    public boolean isPalindrome(String s) {
        s=getString(s);
        s=s.toLowerCase();
        int n=s.length();
        int l=0,r=n-1;
        System.out.println(s+"-->");
        while(l<=r){
            if(s.charAt(l)!=s.charAt(r))
            return false;
            l++;
            r--;
        }
        return true;
        
    }
    public String getString(String s){
        StringBuilder sb=new StringBuilder();
        for(char c:s.toCharArray()){
            if((c>='0' &&c<='9')|| (c>='A'&&c<='Z')||(c>='a'&&c<='z')){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
