class Solution {
     int[][] directions = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    int index =0;
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<Integer>();
        int x = 0;
        int y = 0;
        dfs(x,y,matrix,ans);
        return ans;
    }
    private void dfs(int x, int y,int[][] matrix,List<Integer> ans){
        ans.add(matrix[x][y]);
        
        matrix[x][y]+=1000;
        if(ans.size() == matrix.length* matrix[0].length)
            return;
                int new_x = x + directions[index][0];
                int new_y = y + directions[index][1];
        
        if(!isValid(new_x,new_y,matrix)){
                index = (index+1)%directions.length;
                new_x = x + directions[index][0];
                new_y = y + directions[index][1];
                
        }
        dfs(new_x,new_y,matrix,ans);   
    }
    private boolean isValid(int x, int y, int[][] matrix){
        return x>=0 && y>=0 && x<matrix.length && y<matrix[0].length && Math.abs(matrix[x][y]) <= 100;
    }
}
