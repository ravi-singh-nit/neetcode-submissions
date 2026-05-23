class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> map=new HashMap();
        int indegree[]=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            map.put(i,new ArrayList());
        }
        for(int a[]:prerequisites){
            indegree[a[0]]++;
           map.get(a[1]).add(a[0]);
        }
        //System.out.println(map);
       // print(indegree);

        LinkedList<Integer> queue=new LinkedList();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }

        if(queue.size()==0)
        return false;

        while(queue.size()>0){
            int curr =queue.poll();
            for(int i:map.get(curr)){
                indegree[i]--;
                if(indegree[i]==0){
                    queue.add(i);
                }
            }
        }
        for(int i:indegree){
            if(i!=0)
            return false;
        }
        return true;


    }

    public void print(int a[]){
        for(int i:a)
            System.out.print(i+" ");
        System.out.println();
    }
}
