class MedianFinder {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;
    public MedianFinder() {
        left=new PriorityQueue<>(Collections.reverseOrder());
        right=new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        left.add(num);

        right.add(left.poll());

        while(left.size() < right.size()){
            left.add(right.poll());
        }
        
    }
    
    public double findMedian() {
        if(left.size()==right.size()){
            return (left.peek()+right.peek())/2.0;
        }
        return (double)left.peek();
    }
}
