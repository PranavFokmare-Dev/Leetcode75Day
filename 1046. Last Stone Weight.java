class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq =new PriorityQueue<Integer>((a,b)->{return b-a;});
        for(int stone : stones){
            pq.add(stone);
        }
        while(pq.size()>1){
            int x = pq.poll();
            int y = (pq.size()>0)?pq.poll():0;
            if(x!=y){
                pq.add(x-y);
            }
        }
        if(pq.size()==0){
            return 0;
        }
        return pq.poll();
    }
}
