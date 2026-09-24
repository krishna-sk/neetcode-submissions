class Solution {
    public boolean hasDuplicate(int[] nums) {
        int n = nums.length;
        Set<Integer> visited = new HashSet<>();

        for(int i=0;i<n;i++){
            if(visited.contains(nums[i])){
                return true;
            }
            visited.add(nums[i]);
        }
        return false;
    }
}