class Solution {
    public String breakPalindrome(String palindrome) {
        if(palindrome.length()==1)return "";
        char[] palindromeArr = palindrome.toCharArray();
        boolean isSwitched = false;
        boolean isOdd = palindromeArr.length%2!=0;
        for(int i = 0; i<palindromeArr.length;i++){
            if(palindromeArr[i]!='a'){
                if(isOdd && i*2+1 == palindromeArr.length)continue;
                palindromeArr[i] = 'a';
                isSwitched = true;
                break;
            }
                
        }
        if(!isSwitched){
            palindromeArr[palindromeArr.length-1] = 'b';
        }
        return new String(palindromeArr);
    }
}