class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            sb.append(str.length()).append("#").append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int numStartIndex = 0;
        while(numStartIndex<str.length()){
            int hashIndex = str.indexOf("#",numStartIndex);

            int wordLength = Integer.parseInt(str.substring(numStartIndex,hashIndex));
            int wordStart = hashIndex+1;
            int wordEnd = wordStart+wordLength;

            String word = str.substring(wordStart,wordEnd);
            result.add(word);
            numStartIndex = wordEnd;
        }

        return result;
    }
}
