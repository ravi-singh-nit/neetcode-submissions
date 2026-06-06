class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet();

        Queue<String> queue=new LinkedList();
        queue.add("0000");
        if(target.equals("0000"))
        return 0;
        Set<String> vis= new HashSet(Arrays.asList(deadends));
        if(vis.contains(target) || vis.contains("0000"))
        return -1;
        vis.add("0000");

        int ans=0;
        while(queue.size()>0){

            int s=queue.size();
            while(s-->0){
                String curr= queue.poll();

                for(int k=0;k<4;k++){
                    char c=curr.charAt(k);
                    
                    char upChar = (c == '9') ? '0' : (char) (c + 1);
                    String up = curr.substring(0, k) + upChar + curr.substring(k + 1);
                    
                    char downChar = (c == '0') ? '9' : (char) (c - 1);
                    String down = curr.substring(0, k) + downChar + curr.substring(k + 1);


                    if(up.equals(target) || down.equals(target))
                    return ans+1;
                    if(!vis.contains(up)){
                        vis.add(up);
                        queue.add(up);
                    }

                    if(!vis.contains(down)){
                        vis.add(down);
                        queue.add(down);
                    }

                }
            }
            ans++;
        }

        return -1;
    }
}