class Solution {
    int empty = 0;
    int fresh = 1;
    int rotten = 2;
    int[][] directions = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public class Pair{
        int x;int y;
        public Pair(int x,int y){this.x = x;this.y = y;}
        public String toString(){
            return this.x+","+this.y;
        }
    }
    int totalFreshOranges = 0;
    public int orangesRotting(int[][] grid) {
        LinkedList<Pair> q = new LinkedList<Pair>();
        for(int i =0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==rotten){
                    q.addLast(new Pair(i,j));
                }
                else if(grid[i][j]==fresh)totalFreshOranges++;
            }
        }
        int secs = 0;
        while(q.size()!=0 && totalFreshOranges!=0){
            int s = q.size();
            for(int i = 0; i<s;i++){
                Pair current = q.removeFirst();
                for(int[] dir : directions){
                    int x = current.x+dir[0];
                    int y = current.y+dir[1];
                    if(isValid(grid,x,y) && grid[x][y]==fresh){
                        grid[x][y] = rotten;
                        q.addLast(new Pair(x,y));
                        totalFreshOranges--;
                    }
                }
            }
            secs++;
        }
        
        return (totalFreshOranges==0)?secs:-1;
    }
    private boolean isValid(int[][] grid, int x, int y){
        return x>=0 && y>=0 && x<grid.length && y<grid[0].length;
    }
}