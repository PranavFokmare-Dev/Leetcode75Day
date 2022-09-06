class Solution {
    //1st problem 
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[]{-1,-1};
        HashMap<Integer,Integer> indexOf = new HashMap<Integer,Integer>();
        for(int i = 0; i<nums.length;i++){
            if(indexOf.containsKey(target-nums[i]))
            {
                return new int[]{indexOf.get(target-nums[i]),i};
            }
            indexOf.put(nums[i],i);
        }
        return ans;
    }
}
