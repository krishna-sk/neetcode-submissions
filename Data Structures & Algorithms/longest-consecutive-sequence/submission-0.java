class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n==0){
            return 0;
        }
        Arrays.sort(nums);
        int count = 1, maxCount = 1;;
        for(int i=0;i<n-1;i++){
            if(nums[i] +1 == nums[i+1]){
                count++;
                maxCount = Math.max(maxCount,count);
            }else if(nums[i] != nums[i+1]){
                count = 1;
            }
        }
        return maxCount;
    }
}
