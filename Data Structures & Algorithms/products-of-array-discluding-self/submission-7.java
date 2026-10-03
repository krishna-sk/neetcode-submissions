class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int[] rightProduct = new int[n];
        result[0] = 1;

        for(int i=1;i<n;i++){
            result[i] = result[i-1] * nums[i-1];
        }
        // nums   [1, 2, 4, 5]
        // result [1, 1, 2, 8]
        // result [40,20,10,8]
        int right = nums[n-1];
        for(int i=n-2;i>=0;i--){
            result[i] = result[i] * right;
            right*= nums[i];
        }

        return result;
    }
}  