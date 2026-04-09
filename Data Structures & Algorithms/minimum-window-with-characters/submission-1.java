class Solution {
    public String minWindow(String s, String t) {
        int m = t.length(),n = s.length();

        if(m>n){
            return "";
        }
        int[] freq = new int[256];

        for(int i=0;i<m;i++){
            freq[t.charAt(i)]++;
        }

        int left = 0, right = 0, count = 0;
        int minLength = Integer.MAX_VALUE, startIndex = 0;


        while(right <n){

            if(freq[s.charAt(right)]>0){
                count++;
            }

            freq[s.charAt(right)]--;
            
            while(count == m){
                if(right-left+1 < minLength){
                    startIndex = left;
                    minLength = right-left+1;
                }

                freq[s.charAt(left)]++;
                if(freq[s.charAt(left)]>0){
                    count--;
                }
                left++;
            }

            right++;
        }

        if(minLength == Integer.MAX_VALUE){
            return "";
        }
        return s.substring(startIndex,startIndex+minLength);
    }
}
