class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n==0){
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        int maxCount = 0;
        for(int num : set){
            if(set.contains(num-1)){
                // the current num is not starting point, skip this
                continue;
            }else{
                // we found the starting number of the sequence, start finding the sequence.
                int count = 1;
                int lookingFor = num+1;
                while(set.contains(lookingFor)){
                    count++;
                    lookingFor++;
                }
                maxCount = Math.max(count,maxCount);
            }
        }
        return maxCount;
    }
}
