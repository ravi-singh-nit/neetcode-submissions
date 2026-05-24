class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length()<s1.length())
            return false;
        int freq[]=new int[26];
        int l=0,r=0;
        int n1=s1.length();
        for(char c:s1.toCharArray()){
            freq[c-'a']++;
        }
        int rfreq[]=new int[26];
        int n=s2.length();
        while(r<n){
            char c=s2.charAt(r);
            if(r-l+1 <= n1){
                rfreq[c-'a']++;
                r++;
            }else{
                if(check(freq,rfreq)){
                   // System.out.println("true at "+l+" "+r);
                    return true;
                }
                 //System.out.println("false at "+l+" "+r);
                rfreq[s2.charAt(l)-'a']--;
                l++;
            }
        }
        return check(freq,rfreq);
    }
    public boolean check(int a[],int b[]){
       // print(a);
       // print(b);
        for(int i=0;i<26;i++){
            if(a[i]!=b[i])
            return false;

        }
        return true;
    }
    public void print(int a[]){
        for(int i:a)
            System.out.print(i+" ");
        System.out.println();
    }
}
