class MedianFinder {
    int n;
    List<Integer> nums;
    public MedianFinder() {
        n=0;
        nums=new ArrayList();
    }
    
    public void addNum(int num) {
        n++;
        nums.add(num);
    }
    
    public double findMedian() {
        Collections.sort(nums);
        if(n%2==0){
            int sum= nums.get(n/2-1)+nums.get(n/2);
            return sum/(1.0*2);
        }else{
            return (double)nums.get(n/2);
        }
        
    }
}
