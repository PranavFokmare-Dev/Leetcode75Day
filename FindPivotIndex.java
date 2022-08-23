class Solution {
    public int pivotIndex(int[] nums) {
        int sum = sumOf(nums);
        int leftSum = 0;
        for(int i= 0;i<nums.length;i++){
            int rightSum = sum - leftSum - nums[i];
            if(leftSum == rightSum)
                return i;
            leftSum+=nums[i];
        }
        return -1;
    }
    private int sumOf(int[] nums){
        int sum =0;
        for(int i =0; i< nums.length;i++){
            sum+=nums[i];
        }
        return sum;
    }
   
}
