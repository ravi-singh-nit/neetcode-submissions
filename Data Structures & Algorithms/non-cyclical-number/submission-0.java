class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set=new HashSet();
        while(n!=1){
            if(set.contains(n))
            return false;
            set.add(n);
            int ssum=get(n);
            n=ssum;

        }
        return true;
    }

    public int get(int n){
        int ssum=0;
        while(n>0){
            ssum+=(n%10)*(n%10);
            n=n/10;
        }
        return ssum;
    }
}
