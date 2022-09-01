class Solution {
    public int climbStairs(int n) {
        int[] ans = new int[n+3];
        ans[0] = 0;
        ans[1] = 1;
        ans[2] = 2;
        for(int i = 3;i<ans.length;i++){
            ans[i] = ans[i-1]+ans[i-2];
        }
        return ans[n];
    }
    HashMap<Integer,Integer> fMap = new HashMap<Integer,Integer>();
    private int f(int n){
        if(n <=3)return n;
        if(fMap.containsKey(n))return fMap.get(n);
        fMap.put(n,f(n-1) + f(n-2));
        return fMap.get(n);
    }
}
