class LRUCache {
    Node head;
    Node tail;
    int capacity;
    Map<Integer,Node> map;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        map=new HashMap();
        head=new Node(-1,-1);
        tail=new Node(-1,-1);
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            int ans=map.get(key).value;
            removeAndAddtoHead(key);
            return ans;
        }
        return -1; 
    }
    public void removeAndAddtoHead(int key){
        Node existing=map.get(key);
        remove(existing);
        addToHead(existing);

    }

    public void remove(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }

    public void addToHead(Node node){
        node.next=head.next;
        head.next.prev=node;
        node.prev=head;
        head.next=node;
    }
    
    public void put(int key, int value) {
        System.out.println(map.size()+" "+capacity+" "+key+" "+value);
        if(map.containsKey(key)){
            Node exit=map.get(key);
            exit.value=value;
            remove(exit);
            addToHead(exit);
        }else{
            if(map.size()==capacity){
                map.remove(tail.prev.key);
                remove(tail.prev);
            }
            Node newNode=new Node(key,value);
            map.put(key,newNode);
            addToHead(newNode);
        }
        
    }
}

class Node{
    Node prev;
    Node next;
    int key;
    int value;
    public Node(int key,int value){
        this.key=key;
        this.value=value;
    }
}
