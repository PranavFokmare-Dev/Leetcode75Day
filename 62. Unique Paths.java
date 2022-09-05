class Solution {
    public int uniquePaths(int m, int n) {
        int[][] mem = new int[m][n];
        return uniquePathsRec(m-1,n-1,mem);
    }
    private int uniquePathsRec(int x, int y,int[][] mem){
        if(x ==0 || y ==0)
            return 1;
        if(x< 0 || y <0)
            return 0;
        if(mem[x][y]!=0)return mem[x][y];
        mem[x][y] = uniquePathsRec(x,y-1,mem) + uniquePathsRec(x-1,y,mem);
        return mem[x][y];
    }
}
