class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1,p2) -> p1.count-p2.count); 
        int[] result = new int[k];
        
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            pq.offer(new Pair(entry.getKey(), entry.getValue()));
            if(pq.size()>k){
                pq.poll();
            }
        }

        int index = k-1; 

        while(index>=0 && !pq.isEmpty()){
            result[index--] = pq.poll().value;
        }

        return result;
    }
}

class Pair{
    int value;
    int count;

    public Pair(int value,int count){
        this.value = value;
        this.count = count;
    }
}
