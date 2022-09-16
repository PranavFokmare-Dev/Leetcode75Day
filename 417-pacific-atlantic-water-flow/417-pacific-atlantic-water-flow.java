class Solution {
    int[][] dirs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        boolean[][] pv = new boolean[m][n];
        boolean[][] av = new boolean[m][n];
        for(int i = 0; i < n; i++){
            dfs(heights, pv, 0, i);
            dfs(heights, av, m-1, i);
        }
        for(int i = 0; i < m; i++){
            dfs(heights, pv, i, 0);
            dfs(heights, av, i, n-1);
        }
        List<List<Integer>> l = new ArrayList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(pv[i][j] && av[i][j]) l.add(Arrays.asList(i,j));
            }
        }
        return l;
    }
    
    private void dfs(int[][] hs, boolean[][] v, int row, int col){
        v[row][col] = true;
        for(int i = 0; i < 4; i++){
            int r = row + dirs[i][0];
            int c = col + dirs[i][1];
            if(r >= 0 && r < hs.length && c >= 0 && c < hs[0].length && hs[r][c] >= hs[row][col] && !v[r][c]){
                dfs(hs, v, r, c);
            }
        }
    }
}