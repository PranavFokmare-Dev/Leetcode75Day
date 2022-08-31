class Solution {
    public int numIslands(char[][] grid) {
        int islands =0;
        for(int i = 0; i<grid.length;i++){
            for(int j =0;j<grid[0].length;j++){
                if(grid[i][j] == '1'){
                    islands++;
                    dfs(grid,i,j);
                }
            }
        }
        return islands;
    }
    int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    private void dfs(char[][] grid, int x, int y){
        if(isValid(grid,x,y) && grid[x][y] == '1'){
            grid[x][y] = '2';
            for(int[] dir:directions){
                dfs(grid,x+dir[0],y+dir[1]);
            }
        }
    }
    private boolean isValid(char[][] grid, int x, int y){
        return x >= 0 && y >=0 && x<grid.length && y<grid[0].length;
    }
}
