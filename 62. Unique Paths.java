class Solution {
    public int uniquePaths(int m, int n) {
        int[][] mem = new int[m][n];
        for(int r = 0; r<m;r++){
            mem[r][0] = 1;
        }
        for(int c = 0;c<n;c++){
            mem[0][c] = 1;
        }
        for(int i=1; i< m;i++){
            for(int j =1;j<n;j++ ){
                mem[i][j] = mem[i-1][j]+mem[i][j-1];
            }
        }
        return mem[m-1][n-1];
    }
}
