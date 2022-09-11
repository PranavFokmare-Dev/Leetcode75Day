class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String,Integer> frequency  = new HashMap<String,Integer>();
        for(int i = 0; i<words.length;i++){
            frequency.put(words[i],frequency.getOrDefault(words[i],0)+1);
        }
        
        String ans = "";
        int len = 0;
        boolean oneTaken = false;
        for(Map.Entry<String,Integer> e : frequency.entrySet()){
            String word = e.getKey();
            int count = e.getValue();
            String reverseWord = reverse(word);
            if(frequency.containsKey(reverseWord)){
                int rc = frequency.get(reverseWord);
                frequency.put(word,Math.max(frequency.get(word) - Math.min(count,rc),0));
                frequency.put(reverseWord,Math.max(frequency.get(reverseWord) - Math.min(count,rc),0));
                if(reverseWord.equals(word)){
                    
                    if(count%2==1 && !oneTaken){
                        oneTaken=true;
                        len += 2 * Math.min(rc,count);
                        
                        
                    }
                    else{
                        int x = (count/2)*2;
                        len += 2 *x;
                      
                    }
                }
                else{
                 len+= 2*2*Math.min(rc,count);   
                }
            }
        }
               return len;
    }
    private String reverse(String a){
        return ""+a.charAt(1)+a.charAt(0);
    }
}
