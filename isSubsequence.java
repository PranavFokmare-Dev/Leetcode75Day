class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length()>t.length())
            return false;
        int i = 0;int j= 0;
        while(i<s.length() && j<t.length()){
            while(j<t.length() && t.charAt(j)!=s.charAt(i))
                j++;
            if(j>=t.length())return false;
            i++;
            j++;
        }
        return i == s.length();
        
    }
}

//Recursive approace

/*
class Solution {
    public boolean isSubsequence(String s, String t) {
        return isSubsequence(s,t,0,0);
    }
    private boolean isSubsequence(String s, String t, int i, int j){

        if(s.length() - i > t.length() - j)
            return false;
        if(i == s.length())return true;
        
        if(s.charAt(i) == t.charAt(j)){
            return isSubsequence(s,t,i+1,j+1);
        }    
        else{
            return isSubsequence(s,t,i,j+1);
        }
    }
}
*/
