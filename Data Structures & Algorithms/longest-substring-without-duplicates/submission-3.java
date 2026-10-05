class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int n = s.length();
        int[] freq = new int[256];
        int left = 0, right =0;

        while(right < n){
            freq[s.charAt(right)]++;
            while(freq[s.charAt(right)] > 1){
                freq[s.charAt(left)]--;
                left++;
            }
            max = Math.max(max,right-left+1);
            right++;
        }

        return max;
    }


}
