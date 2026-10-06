class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        if (m > n) {
            return false;
        }

        int[] freq = new int[26];
        for (int i = 0; i < m; i++) {
            freq[s1.charAt(i) - 'a']--;
            freq[s2.charAt(i) - 'a']++;
        }

        if (containsZerosOnly(freq)) {
            return true;
        }

        int left = 0, right = m;
        while (right < n) {
            freq[s2.charAt(left) - 'a']--;
            freq[s2.charAt(right) - 'a']++;
            if (containsZerosOnly(freq)) {
                return true;
            }
            left++;
            right++;
        }
        return false;
    }

    public boolean containsZerosOnly(int[] freq) {
        for (int count : freq) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}