class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] ans = new int[nums.length];
        for(int i = 0; i<ans.length;i++){
            ans[i] = 1;
        
        }
        int max = 1;
        for(int j = nums.length-2;j>=0;j--){
            for(int k = j;k<nums.length;k++){
                if(nums[k]>nums[j]){
                    ans[j] = Math.max(ans[k]+1,ans[j]);
                }
            }
            max = Math.max(max, ans[j]);
        }
        return max;
    }
}