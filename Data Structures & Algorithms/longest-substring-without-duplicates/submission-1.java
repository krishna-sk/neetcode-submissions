class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), left = 0, right=0, maxLength=0;
        int[] lastSeenIndex = new int[256];
        Arrays.fill(lastSeenIndex,-1);

        while(right<n){
            char currentChar = s.charAt(right);
            int prevIndex = lastSeenIndex[currentChar];
            if(prevIndex>=left){
                left = prevIndex+1;
            }
            lastSeenIndex[currentChar] = right;
            maxLength = Math.max(maxLength, right - left + 1);
            right++; 
        }

        return maxLength;
    }
}
