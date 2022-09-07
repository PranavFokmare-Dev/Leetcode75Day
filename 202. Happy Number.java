class Solution {
    HashSet<Integer> visited = new HashSet<Integer>();
    public boolean isHappy(int n) {
        if(visited.contains(n))return false;
        visited.add(n);
        int sum = sumOfSquaresOfEachDigit(n);
        if(sum == 1)
            return true;
        return isHappy(sum);
    }
    private int sumOfSquaresOfEachDigit(int n){
        int sum = 0;
        while(n>0){
            int units = n%10;
            sum+=units*units;
            n = n/10;
        }
        return sum;
    }
}
