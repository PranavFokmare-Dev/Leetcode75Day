class Solution {
    public int pivotIndex(int[] nums) {
        int[] runningSum = getRunningSum(nums);
        for(int i= 0; i<nums.length;i++){
            if(isPivotIndex(i,nums,runningSum))
                return i;
        }
        return -1;
    }
    private boolean isPivotIndex(int i, int[] nums, int[] runningSum){
        int left = getSum(0,i-1,runningSum,nums);
        int right = getSum(i+1, nums.length-1,runningSum,nums);
        return left == right;
    }
    private int getSum(int start, int end, int[] runningSum,int[] nums){
        if(start<0||end>=nums.length || start>end){
            return 0;
        }
        int sumUptoStart = runningSum[start];
        int sunUptoEnd = runningSum[end];
        int x= sunUptoEnd - sumUptoStart + nums[start];
        return x;
    }
    private int[] getRunningSum(int[] nums){
        int[] ans = new int[nums.length];
        int sum = 0;
        for(int i =0; i< nums.length;i++){
            sum+=nums[i];
            ans[i] = sum;
        }
        return ans;
    }
}
