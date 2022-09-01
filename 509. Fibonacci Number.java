class Solution {
    HashMap<Integer,Integer> fibMap = new HashMap<Integer,Integer>();
    public int fib(int n) {
        if(n ==0||n==1)
            return n;
        if(fibMap.containsKey(n))return fibMap.get(n);
        int ans = fib(n-1)+fib(n-2);
        fibMap.put(n,ans);
        return ans;
    }
    
}
