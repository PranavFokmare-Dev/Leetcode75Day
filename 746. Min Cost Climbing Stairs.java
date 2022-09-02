class Solution {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
    public int minCostClimbingStairs(int[] cost) {
        int x = 0;
        int y = 0;
        for(int i = 2; i<cost.length+1;i++){
            int temp = Math.min(y+cost[i-1],x+cost[i-2]);
            x = y;
            y = temp; 
        }
        return y;
    }
}
