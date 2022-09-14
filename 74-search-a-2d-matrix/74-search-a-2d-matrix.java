class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int index = findInFictional(matrix,target);
        if(index==-1)return false;
        return getElement(index,matrix) == target;
    }
    private int findInFictional(int[][] matrix, int target){
        int start = 0;
        int end = matrix.length*matrix[0].length-1;
        while(start<=end){
            int mid = end-((end-start)/2);
            int curr = getElement(mid,matrix);
            if(curr==target){
                return mid;
            }
            else if(curr<target){
                start = mid+1;
            }
            else{
                end = mid -1;
            }
            
        }
        return -1;
    }
    private int getElement(int x, int[][] matrix){
        int row = x/matrix[0].length;
        int column = x%matrix[0].length;
        return matrix[row][column];
    }
}