class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int max = 0, maxFreq = 0;
        int left = 0, right = 0;
        int[] freq = new int[26];
        while (right < n) {
            int curCharIndex = s.charAt(right) - 'A';
            freq[curCharIndex]++;
            maxFreq = Math.max(maxFreq, freq[curCharIndex]);
            int count = (right - left + 1) - maxFreq;
            while (count > k) {
                int prevCharIndex = s.charAt(left) - 'A';
                freq[prevCharIndex]--;
                left++;
                maxFreq = findMaxFreq(freq);
                count = (right - left + 1) - maxFreq;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }

        return max;
    }

    public int findMaxFreq(int[] freq) {
        int max = 0;
        for (int i = 0; i < 26; i++) {
            max = Math.max(max, freq[i]);
        }
        return max;
    }
}
