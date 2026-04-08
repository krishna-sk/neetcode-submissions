class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        long product = 1;
        result[n-1] = 1;

        for(int i=n-2;i>=0;i--){
            result[i] = result[i+1] * nums[i+1];
        }

        for(int i=0;i<n;i++){
            result[i] = (int) product * result[i];
            product *=nums[i]; 
        }

        return result;
    }
}  

