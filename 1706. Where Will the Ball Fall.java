class Solution {
    //hard simulation approach
    //try removing the grid in reaches bottom
        int left = 0; int down = 1; int right = 2;
    int visited = 100;
    public int[] findBall(int[][] grid) {
        int[][] transform =transformMatrix(grid);
        int[] ans= new int[grid[0].length];
        for(int i=0;i<ans.length;i++){
            if(grid[0][i] == 1){
                ans[i]= reachesBottom(transform,0,2*i+1,grid);
            }
            else{
                ans[i] = reachesBottom(transform,0,2*i,grid);
            }
        }
        return ans;
    }
    private int reachesBottom(int[][] transform, int x, int y,int[][] grid){
        //System.out.println(x+" "+y);
        while(isValid(x,y,transform) && !isVisited(x,y,transform)){
            
            int[] cords = getNewCords(x,y,transform,grid);
            transform[x][y] = visited;
            x = cords[0];
            y = cords[1];
            //System.out.println(x+" "+y);
            if(x == transform.length)
            {
                //System.out.println("ANS"+x+" "+y);
                 return y/2;
            }   
        }
        return -1;
        
    }
    private boolean isValid(int x, int y, int[][] grid){
        return x>=0 && y>=0 && x<grid.length && y<grid[0].length;
    }
    private boolean isVisited(int x, int y, int[][] grid){
        return grid[x][y] == visited;
    }
    private int[] getNewCords(int x, int y,int[][]transform,int[][] grid){
        //System.out.println("(((())))"+transform[x][y]);
        if(transform[x][y] == left)
                return new int[]{x,y-1};
        if(transform[x][y] == right)
                return new int[]{x,y+1};
        if(transform[x][y]== down)
        {
            int newY = y;
            if(x+1<grid.length){
                newY = y + grid[x+1][y/2];
            }
                return new int[]{x+1,newY};
        }
            
        return new int[]{x,y};
    }
    private int[][] transformMatrix(int[][] grid){
        int[][] transform = new int[grid.length][grid[0].length*2];
        for(int i = 0; i< grid.length;i++){
            for(int j = 0; j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    transform[i][2*j]=down;
                    transform[i][2*j+1]=right;
                }
                else{
                    transform[i][2*j]=left;
                    transform[i][2*j+1]=down;
                }
            }
        }
        return transform;
    }
}
