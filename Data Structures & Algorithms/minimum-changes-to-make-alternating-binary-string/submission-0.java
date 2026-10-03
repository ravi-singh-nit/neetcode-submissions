class Solution {
    public int minOperations(String s) {
        int curr=0;
        int count1=0;
        for(char c:s.toCharArray()){
            int cval=c-'0';
            if(curr != cval){
                count1++;
            }
            curr^=1;
        }


        int count2=0;
        curr=1;
        for(char c:s.toCharArray()){
            int cval = c -'0';
            if(curr !=cval){
                count2++;
            }
            curr^=1;
        }

        return Math.min(count1,count2);

    }
}