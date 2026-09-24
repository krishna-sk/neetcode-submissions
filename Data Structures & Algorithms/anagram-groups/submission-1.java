class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> anagramsGroup = new HashMap<>();
        List<List<String>> result;;
        for(String word : strs){
            String key = getKey(word);
            List<String> anagrams = anagramsGroup.computeIfAbsent(key, k -> new ArrayList<String>());
            anagrams.add(word);
        }

        result = anagramsGroup.entrySet().stream().map(entry -> entry.getValue()).toList();
        return result;
    }

    public String getKey(String word){
        int[] freq = new int[26];
        StringBuilder key = new StringBuilder();
        int n = word.length();

        for(int i=0;i<n;i++){
            freq[word.charAt(i)-'a']++;
        }

        for(int i=0;i<26;i++){
            if(freq[i]!=0){
                key.append((char)('a'+i)).append(freq[i]);
            }
        }
        return key.toString();
    }
}
