class Solution {
    public void sortColors(int[] nums) {
        int zeroes = 0;
        int twoes = nums.length-1;
        for(int i =0; i<nums.length;i++){
            if(nums[i]==0){
                nums[i] = nums[zeroes];
                nums[zeroes]=0;
                zeroes++;
            }
                       
        }
        int ones = zeroes;
        for(int j = zeroes; j<=twoes;j++){
            if(nums[j]==1){
                nums[j] = nums[ones];
                nums[ones]=1;
                ones++;
            }
        }
                       
        
    }
    private void printArr(int[] nums){
        for(int num:nums){
            System.out.print(num+" ");
        }
        System.out.println();
    }
}
