class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.equals(endWord))
            return 0;
        Set<String> set= new HashSet(wordList);
        if(!set.contains(endWord))
        return 0;
        LinkedList<String> queue=new LinkedList();
        queue.add(beginWord);
        int ans=1;
        while(queue.size()>0){
            int s=queue.size();
            while(s-->0){
                char sc[]=queue.poll().toCharArray();
                int sn= sc.length;
                for(int i=0;i<sn;i++){
                    for(int j='a';j<='z';j++){
                        char c=(char)j;
                        if(sc[i]==c)
                        continue;

                        char temp=sc[i];
                        sc[i]=c;
                        if(set.contains(String.valueOf(sc))){
                            if(endWord.equals(String.valueOf(sc)))
                            return  ans+1;
                            queue.add(String.valueOf(sc));
                            set.remove(String.valueOf(sc));

                        }
                        sc[i]=temp;
                    }
                }
            }
            ans++;
        }
        return 0;
        
    }

  
}
