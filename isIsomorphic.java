class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length())
            return false;
        HashMap<Character,Character> mapping = new HashMap<Character, Character>();
        HashSet<Character> isMapped = new HashSet<Character>();
        for(int i =0; i< s.length();i++){
            char l = s.charAt(i);
            char r = t.charAt(i);
            if(mapping.containsKey(l)){
                if(mapping.get(l)!=r)
                    return false;
            }
            else{
                if(isMapped.contains(r))return false;
                mapping.put(l,r);
                isMapped.add(r);
            }
        }
        return true;
    }
}
