class Solution {

    class Notepad{
        String s;
        int i;
        public Notepad(String s){
            this.s  = s;
            i = s.length()-1;
        }
        public char getChar(){
            int bs = 0;
            while(i>=0){
                if(s.charAt(i) == '#'){
                    bs++;
                    i--;
                }
                else{
                    if(bs>0){
                        i--;
                        bs--;
                    }
                    else{
                        char x = s.charAt(i);
                        i--;
                        return x;
                    }
                }
            }
            return '-';
        }
        public boolean hasNext(){
            return i>=0;
        }
    }
    
    public boolean backspaceCompare(String s, String t) {
        Notepad sn = new Notepad(s);
        Notepad tn = new Notepad(t);
        while(sn.hasNext() && tn.hasNext()){
            if(sn.getChar() != tn.getChar())
                return false;
        }
        if(sn.hasNext()){
            return sn.getChar() == '-';
        }
        if(tn.hasNext()){
            return tn.getChar() == '-';
        }
        return true;
    }
}
