class Solution {
    public int[] productExceptSelf(int[] nums) {
        int totalProduct = 1;
        int countOfZeros = 0;
        int n = nums.length;
        int[] result = new int[n];
        for (int num : nums) {
            if (num == 0) {
                countOfZeros++;
            } else {
                totalProduct *= num;
            }
        }

        if (countOfZeros > 1) {
            return result;
        }

        for (int i = 0; i < n; i++) {
            if (countOfZeros == 1) {
                if (nums[i] == 0) {
                    result[i] = totalProduct;
                }
            } else {
                result[i] = totalProduct / nums[i];
            }
        }

        return result;
    }
}
