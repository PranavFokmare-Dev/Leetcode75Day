class Solution {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
    public int minCostClimbingStairs(int[] cost) {
        return Math.min(f(0,cost),f(1,cost));
    }
    private int f(int index, int[] cost){
        if(index>=cost.length)return 0;
        if(map.containsKey(index))return map.get(index);
        
        int ans = Math.min(f(index+1,cost),f(index+2,cost))+cost[index];
        map.put(index,ans);
        return map.get(index);
    }
}
