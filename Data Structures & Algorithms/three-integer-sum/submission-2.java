class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<Integer> temp;
        Set<Integer> cache;
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            cache = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                int target = -(nums[i] + nums[j]);
                if (cache.contains(target)) {
                    temp = Arrays.asList(nums[i], nums[j], target);
                    Collections.sort(temp);
                    set.add(temp);
                }
                cache.add(nums[j]);
            }
        }

        return new ArrayList<>(set);
    }
}
