class Solution {
    public boolean hasDuplicate(int[] nums) {
        int n = nums.length;
        Set<Integer> visited = new HashSet<>();
        for(int num : nums){
            if(!visited.add(num)){
                return true;
            }
        }
        return false;
    }
}