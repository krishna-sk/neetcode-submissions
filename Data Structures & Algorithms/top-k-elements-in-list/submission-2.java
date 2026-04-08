class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer>[] bucketList = new List[n+1];
        int[] result = new int[k];
        
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int freq = entry.getValue();
            if(bucketList[freq] == null){
                bucketList[freq] = new ArrayList<>();
            }
            bucketList[freq].add(entry.getKey());
        }

        int index =0; 

        for(int i=n;i>=0 && index <k;i--){
            if(bucketList[i] != null){
               for(int num : bucketList[i]){
                 result[index++] = num;
               }
            }
        }

        return result;
    }
}

