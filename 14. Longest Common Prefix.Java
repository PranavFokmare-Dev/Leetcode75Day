class Solution {
    public String longestCommonPrefix(String[] strs) {
        String smallestString = getSmallestString(strs);
        return lasrgestCommonPrefix(smallestString,strs);
    }
    private String getSmallestString(String[] sarr){
        String ans = "";
        int minLen = Integer.MAX_VALUE;
        for(String s : sarr){
            if(s.length()<minLen){
                ans = s;
                minLen = s.length();
            }
        }
        return ans;
    }
    private String lasrgestCommonPrefix(String smallestString,String[] sarr){
        int start = 0;
        int end = smallestString.length()-1;
        int index = -1;
        while(start<=end){
            int mid = (end+start)/2;
            if(allStringStartsWith(smallestString.substring(0,mid+1),sarr)){
                index = mid;
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        if(index==-1)return "";
        return smallestString.substring(0,index+1);
    }
    private boolean allStringStartsWith(String prefix, String[] sarr){
        for(String s : sarr){
            if(!s.startsWith(prefix)){
                return false;
            }
        }
        return true;
    }
}
