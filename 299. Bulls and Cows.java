class Solution {
    public String getHint(String secret, String guess) {
        int x = 0;
        int total = 0;
        int[] gcount = new int[10];
        int[] scount = new int[10];
        for(int i =0;i<secret.length();i++){
            if(secret.charAt(i) == guess.charAt(i))
            {
                x++;
            }
            gcount[(int)(secret.charAt(i))-'0']++;
            scount[(int)(guess.charAt(i))-'0']++;
        }
        for(int j = 0; j<scount.length;j++){
            total+=Math.min(scount[j],gcount[j]);   
        }
        return x+"A"+(total-x)+"B";
        
    }
}
