class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> count = new HashMap<String,Integer>();
        PriorityQueue<String> pq = new PriorityQueue<String>((a,b)->{
            int countA = count.get(a);
            int countB = count.get(b);
            if(countA == countB){
                return b.compareTo(a);
            }
            return countA-countB;
            
        });
        for(String word : words){
            count.put(word,count.getOrDefault(word,0)+1);
        }
        for(String word : count.keySet()){
            pq.offer(word);
            if(pq.size()>k){
                pq.poll();
            }
        }
        List<String> ans = new ArrayList<String>();
        while(pq.size()!=0){
            ans.add(pq.peek());
            pq.poll();
        }
        Collections.reverse(ans);
        return ans;
    }
}
