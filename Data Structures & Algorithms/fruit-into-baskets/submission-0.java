class Solution {
    public int totalFruit(int[] fruits) {
        int l=0;
        int ans=0;
        Map<Integer,Integer> map=new HashMap();
        int n=fruits.length;
        for(int r=0;r<n;r++){
            int currFruit=fruits[r];
            map.put(currFruit,map.getOrDefault(currFruit,0)+1);
            while(map.size()>2){
                int leftFruit = fruits[l++];
                if(map.get(leftFruit)==1){
                    map.remove(leftFruit);
                }else{
                    map.put(leftFruit,map.get(leftFruit)-1);
                }
            }
            ans=Math.max(ans,r-l+1);
        }
        return ans;
    }
}