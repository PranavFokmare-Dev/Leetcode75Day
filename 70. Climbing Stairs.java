class Solution {
    public int climbStairs(int n) {
        return f(n);
    }
    HashMap<Integer,Integer> fMap = new HashMap<Integer,Integer>();
    private int f(int n){
        if(n <=3)return n;
        if(fMap.containsKey(n))return fMap.get(n);
        fMap.put(n,f(n-1) + f(n-2));
        return fMap.get(n);
    }
}
