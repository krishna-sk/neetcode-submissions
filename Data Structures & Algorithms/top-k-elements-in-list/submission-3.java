class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int n = nums.length;
        List<Integer>[] bucket = new List[n+1];

        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int bucketIndex = entry.getValue();
            List<Integer> bucketList = bucket[bucketIndex];
            if (bucketList == null) {
                bucketList = new ArrayList<>();
                bucket[bucketIndex] = bucketList;
            }
            bucketList.add(entry.getKey());
        }

        int[] result = new int[k];
        int index = 0;

        for (int bucketIndex = n; bucketIndex >= 0; bucketIndex--) {
            List<Integer> bucketList = bucket[bucketIndex];
            if (bucketList != null) {
                for (int i = 0; i < bucketList.size(); i++) {
                    result[index++] = bucketList.get(i);
                    if (index == k) {
                        break;
                    }
                }
            }
            if (index == k) {
                break;
            }
        }

        return result;
    }
}
