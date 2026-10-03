class Solution {

    public String encode(List<String> strs) {
        StringBuilder encodedString = new StringBuilder();
        for(String str : strs){
            encodedString.append(str.length()).append("#").append(str);
        }

        return encodedString.toString();
    }

    public List<String> decode(String str) {
        /**
            5# Hello 5# W  o r  l  d
            01 23456 78 9 10 11 12 13
        */
        List<String> result = new ArrayList<>();
        if(str == null){
            return result;
        }

        int startIndex = 0;
        while(startIndex < str.length()){
            int hashIndex = str.indexOf('#',startIndex);
            int wordLength = Integer.parseInt(str.substring(startIndex,hashIndex));
            int wordStart = hashIndex + 1;
            int wordEnd = wordStart+ wordLength;
            result.add(str.substring(wordStart,wordEnd));
            startIndex = wordEnd;
        }

        return result;
    }
}

// 5Hello 0 5World
// 012345 6 7    12  

