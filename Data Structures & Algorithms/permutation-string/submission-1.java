class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq = new int[26];
        int m = s1.length(), n = s2.length();

        if(m>n){
            return false;
        }

        for(int i=0;i<m;i++){
            freq[s1.charAt(i)-'a']++;
            freq[s2.charAt(i)-'a']--;
        }

        if(isAllZeros(freq)){
            return true;
        }

        int left = 0, right = m;
        while(right<n){
            freq[s2.charAt(right++)-'a']--;
            freq[s2.charAt(left++)-'a']++;
            if(isAllZeros(freq)){
                return true;
            }
        }

        return false;
        
    }

    public boolean isAllZeros(int[] freq){
        for(int count : freq){
            if(count != 0){
                return false;
            }
        }
        return true;
    }
}

/**
    a b c d  e  f l
    0 1 0 0 -1 0 0
*/
