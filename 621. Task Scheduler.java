class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] frequency = new int[26];
        for(char t : tasks){
            frequency[t-'A']++;
        }
        
        int totalTasks = tasks.length;
        LinkedList<Character> q = new LinkedList<Character>();
        int[] windowFreq = new int[26];
        int secs = 0;
        while(totalTasks !=0){
            char p = getMaxFreqProcess(frequency,windowFreq);
            if(p!='-'){
                
                frequency[p-'A']--;
                totalTasks--;
                windowFreq[p-'A']++;
            }
            q.addLast(p);
            
            if(q.size() == n+1){
                
                char x = q.getFirst();
                if(x!='-')
                windowFreq[x-'A']--;
                q.removeFirst();
               
            }
            secs++;
        }
        return secs;
    }
    private char getMaxFreqProcess(int[] frequency, int[] windowFreq){
        char x = '-';
        int max = 0;
        for(int i =0; i<frequency.length;i++){
            if(frequency[i]>0 && windowFreq[i]==0){
                if(max < frequency[i]){
                    max = frequency[i];
                    x = (char)('A'+i);
                }
            }
        }
        return x;
        
        
    }
}
