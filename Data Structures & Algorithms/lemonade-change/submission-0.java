class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five=0,ten =0,twen=0;
        for(int i:bills){
            if(i==5){
                five++;
                continue;
            }

            if(i==10 ){
                if(five<=0)
                return false;
                five--;

                ten++;
                continue;
            }
            if(i==20){
                if(five<=0)
                return false;
                if(ten >0 ){
                    five--;
                    ten--;
                    continue;
                }

                if(five < 3)
                return false;
                
                five-=3;
                continue;

            }
            return false;
        }
        return true;
    }
}