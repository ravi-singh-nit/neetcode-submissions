class WordDictionary {
    Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node head= root;
        for(char c:word.toCharArray()){
            if(head.next[c-'a']==null){
                head.next[c-'a']=new Node();
            }
            head= head.next[c-'a'];
        }
        head.isWord=true;
    }

    public boolean search(String word) {
        Node head= root;
        int index=0;
        for(char c:word.toCharArray()){
            if(c=='.'){
                for(int i=0;i<26;i++){
                    if(head.next[i]!=null){
                        if(search(word.substring(index+1),head.next[i]))
                        return true;
                    }
                }
                return false;
            }else if(head.next[c-'a']==null){
                return false;
            }else{
                head=head.next[c-'a'];
            }
            index++;
        }
        return head.isWord;
    }
    public boolean search(String word,Node head){
        if(word.length()==0)
        return head.isWord;
        int index=0;
        for(char c:word.toCharArray()){
            if(c=='.'){
                for(int i=0;i<26;i++){
                    if(head.next[i]!=null){
                        if(search(word.substring(index+1),head.next[i]))
                        return true;
                    }
                }
                return false;
            }else if(head.next[c-'a']==null){
                return false;
            }else{
                head=head.next[c-'a'];
            }
            index++;
        }
        return head.isWord;
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
