class Solution {
    public void rotate(int[][] matrix) {
        int m=matrix.length;
        transpose(matrix,m,m);
        rowReverse(matrix,m);
    }

    public void transpose(int grid[][],int m, int n){
        for(int d=0;d<m;d++){
            for(int i=d,j=0 ;j<d;j++){
                int temp=grid[i][j];
                grid[i][j]=grid[j][i];
                grid[j][i]=temp;
            }
        }

    }

    public void rowReverse(int grid[][],int m){
        int l,r;
        for(int i=0;i<m;i++){
            l=0;
            r=m-1;
            while(l<r){
                int temp=grid[i][l];
                grid[i][l]=grid[i][r];
                grid[i][r]=temp;
                l++;
                r--;
            }
        }
    }
}
