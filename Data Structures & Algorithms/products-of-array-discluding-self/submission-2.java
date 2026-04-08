class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int[] left = new int[n];

        left[0] = 1;
        result[n-1] = 1;

        for(int i=1;i<n;i++){
            left[i] = left[i-1] * nums[i-1];
            result[n-1-i] = result[n-i] * nums[n-i];
        }

        for(int i=0;i<n;i++){
            result[i] = left[i] * result[i];
        }

        return result;
    }
}  

