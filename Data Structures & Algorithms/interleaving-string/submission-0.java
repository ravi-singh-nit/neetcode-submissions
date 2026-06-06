class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length())
        return false;

        return recurmemo(s1,s1.length()-1,s2,s2.length()-1,s3,s3.length()-1);
    }

    public boolean recurmemo(String s1,int n1,String s2,int n2,String s3,int n3){
        if(n1<0 && n2<0 && n3<0)
        return true;
        if(n1 < 0){
            return s2.substring(0,n2+1).equals(s3.substring(0,n3+1));
        }

        if(n2 < 0){
            return s1.substring(0,n1+1).equals(s3.substring(0,n3+1));
        }

        if(s1.charAt(n1)==s3.charAt(n3) && s2.charAt(n2)==s3.charAt(n3))
        return recurmemo(s1,n1-1,s2,n2,s3,n3-1) || recurmemo(s1,n1,s2,n2-1,s3,n3-1);

        if(s1.charAt(n1)==s3.charAt(n3))
        return recurmemo(s1,n1-1,s2,n2,s3,n3-1);

        if(s2.charAt(n2)==s3.charAt(n3))
        return recurmemo(s1,n1,s2,n2-1,s3,n3-1);

        return false;
    }
}
