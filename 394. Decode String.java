class Solution {


    public String decodeString(String s) {
        Stack<String> st = new Stack<String>();
        for(int i = 0; i<s.length();i++){
            char c = s.charAt(i);
            if(c==']'){
                String curr = "";
                while(st.size()>0 && !st.peek().equals("[")){
                    curr = st.pop() + curr;
                }

                st.pop();//remove [

                String num  ="";
                while(st.size()>0 && isNum(st.peek())){
                    num = st.pop()+num;
                }
                int times = Integer.parseInt(num);
                String temp = curr;
                while(times-->1){
                    curr+= temp;
                }
                st.push(curr);
                
            }
            else{
                st.push(""+c);
                
            }
            //System.out.println(st);
        }
        String ans = "";
        while(st.size()>0){
            ans = st.pop() + ans;
        }
        return ans;
    }
    private boolean isNum(String x){
        return x.length() == 1 && x.charAt(0) <='9' && x.charAt(0)>='0';
    }
}
