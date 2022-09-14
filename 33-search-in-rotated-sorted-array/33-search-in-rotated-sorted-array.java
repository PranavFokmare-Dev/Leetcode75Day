class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 1){
            return (nums[0]==target)?0:-1;
        }
      
        if(nums.length == 2){
            if(nums[0]==target)
                return  (nums[0]==target)?0:-1;
            return (nums[1]==target)?1:-1;
        }
        int pivotIndex = findMin(nums);
        if(nums[pivotIndex] == target)
            return pivotIndex;
        if(pivotIndex == 0){
            return findIn(target,nums,0, nums.length-1);
        }
        if(nums[0] <= target && nums[pivotIndex-1]>=target){
           return findIn(target,nums, 0, pivotIndex-1);
        }
        return findIn(target,nums, pivotIndex, nums.length - 1);
    }
    private int findMin(int[] nums){
        int start = 0;
        int end = nums.length - 1;
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        while(start <= end){
            int mid = (end + start)/2;
            if(isMinimum(mid,nums)){
                return mid;
            }
            if(nums[mid] < nums[end]){
                end = mid - 1;
            }
            else{
                start = mid+1;
            }
        }
        return -1;
    }
    private boolean isMinimum(int mid, int[] nums){
        int prev = (mid + nums.length - 1)%nums.length;
        int next = (mid + 1)%nums.length;
        if(nums[mid]<=nums[prev] && nums[mid]<=nums[next])
            return true;
        return false;
    }
    private int findIn(int target,int[] nums, int start, int end){
        while(start<=end){
            int mid = (start + end)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if( nums[mid] > target)
                end = mid -1;
            else
                start = mid+1;
        }   
        return -1;
    }
}