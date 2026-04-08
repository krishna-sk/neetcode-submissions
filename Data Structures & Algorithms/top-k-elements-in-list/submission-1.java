class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b) -> a.getValue()-b.getValue()); 
        int[] result = new int[k];
        
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            pq.offer(entry);
            if(pq.size()>k){
                pq.poll();
            }
        }

        int index = k-1; 

        while(index>=0 && !pq.isEmpty()){
            result[index--] = pq.poll().getKey();
        }

        return result;
    }
}

