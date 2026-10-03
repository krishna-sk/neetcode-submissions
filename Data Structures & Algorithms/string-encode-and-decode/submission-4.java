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
/**
    5 Hello 5 W o r l  d  0
    0 12345 6 7 8 9 10 11 12

*/
        int startIndex = 0;

        while(startIndex < str.length()){
            int hashIndex = startIndex;
            while(str.charAt(hashIndex) != '#'){
                hashIndex++;
            }
            int length =   Integer.parseInt(str.substring(startIndex,hashIndex));
            int wordStart = hashIndex + 1;
            int wordEnd = wordStart + length;
            result.add(str.substring(wordStart,wordEnd));
            startIndex = wordEnd;
        }

        return result;
    }
}
