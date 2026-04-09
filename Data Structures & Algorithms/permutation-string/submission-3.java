class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq = new int[26];
        int m = s1.length(), n = s2.length();
        int count = 0;

        if(m>n){
            return false;
        }

        for(int i=0;i<m;i++){
            freq[s1.charAt(i)-'a']++;
            freq[s2.charAt(i)-'a']--;
        }

        for(int counter : freq){
            if(counter == 0){
                count++;
            }
        }

        if(count == 26){
            return true;
        }

        int left = 0, right = m;
        while(right<n){
            int rightIndex = s2.charAt(right)-'a';
            int leftIndex = s2.charAt(left)-'a';

            freq[rightIndex]--;
                    
            if(freq[rightIndex] == 0){
                count++;
            }else if(freq[rightIndex]==-1){
                count--;
            }

            freq[leftIndex]++;

            if(freq[leftIndex] == 0){
                count++;
            }else if(freq[leftIndex]==1){
                count--;
            }

            right++;
            left++;

            if(count ==26){
                return true;
            }
        }

        return false;
        
    }

}

/**
    a b c d  e  f l
    0 1 0 0 -1 0 0
*/
