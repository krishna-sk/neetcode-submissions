class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), max = 0;
        int left = 0, right = 0;
        int[] lastSeenAt = new int[256];
        Arrays.fill(lastSeenAt, -1);

        while (right < n) {
            char currChar = s.charAt(right);
            int prevIndex = lastSeenAt[currChar];
            if (prevIndex >= left) {
                left = prevIndex + 1;
            }
            max = Math.max(right - left + 1, max);
            lastSeenAt[currChar] = right;
            right++;
        }

        return max;
    }
}
