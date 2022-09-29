class Solution {
    public int longestValidParentheses(String s) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        Stack<Integer> st = new Stack<Integer>();
        for(int i = 0; i<s.length();i++){
            if(s.charAt(i) == '(')
            {
                st.push(i);
            }
            else{
                if(st.size()==0)continue;
                int index = st.pop();
                addToMerge(index, i, ans);
            }
            
        }
      System.out.println(ans);
       return getAns( merget(ans));
        
    }
    private void addToMerge(int start, int end, ArrayList<ArrayList<Integer>> ans){
        if(ans.size()==0){
            ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.add(start);
                temp.add(end);
                ans.add(temp);
        }
        else{
            int lastIndex = ans.size()-1;
            ArrayList<Integer> lastInterval = ans.get(lastIndex);
            if(lastInterval.get(1) +1 == start){
                lastInterval.set(1,end);
            }
            else if(lastInterval.get(0)>= start && lastInterval.get(1) <= end){
                lastInterval.set(0,start);
                lastInterval.set(1,end);
            }
            else{
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.add(start);
                temp.add(end);
                ans.add(temp);
            }
        }
        
    }
    private ArrayList<ArrayList<Integer>> merget(ArrayList<ArrayList<Integer>> ip){
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(ip.size()==0)return result;
        Collections.sort(ip,(a,b)->{return a.get(0)-b.get(0);});
        ArrayList<Integer> interval = ip.get(0);
        result.add(interval);
        for(int i = 1; i<ip.size();i++){
            int a = interval.get(0);
            int b = interval.get(1);
            int x= ip.get(i).get(0);
            int y = ip.get(i).get(1);
            
             if(b + 1 == x){
                interval.set(1,y);
            }
            else if(x<=b && x>=a){
                interval.set(1,Math.max(b,y));
            }
            else{
                result.add(ip.get(i));
                interval = ip.get(i);
            
            }

        }
        System.out.println(result);
        return result;
    }
    private int getAns( ArrayList<ArrayList<Integer>> ans){
        int max = 0;
        for(int i = 0; i<ans.size();i++){
            max = Math.max(ans.get(i).get(1)-ans.get(i).get(0)+1, max);
        }
        return max;
    }

}