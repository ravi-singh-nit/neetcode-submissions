class PrefixTree {
    Node root;

    public PrefixTree() {
         root=new Node();
    }

    public void insert(String word) {
        Node head= root;
        for(char c:word.toCharArray()){
            if(head.next[c-'a']==null){
                head.next[c-'a']=new Node();
            }
            head=head.next[c-'a'];
        }
        head.isWord=true;
    }

    public boolean search(String word) {
        Node head= root;
        for(char c:word.toCharArray()){
            if(head.next[c-'a']==null)
            return false;
            head=head.next[c-'a'];
        }
        return head.isWord;

    }

    public boolean startsWith(String prefix) {
        Node head= root;
        for(char c:prefix.toCharArray()){
            if(head.next[c-'a']==null)
            return false;
            head=head.next[c-'a'];
        }
        return true;

    }
}
class Node{
    boolean isWord;
    Node next[];

    public Node(){
        isWord=false;
        next=new Node[26];
    }
}
