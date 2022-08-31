class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(color!=image[sr][sc])
            dfs(image,sr,sc,color,image[sr][sc]);
        return image;
    }
    int[][] directions = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        
    private void dfs(int[][] img, int x, int y, int newColor, int oldColor){
        if(isValid(x,y,img) && img[x][y] == oldColor){
            img[x][y] = newColor;
            for(int[] dir : directions){    
                dfs(img,x+dir[0],y+dir[1],newColor,oldColor);
            }   
        }
    }
    private boolean isValid(int x, int y, int[][] img){
        return x>=0 && y>=0 && x<img.length && y<img[0].length;
    }
}
