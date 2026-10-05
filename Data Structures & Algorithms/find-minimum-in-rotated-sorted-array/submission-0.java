class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int low = 0, high = n - 1, mid;
        while (low < high) {
            if (nums[low] < nums[high]) {
                return nums[low];
            }
            mid = (high - low) / 2 + low;
            if (nums[low] <= nums[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return nums[low];
    }
}