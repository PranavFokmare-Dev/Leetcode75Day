class Solution {
    public int characterReplacement(String s, int k) {
        int ans = 0;
        for(char c = 'A'; c<='Z';c++){
            int  x= longestSameChar(s,k,c);
            ans = Math.max(x,ans);
        }
        return ans;
    }
    private int longestSameChar(String s, int k, char c){
       
        int start = 0;
        int end = 0;
        int flipped = 0;
        int maxLen =0;
        while(end < s.length()){
             
            if(s.charAt(end) == c){
                maxLen = Math.max(end-start+1,maxLen);
                end++;
            }
            else{ 
                if(flipped<k){
                    flipped++;
                    maxLen = Math.max(end-start+1,maxLen);
                    end++;
                }
                else{
                    if(s.charAt(start) != c)
                        flipped--;
                    start++;
                }
            }
           
            
        }
        return maxLen;
    }
}
