class Solution {
    public int maxProfit(int[] prices) {
        int cp = prices[0];
        int sp = -1;
        int profit = 0;
        for(int i = 0; i< prices.length -1;i++){
            if(prices[i+1]<prices[i] && cp>prices[i+1]){
                    cp = prices[i+1];
                    sp = cp;
            }
            else{
                sp = prices[i+1];
            }
            profit = Math.max(profit, sp-cp);
        }
        return profit;
    }
}
