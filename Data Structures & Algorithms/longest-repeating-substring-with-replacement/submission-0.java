class Solution {
    public int characterReplacement(String s, int k) {
        int maxFreq = 0, left =0, right =0, n = s.length();
        int[] freq = new int[26];
        int maxLength = 0;

        while(right <n){
            int currentCharIndex = s.charAt(right)-'A';
            freq[currentCharIndex]++;
            maxFreq = Math.max(maxFreq,freq[currentCharIndex]);

            int subStringLength = right-left+1;
            int changes = subStringLength - maxFreq;
            
            while(changes>k){
                int prevCharIndex = s.charAt(left)-'A';
                freq[prevCharIndex]--;
                left++;
                changes = (right-left+1) - getMaxFreq(freq);
            }

            maxLength = Math.max(maxLength,right-left+1);
            right++;
        }

        return maxLength;
    }
    
    public int getMaxFreq(int[] freq){
        int maxFreq = 0;
        for(int count : freq){
            maxFreq = Math.max(maxFreq,count);
        }
        return maxFreq;
    }
}


