class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length())
        return false;

        Boolean dp[][]= new Boolean[s1.length()][s2.length()];
        

        return recurmemo(s1,s1.length()-1,s2,s2.length()-1,s3,s3.length()-1,dp);
    }

    public boolean recurmemo(String s1,int n1,String s2,int n2,String s3,int n3,Boolean dp[][]){
        if(n1<0 && n2<0 && n3<0)
        return true;
        if(n1 < 0){
            return s2.substring(0,n2+1).equals(s3.substring(0,n3+1));
        }

        if(n2 < 0){
            return s1.substring(0,n1+1).equals(s3.substring(0,n3+1));
        }

        if(dp[n1][n2]!=null)
        return dp[n1][n2];

        if(s1.charAt(n1)==s3.charAt(n3) && s2.charAt(n2)==s3.charAt(n3))
        return dp[n1][n2]=recurmemo(s1,n1-1,s2,n2,s3,n3-1,dp) || recurmemo(s1,n1,s2,n2-1,s3,n3-1,dp);

        if(s1.charAt(n1)==s3.charAt(n3))
        return dp[n1][n2]=recurmemo(s1,n1-1,s2,n2,s3,n3-1,dp);

        if(s2.charAt(n2)==s3.charAt(n3))
        return dp[n1][n2]=recurmemo(s1,n1,s2,n2-1,s3,n3-1,dp);

        return dp[n1][n2]=false;
    }
}
