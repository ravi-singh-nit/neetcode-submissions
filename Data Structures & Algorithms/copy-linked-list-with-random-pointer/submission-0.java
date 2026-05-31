/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node,Node> map= new HashMap();
        Node temp=head;
        Node ans=null;
        while(temp!= null){
            map.put(temp,new Node(temp.val));
            temp=temp.next;
        }
        temp=head;
        Node newNode=null;
        while(temp!=null){
            if(ans==null){
                ans=newNode=map.get(temp);
                ans.random= map.get(temp.random);
            }else{
                newNode.next=map.get(temp);
                newNode.next.random=map.get(temp.random);
                newNode=newNode.next;
            }
            temp=temp.next;
        }
        return ans;
    }
}
