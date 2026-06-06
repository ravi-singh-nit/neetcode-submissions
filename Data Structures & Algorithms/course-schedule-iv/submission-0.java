class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        boolean preReq[][]=new boolean[numCourses][numCourses];

        for(int ed[]:prerequisites){
            int u=ed[0];
            int v=ed[1];
            preReq[u][v]=true;
        }


        for(int k=0;k<numCourses;k++){
            for(int i=0;i<numCourses;i++){
                for(int j=0;j<numCourses;j++){
                    if(preReq[i][j]==false)
                    preReq[i][j]=preReq[i][k] && preReq[k][j];
                }
            }
        }

        List<Boolean> ans= new ArrayList();
        for(int i=0;i<queries.length;i++){
            ans.add(preReq[queries[i][0]][queries[i][1]]);
        }
        return ans;
    }
}