class Solution {
    public int characterReplacement(String s, int k) {
        int maxFreq = 0, left =0, right =0, n = s.length();
        int[] freq = new int[26];
        int maxLength = 0;

        while(right <n){
            
            freq[s.charAt(right)-'A']++;
            maxFreq = Math.max(maxFreq,freq[s.charAt(right)-'A']);

            int subStringLength = right-left+1;
            int changes = subStringLength - maxFreq;
            
            if(changes>k){
                freq[s.charAt(left)-'A']--;
                left++;
            }

            maxLength = Math.max(maxLength,right-left+1);
            right++;
        }

        return maxLength;
    }
    
}


