class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> groupOfAnagrams = new HashMap<>();

        for(String word : strs){
            String key = generateKey(word);
            groupOfAnagrams.computeIfAbsent(key, k-> new ArrayList<>())
            .add(word);
        }

        return new ArrayList<>(groupOfAnagrams.values());
    }

    public String generateKey(String word){
        StringBuilder key = new StringBuilder();
        int[] freq = new int[26];

        for(int i=0;i<word.length();i++){
            freq[word.charAt(i)-'a']++;    
        }

        for(int count : freq){
            key.append(count).append("#");
        }

        return key.toString();
    }
}
