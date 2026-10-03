class Solution {
    public boolean isPathCrossing(String path) {
        Set<String> set = new HashSet();
        int x=0,y=0;
        set.add(0+"#"+0);
        for(char c:path.toCharArray()){
            x+=getX(c);
            y+=getY(c);
            //System.out.println("("+x+","+y+")");
            if(set.add(x+"#"+y)==false)
            return true;
        }
      //  System.out.println(set);
        return false;
    }

    public int getX(char c){
        if(c=='S' || c== 'N')
        return 0;

        if(c=='E')
        return 1;

        if(c=='W')
        return -1;

        return 0;

    }

    public int getY(char c){
        if(c=='E' || c=='W')
        return 0;
        if(c=='S')
        return -1;
        if(c=='N')
        return 1;

        return 0;
    }
}