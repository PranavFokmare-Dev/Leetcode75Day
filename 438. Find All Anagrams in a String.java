class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> ans =new ArrayList<Integer>();
        if(p.length()>s.length())
        {
          return ans;
        }
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for(int i =0;i<p.length();i++){
            pCount[p.charAt(i)-'a']++;
            sCount[s.charAt(i)-'a']++;
        }
        int start = 0;
        for(int j = p.length()-1;j<s.length();){
            if(areEqual(sCount,pCount)){
                ans.add(start);
            }
            
            sCount[s.charAt(start)-'a']--;
            start++;
            j++;
            if(j<s.length())
            sCount[s.charAt(j)-'a']++;
        }
        return ans;
    }
    private boolean areEqual(int[] x, int[]y){
        for(int i =0; i<x.length;i++){
            if(x[i]!=y[i])
                return false;
        }
        return true;
    }
    
}
