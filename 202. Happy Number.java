class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = getNext(n);
        if(fast == slow && fast == 1)return true;
        while(fast!=slow){
            slow = getNext(slow);
            fast = getNext(getNext(fast));
            if(fast == 1 || slow == 1)return true;
            
        }
        return false;
    }
    private int getNext(int n){
        int sum = 0;
        while(n>0){
            int units = n%10;
            sum+=units*units;
            n = n/10;
        }
        return sum;
    }
}
