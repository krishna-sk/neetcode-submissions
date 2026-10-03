class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int[] leftProduct = new int[n];
        int[] rightProduct = new int[n];
        leftProduct[0] = 1;
        for(int i=1;i<n;i++){
            leftProduct[i] = leftProduct[i-1] * nums[i-1];
        }
        // nums  [1, 2, 4, 5]
        // left  [1, 1, 2, 8]
        // right [40,20,5, 1]
        rightProduct[n-1] = 1;
        for(int i=n-2;i>=0;i--){
            rightProduct[i] = rightProduct[i+1] * nums[i+1];
        }

        for(int i=0;i<n;i++){
            result[i] = rightProduct[i] * leftProduct[i];
        }

        return result;
    }
}  
