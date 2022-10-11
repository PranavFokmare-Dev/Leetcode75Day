class Solution {
    public boolean increasingTriplet(int[] nums) {
        int[] lmin = getLeftMin(nums);
        int[] rmax=getRightMax(nums);
        
        for(int i= 0; i<nums.length;i++){
            if(nums[i]>lmin[i] && nums[i]<rmax[i])return true;
        }
        return false;
    }
    private int[] getLeftMin(int[] nums){
        int min = Integer.MAX_VALUE;
        int[] ans = new int[nums.length];
        for(int i = 0; i< nums.length;i++){
            ans[i] = min;
            min = Math.min(nums[i],min);
        }
        return ans;
    }
     private int[] getRightMax(int[] nums){
        int min = Integer.MIN_VALUE;
        int[] ans = new int[nums.length];
        for(int i = nums.length-1; i>=0;i--){
            ans[i] = min;
            min = Math.max(nums[i],min);
        }
        return ans;
    }
}